package com.example.newziee.screens.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.newziee.SharedPref.PreferenceManager
import com.example.newziee.data.contact
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangeItemSheet(
    modifier: Modifier = Modifier,
    isClosedBottomSheet: () -> Unit,
    contact: contact
) {

    var name by rememberSaveable { mutableStateOf(contact.name) }
    var number by rememberSaveable { mutableStateOf(contact.number) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()

    ModalBottomSheet(
        onDismissRequest = isClosedBottomSheet,
        sheetState = sheetState
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(24.dp)
                .navigationBarsPadding()
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            OutlinedTextField(
                value = name,
                onValueChange = {
                    name = it
                },
                modifier = modifier.fillMaxWidth(0.9f),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
            )

            Spacer(modifier = modifier.height(15.dp))

            OutlinedTextField(
                value = number,
                onValueChange = {
                    number = it
                },
                modifier = modifier.fillMaxWidth(0.9f)
            )
            Spacer(modifier = modifier.height(15.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = modifier.padding(end = 15.dp, start = 15.dp)
            ) {
                Spacer(modifier = modifier.weight(1f))
                OutlinedButton(
                    onClick = {
                        scope.launch {
                            sheetState.hide()
                            isClosedBottomSheet()
                        }

                    }
                ) {
                    Text("Cancel")
                }
                ElevatedButton(
                    onClick = {

                    }
                ) {
                    Text("Change")
                }
            }
        }
    }
}