package com.kotlinxkyle.fan.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kotlinxkyle.fan.data.Sentence

@Composable
fun CompositionBar(
    sentence: Sentence,
    onSpeakClick: () -> Unit, // Add handler for speaking
    onClearClick: () -> Unit
) {
    val sentenceText = sentence.words.joinToString(" ") { it.text }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(Color.LightGray)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = sentenceText,
            fontSize = 20.sp,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = onSpeakClick) { // The new Speak Button
            Text(text = "Speak")
        }
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = onClearClick) {
            Text(text = "Clear")
        }
    }
}
