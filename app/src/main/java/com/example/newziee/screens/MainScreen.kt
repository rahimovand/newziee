package com.example.newziee.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.newziee.ui.theme.NewzieeTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues)
        ) {

        }
    }
}

@Preview()
@Composable
fun DarkMode() {
    NewzieeTheme(
        darkTheme = true
    ) {
        MainScreen()
    }
}

@Preview()
@Composable
fun LightMode() {
    NewzieeTheme(
        darkTheme = false
    ) {
        MainScreen()
    }
}