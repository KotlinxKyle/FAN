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
        // In a real app, this would load from a database or network.
        // This is the new, more comprehensive core vocabulary list.
        val wordList = listOf(
            // Pronouns
            Word("I", "", "pronoun"), Word("you", "", "pronoun"), Word("he", "", "pronoun"),
            Word("she", "", "pronoun"), Word("it", "", "pronoun"), Word("we", "", "pronoun"),
            Word("they", "", "pronoun"), Word("me", "", "pronoun"), Word("my", "", "pronoun"),

            // Verbs
            Word("want", "", "verb"), Word("go", "", "verb"), Word("play", "", "verb"),
            Word("eat", "", "verb"), Word("drink", "", "verb"), Word("see", "", "verb"),
            Word("like", "", "verb"), Word("love", "", "verb"), Word("help", "", "verb"),
            Word("stop", "", "verb"), Word("look", "", "verb"), Word("listen", "", "verb"),
            Word("open", "", "verb"), Word("close", "", "verb"), Word("give", "", "verb"),
            Word("get", "", "verb"), Word("feel", "", "verb"),

            // Nouns (People, Places)
            Word("mom", "", "noun"), Word("dad", "", "noun"), Word("teacher", "", "noun"),
            Word("friend", "", "noun"), Word("home", "", "noun"), Word("school", "", "noun"),
            Word("outside", "", "noun"), Word("park", "", "noun"),

            // Nouns (Food)
            Word("apple", "", "noun"), Word("cookie", "", "noun"), Word("juice", "", "noun"),
            Word("water", "", "noun"), Word("snack", "", "noun"), Word("milk", "", "noun"),
            Word("food", "", "noun"),

            // Nouns (Things)
            Word("ball", "", "noun"), Word("book", "", "noun"), Word("game", "", "noun"),
            Word("TV", "", "noun"), Word("phone", "", "noun"), Word("toilet", "", "noun"),
            Word("bed", "", "noun"), Word("light", "", "noun"),

            // Adjectives
            Word("big", "", "adjective"), Word("little", "", "adjective"), Word("good", "", "adjective"),
            Word("bad", "", "adjective"), Word("happy", "", "adjective"), Word("sad", "", "adjective"),
            Word("tired", "", "adjective"), Word("hot", "", "adjective"), Word("cold", "", "adjective"),
            Word("loud", "", "adjective"), Word("quiet", "", "adjective"),

            // Social & Other
            Word("more", "", "social"), Word("finished", "", "social"), Word("please", "", "social"),
            Word("thank you", "", "social"), Word("sorry", "", "social"), Word("yes", "", "social"),
            Word("no", "", "social"), Word("hello", "", "social"), Word("goodbye", "", "social")
        )
        val suggestionsList = listOf(
            Word("I want", "", "phrase"),
            Word("I feel", "", "phrase"),
            Word("Let's go", "", "phrase")
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