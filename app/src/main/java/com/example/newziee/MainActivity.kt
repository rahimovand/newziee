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
import com.example.newziee.screens.MainScreen
import com.example.newziee.ui.theme.NewzieeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewzieeTheme {
                MainScreen()
            }
        }
    }
}

/*

Plans are simple just contact saver up which can be

-edited ,
-saved ,
-removed

SharedPreferences for local database

Simple , when nothing is written some simple type of triggering areas
in a outlined areas , would be awesome for sure

 */