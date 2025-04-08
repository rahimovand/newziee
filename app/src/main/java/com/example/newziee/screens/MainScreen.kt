package com.example.newziee.screens


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.newziee.SharedPref.PreferenceManager
import com.example.newziee.screens.component.AddFloatingActionButton
import com.example.newziee.screens.component.EachItemList
import com.example.newziee.screens.component.SaveInformation
import com.example.newziee.ui.theme.NewzieeTheme


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {

    var isClicked by rememberSaveable { mutableStateOf(false) }
    val obj = PreferenceManager(LocalContext.current)
    var list = obj.getAllContact()

    Scaffold(
        floatingActionButton = {
            AddFloatingActionButton(
                isClicked = {
                    isClicked = it
                }
            )
        }
    ) { paddingValues ->
        EachItemList(
            modifier = modifier.padding(paddingValues),
            list = list
        )
        if (isClicked) {
            SaveInformation(
                onDismissRequest = {
                    isClicked = it
                },
                takeNewContact = {
                    obj.addContact(it)
                    list = obj.getAllContact()
                }
            )
        }   // alertDialog pops up and saves information
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