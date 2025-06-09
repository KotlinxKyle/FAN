package com.kotlinxkyle.fan.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kotlinxkyle.fan.viewmodel.MainViewModel

@Composable
fun MainScreen(
    mainViewModel: MainViewModel = viewModel()
) {
    val uiState by mainViewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        CompositionBar(
            sentence = uiState.sentence,
            onClearClick = { mainViewModel.clearSentence() }
        )
        SuggestionBar(
            suggestions = uiState.suggestions,
            onSuggestionClick = { word ->
                mainViewModel.addWordToSentence(word)
            }
        )
        WordGridView(
            words = uiState.allWords,
            onWordClick = { word ->
                mainViewModel.addWordToSentence(word)
            }
        )
    }
}
