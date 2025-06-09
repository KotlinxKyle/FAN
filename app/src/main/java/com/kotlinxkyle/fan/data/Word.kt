package com.kotlinxkyle.fan.data
/**
 * Represents a single word in the AAC system.
 *
 * @property text The actual word to be spoken or displayed.
 * @property imageIdentifier A string that points to an image resource.
 * This could be a local drawable name or a remote URL for Coil.
 * @property category The category the word belongs to (e.g., "Food", "Actions").
 */
data class Word(
    val text: String,
    val imageIdentifier: String,
    val category: String
)
