package com.example.newziee.screens

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newziee.MainActivity
import com.example.newziee.SharedPref.PreferenceManager
import com.example.newziee.data.contact
import com.example.newziee.logic.checkAndSaveData
import com.example.newziee.logic.isNotEmptyAndNotBlank
import com.example.newziee.screens.component.EachItemRep
import com.example.newziee.ui.theme.NewzieeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {

    val obj = PreferenceManager(LocalContext.current)
    var list = obj.getAllContact()
    var isClicked by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Scaffold(
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
        LazyColumn(
            modifier = modifier
                .padding(paddingValues)
                .statusBarsPadding()
                .navigationBarsPadding(),
            contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)

        ) {
            items(list.size) {
                EachItemRep(
                    name = list[it].name,
                )
            }
        }
        if (isClicked) {
            ModalBottomSheet(
                onDismissRequest = {
                    isClicked = false
                },
                sheetState = sheetState,
                dragHandle = { BottomSheetDefaults.DragHandle() }
            ) {
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(24.dp)
                        .imePadding()

                    ,
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {

                        },
                        modifier = modifier.fillMaxWidth(0.9f)
                    )

                    Spacer(modifier = modifier.height(15.dp))

                    OutlinedTextField(
                        value = "",
                        onValueChange = {

                        },
                        modifier = modifier.fillMaxWidth(0.9f)
                    )
                    Spacer(modifier = modifier.height(15.dp))
                    Row(
                        horizontalArrangement = Arrangement.Absolute.spacedBy(15.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        OutlinedButton(
                            onClick = {}
                        ) {
                            Text("Cancel")
                        }
                        ElevatedButton(
                            onClick = {}
                        ) {
                            Text("Change")
                        }
                    }

                }
            }
//            SaveInformation(
//                onDismissRequest = {
//                    isClicked = it
//                },
//                takeNewContact = {
//                    obj.addContact(it)
//                    list = obj.getAllContact()
//                }
//            )
        }
    }
}

@Composable
fun SaveInformation(
    modifier: Modifier = Modifier,
    onDismissRequest: (Boolean) -> Unit,
    takeNewContact: (contact) -> Unit
) {

    var name by rememberSaveable { mutableStateOf("") }   // name holder
    var number by rememberSaveable { mutableStateOf("") } // number holder
    if (name == "") number = ""  // logical problem solved

    AlertDialog(

        title = {
            Column {
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    maxLines = 1,
                    label = {
                        Text("Name:", textAlign = TextAlign.Unspecified)
                    },
                    shape = RoundedCornerShape(11.dp),
                    trailingIcon = {
                        if (name.isNotEmpty()) {
                            IconButton(
                                onClick = {
                                    name = ""
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = null
                                )
                            }
                        }
                    }
                )

                Spacer(modifier = modifier.height(10.dp))

                OutlinedTextField(
                    value = number,
                    onValueChange = { number = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),  // letting user to enter only phone number
                    maxLines = 1,
                    label = {
                        Text("Number:")
                    },
                    shape = RoundedCornerShape(11.dp),
                    trailingIcon = {
                        if (number.isNotEmpty()) {
                            IconButton(
                                onClick = {
                                    number = ""
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = null
                                )
                            }
                        }
                    },
                    textStyle = MaterialTheme.typography.titleMedium,
                    enabled = name.isNotEmptyAndNotBlank()
                )
            }
        },

        onDismissRequest = { onDismissRequest(false) },

        dismissButton = {
            OutlinedButton(
                onClick = { onDismissRequest(false) }
            ) { Text("Cancel") }
        },
        confirmButton = {
            Button(
                onClick = {
                    takeNewContact(checkAndSaveData(name, number))
                    onDismissRequest(false)
                },
                enabled = if (name.isNotEmptyAndNotBlank() && number.isNotEmptyAndNotBlank()) true else false
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