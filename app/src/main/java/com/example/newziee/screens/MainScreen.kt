package com.example.newziee.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newziee.ui.theme.NewzieeTheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    var isClicked by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    isClicked = true
                },
                containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                elevation = FloatingActionButtonDefaults.elevation(
                    defaultElevation = 1.dp,
                    focusedElevation = 0.dp,
                    pressedElevation = 2.dp
                ),

                ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            if (isClicked) {
                SaveInformation(
                    onDismissRequest = {
                        isClicked = it
                    }
                )
            }
        }
    }
}

@Composable
fun SaveInformation(
    modifier: Modifier = Modifier,
    onDismissRequest: (Boolean) -> Unit
) {

    var name by rememberSaveable { mutableStateOf("") }
    var number by rememberSaveable { mutableStateOf("") }

    AlertDialog(

        title = {
            Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    maxLines = 1

                )
                Spacer(modifier = modifier.height(10.dp))
                OutlinedTextField(
                    value = number,
                    onValueChange = {
                        number = it
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    maxLines = 1,
                    textStyle = MaterialTheme.typography.titleMedium
                )
            }
        },
        onDismissRequest = {
            onDismissRequest(false)
        },
        dismissButton = {
            OutlinedButton(
                onClick = {
                    onDismissRequest(false)
                }
            ) {
                Text("Cancel")
            }
        },
        confirmButton = {
            Button(
                onClick = {
                   // some kind of logic but using function with check up for sure !!!
                },
                 enabled = if(name.isEmpty() || number.isEmpty()) false else true
            ) {
                Text("Save")
            }
        }
    )
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

/*
2 ta String qabul qilsin
agar bo'sh joyi mavjud bo'lsa
 */