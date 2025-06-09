package com.kotlinxkyle.fan.ui.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.kotlinxkyle.fan.data.Sentence
import com.kotlinxkyle.fan.data.Word

@Composable
fun MainScreen() {
    // This state will eventually be hoisted into a ViewModel
    var sentence by remember { mutableStateOf(Sentence()) }

    // Dummy data - this will come from the ViewModel later
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
    val suggestions = listOf(
        Word("please", "", "interjection"),
        Word("thank you", "", "interjection")
    )

    Column(modifier = Modifier.fillMaxSize()) {
        CompositionBar(sentence = sentence)
        SuggestionBar(suggestions = suggestions, onSuggestionClick = {
            // Logic to add suggestion to sentence
            val newWords = sentence.words + it
            sentence = sentence.copy(words = newWords)
        })
        WordGridView(words = wordList, onWordClick = {
            // Logic to add word to sentence
            val newWords = sentence.words + it
            sentence = sentence.copy(words = newWords)
        })
    }
}
