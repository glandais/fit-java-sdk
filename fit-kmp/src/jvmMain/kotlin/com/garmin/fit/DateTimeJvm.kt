// Multiplatform support file (no Java counterpart).
// JVM-only convenience extensions restoring the historical java.util.Date / java.time.Instant
// portions of the DateTime and LocalDateTime APIs (see DESIGN.md §3).
package com.garmin.fit

fun DateTime.getDate(): java.util.Date = java.util.Date(getUnixEpochMillis())

fun DateTime.getInstant(): java.time.Instant = java.time.Instant.ofEpochMilli(getUnixEpochMillis())

fun DateTime.Companion.from(instant: java.time.Instant): DateTime =
    DateTime.fromUnixEpochMillis(instant.toEpochMilli())

fun DateTime.Companion.from(date: java.util.Date): DateTime =
    DateTime.fromUnixEpochMillis(date.time)

fun LocalDateTime.getDate(): java.util.Date = java.util.Date(getUnixEpochMillis())

fun LocalDateTime.Companion.from(date: java.util.Date): LocalDateTime =
    LocalDateTime.fromUnixEpochMillis(date.time)
