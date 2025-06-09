package com.kotlinxkyle.fan.data
/**
 * Represents a sequence of words that form a sentence to be spoken.
 *
 * @property words The list of Word objects that make up the sentence.
 */
data class Sentence(
    val words: List<Word> = emptyList()
)
