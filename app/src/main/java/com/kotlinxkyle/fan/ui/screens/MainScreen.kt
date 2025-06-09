package com.kotlinxkyle.fan.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kotlinxkyle.fan.viewmodel.MainViewModel

@Composable
fun MainScreen(
    // The modifier parameter is no longer needed for padding
    mainViewModel: MainViewModel = viewModel()
) {
    val uiState by mainViewModel.uiState.collectAsState()

    // Apply padding that accounts for all system bars (status, navigation).
    // This is a more direct way to handle the insets from edge-to-edge content.
    Column(modifier = Modifier.fillMaxSize().safeDrawingPadding()) {
        CompositionBar(
            sentence = uiState.sentence,
            onSpeakClick = { mainViewModel.speakSentence() },
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
