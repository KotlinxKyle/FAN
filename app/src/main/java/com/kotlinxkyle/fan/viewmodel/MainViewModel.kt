package com.kotlinxkyle.fan.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.kotlinxkyle.fan.data.Sentence
import com.kotlinxkyle.fan.data.Word
import com.kotlinxkyle.fan.tts.TtsHelper
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

// Change ViewModel to AndroidViewModel to get the application context
class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    private val ttsHelper = TtsHelper(application)

    init {
        loadInitialData()
    }

    private fun loadInitialData() {
        // ... (your existing data loading logic)
        val wordList = listOf(
            Word("I", "", "pronoun"), Word("want", "", "verb"), Word("a", "", "article"),
            Word("the", "", "article"), Word("ball", "", "noun"), Word("play", "", "verb"),
            Word("go", "", "verb"), Word("outside", "", "noun")
        )
        val suggestionsList = listOf(
            Word("please", "", "interjection"), Word("thank you", "", "interjection")
        )
        _uiState.value = MainUiState(allWords = wordList, suggestions = suggestionsList)
    }

    fun addWordToSentence(word: Word) {
        _uiState.update { currentState ->
            val newWords = currentState.sentence.words + word
            currentState.copy(sentence = Sentence(words = newWords))
        }
    }

    fun clearSentence() {
        _uiState.update { it.copy(sentence = Sentence()) }
    }

    /**
     * Speaks the current sentence using the TtsHelper.
     */
    fun speakSentence() {
        val sentenceText = uiState.value.sentence.words.joinToString(" ") { it.text }
        if (sentenceText.isNotBlank()) {
            ttsHelper.speak(sentenceText)
        }
    }

    /**
     * Called when the ViewModel is about to be destroyed.
     */
    override fun onCleared() {
        super.onCleared()
        ttsHelper.shutdown()
    }
}