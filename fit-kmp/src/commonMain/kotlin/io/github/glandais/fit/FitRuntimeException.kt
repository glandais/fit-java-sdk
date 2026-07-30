// Hand-written multiplatform port of FitRuntimeException.java — keep in sync (see overrides/hashes.json).
package io.github.glandais.fit

class FitRuntimeException : RuntimeException {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
    constructor(cause: Throwable) : super(cause)
}
