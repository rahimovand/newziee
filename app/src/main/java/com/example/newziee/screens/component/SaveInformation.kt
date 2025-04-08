package com.example.newziee.screens.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.newziee.data.contact
import com.example.newziee.logic.checkAndSaveData
import com.example.newziee.logic.isNotEmptyAndNotBlank

@Composable
fun SaveInformation(
    modifier: Modifier = Modifier,
    onDismissRequest: (Boolean) -> Unit,
    takeNewContact: (contact) -> Unit
) {

    var name by rememberSaveable { mutableStateOf("") }
    val value = when (name) {
        "" -> ""
        else -> ""
    }
    var number by rememberSaveable { mutableStateOf(value) } // number holder


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

