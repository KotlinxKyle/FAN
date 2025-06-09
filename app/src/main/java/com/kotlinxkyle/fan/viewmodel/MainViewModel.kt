package com.kotlinxkyle.fan.viewmodel

import androidx.lifecycle.ViewModel
import com.kotlinxkyle.fan.data.Sentence
import com.kotlinxkyle.fan.data.Word
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * Represents the state of the MainScreen.
 */
data class MainUiState(
    val sentence: Sentence = Sentence(),
    val suggestions: List<Word> = emptyList(),
    val allWords: List<Word> = emptyList()
)

class MainViewModel : ViewModel() {

    // Private mutable state flow
    private val _uiState = MutableStateFlow(MainUiState())
    // Public read-only state flow for the UI to observe
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        // In a real app, this would load from a database or network.
        // For now, we use the same dummy data as before.
        val wordList = listOf(
            Word("I", "", "pronoun"),
            Word("want", "", "verb"),
            Word("a", "", "article"),
            Word("the", "", "article"),
            Word("ball", "", "noun"),
            Word("play", "", "verb"),
            Word("go", "", "verb"),
            Word("outside", "", "noun")
        )
        val suggestionsList = listOf(
            Word("please", "", "interjection"),
            Word("thank you", "", "interjection")
        )

        _uiState.value = MainUiState(allWords = wordList, suggestions = suggestionsList)
    }

    /**
     * Adds a word to the current sentence.
     */
    fun addWordToSentence(word: Word) {
        _uiState.update { currentState ->
            val newWords = currentState.sentence.words + word
            currentState.copy(sentence = Sentence(words = newWords))
        }
    }

    /**
     * Clears all words from the current sentence.
     */
    fun clearSentence() {
        _uiState.update { it.copy(sentence = Sentence()) }
    }

    // `speakSentence()` and `fetchSuggestions()` will be implemented in a later phase.
}
