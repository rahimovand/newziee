package com.example.newziee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newziee.ui.theme.NewzieeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewzieeTheme {

            }
        }
    }
}
\dd
d
d
d
d
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewzieeTheme {

    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreviewDark() {
    NewzieeTheme(darkTheme = true) {

    }
}