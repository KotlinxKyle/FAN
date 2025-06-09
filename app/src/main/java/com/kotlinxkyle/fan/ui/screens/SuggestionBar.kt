package com.kotlinxkyle.fan.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kotlinxkyle.fan.data.Word

@Composable
fun SuggestionBar(suggestions: List<Word>, onSuggestionClick: (Word) -> Unit) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(suggestions) { suggestion ->
            Button(
                onClick = { onSuggestionClick(suggestion) },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(text = suggestion.text)
            }
        }
    }
}
