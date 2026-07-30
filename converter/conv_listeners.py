#!/usr/bin/env python3
"""
Converts trivial listener interfaces (one abstract method) from Java to Kotlin.
Contract: def convert(files: list[Path], out_dir: Path) -> list[Path]
Output: fun interface files to out_dir
"""

import re
from pathlib import Path


# Java to Kotlin type mapping
TYPE_MAPPING = {
    "byte": "Byte",
    "Byte": "Byte?",
    "short": "Short",
    "Short": "Short?",
    "int": "Int",
    "Integer": "Int?",
    "long": "Long",
    "Long": "Long?",
    "float": "Float",
    "Float": "Float?",
    "double": "Double",
    "Double": "Double?",
    "boolean": "Boolean",
    "Boolean": "Boolean?",
    "String": "String?",
}


def map_type(java_type: str) -> str:
    """Map Java type to Kotlin type."""
    java_type = java_type.strip()

    # Check if it's in the explicit mapping
    if java_type in TYPE_MAPPING:
        return TYPE_MAPPING[java_type]

    # For custom types (Mesg, RecordMesg, MesgDefinition, etc.), no mapping needed
    # They are in the same package
    return java_type


def extract_interface_info(java_source: str, filename: str) -> dict | None:
    """
    Extract interface name and method signature from Java listener source.
    Returns dict with 'name', 'method_name', 'param_type', 'param_name', or None if not a valid listener.
    """
    # Find interface declaration with its body
    interface_match = re.search(
        r'public\s+interface\s+(\w+)\s*\{([^}]+)\}',
        java_source,
        re.DOTALL
    )
    if not interface_match:
        return None

    interface_name = interface_match.group(1)
    interface_body = interface_match.group(2)

    # Find the abstract method within the interface body
    # Pattern: visibility + return_type + method_name + (params)
    # Remove comments first
    body_without_comments = re.sub(r'//.*?$', '', interface_body, flags=re.MULTILINE)

    # Find methods: void or type name(params);
    method_pattern = r'(?:public\s+)?(?:void|[\w<>,\[\]\?]+)\s+(\w+)\s*\(\s*([^)]*)\s*\)\s*;'
    methods = list(re.finditer(method_pattern, body_without_comments))

    # Filter out methods that are part of Object
    methods = [m for m in methods if m.group(1) not in ['equals', 'hashCode', 'toString', 'clone']]

    if len(methods) != 1:
        # Not a trivial listener interface
        return None

    method_match = methods[0]
    method_name = method_match.group(1)
    params_str = method_match.group(2).strip()

    if not params_str:
        # No parameters
        return None

    # Parse parameters (typically one parameter for listeners)
    # Pattern: type param_name (handle arrays like MesgDefinition[])
    param_pattern = r'([\w<>,\[\]]+)\s+(\w+)'
    param_matches = re.findall(param_pattern, params_str)

    if len(param_matches) != 1:
        # Trivial listener has exactly one parameter
        return None

    param_type, param_name = param_matches[0]

    return {
        'name': interface_name,
        'method_name': method_name,
        'param_type': param_type,
        'param_name': param_name,
    }


def generate_kotlin_listener(interface_info: dict) -> str:
    """Generate Kotlin fun interface code."""
    interface_name = interface_info['name']
    method_name = interface_info['method_name']
    param_type = map_type(interface_info['param_type'])
    param_name = interface_info['param_name']

    # Generate the Kotlin interface
    kotlin_code = f"""fun interface {interface_name} {{
    fun {method_name}({param_name}: {param_type})
}}
"""
    return kotlin_code


def create_kotlin_file(java_file: Path, interface_info: dict, out_dir: Path) -> Path:
    """
    Create a Kotlin file for the listener interface.
    Returns the Path to the created file.
    """
    kotlin_filename = java_file.stem + ".kt"
    kotlin_path = out_dir / kotlin_filename

    kotlin_code = generate_kotlin_listener(interface_info)

    # Add header
    header = f"""/////////////////////////////////////////////////////////////////////////////////////////////
// Converted from {java_file.name} (Garmin FIT SDK 21.205.0) by converter/convert.py.
// Do NOT edit: re-run `python3 converter/convert.py` to regenerate.
/////////////////////////////////////////////////////////////////////////////////////////////
package io.github.glandais.fit

{kotlin_code}"""

    kotlin_path.write_text(header)
    return kotlin_path


def convert(files: list[Path], out_dir: Path) -> list[Path]:
    """
    Convert trivial listener interfaces from Java to Kotlin.

    Args:
        files: List of Path objects pointing to Java listener files
        out_dir: Output directory for Kotlin files

    Returns:
        List of Path objects for generated Kotlin files
    """
    out_dir.mkdir(parents=True, exist_ok=True)
    generated_files = []

    for java_file in files:
        try:
            java_source = java_file.read_text(encoding='utf-8')
            interface_info = extract_interface_info(java_source, java_file.name)

            if interface_info:
                kotlin_path = create_kotlin_file(java_file, interface_info, out_dir)
                generated_files.append(kotlin_path)
        except Exception as e:
            print(f"Error processing {java_file.name}: {e}", file=__import__('sys').stderr)

    return generated_files


if __name__ == '__main__':
    # Test script - run on sample listener files
    import sys

    # Find listener files in the source directory
    src_dir = Path('/home/glandais/code/perso/fit-java-sdk/src/main/java/com/garmin/fit')
    listener_files = sorted(src_dir.glob('*Listener.java'))

    # Test on first 3 files
    test_files = [
        src_dir / 'RecordMesgListener.java',
        src_dir / 'MesgListener.java',
        src_dir / 'MesgDefinitionListener.java',
    ]

    test_files = [f for f in test_files if f.exists()]

    # Create output directory
    out_dir = Path('/tmp/claude-1000/-home-glandais-code-perso-fit-java-sdk/cffb6990-e804-4739-a500-306e88a5da3a/scratchpad/test_listeners')
    out_dir.mkdir(parents=True, exist_ok=True)

    # Run conversion
    generated = convert(test_files, out_dir)

    print(f"Converted {len(generated)} listener files:")
    for path in generated:
        print(f"  Generated: {path}")
        print(f"  Content:\n{path.read_text()}\n")

    print(f"\nTotal listeners found: {len(listener_files)}")
    print(f"Successfully converted: {len(generated)}")
