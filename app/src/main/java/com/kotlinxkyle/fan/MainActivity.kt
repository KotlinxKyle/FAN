package com.kotlinxkyle.fan

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.kotlinxkyle.fan.ui.screens.MainScreen
import com.kotlinxkyle.fan.ui.theme.FANTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FANTheme {
                // We use Scaffold for top-level layout structure
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Replace the default Greeting with your new MainScreen
                    // The innerPadding is handled by Scaffold, but we don't need it here.
                    MainScreen()
                }
            }
        }
    }
}
