package com.example.newziee.screens.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangeItemSheet(
    modifier: Modifier =Modifier,
    isClosedBottomSheet: (Boolean) -> Unit
){
    ModalBottomSheet(
        onDismissRequest = {
            isClosedBottomSheet(false)
        },
        dragHandle = { BottomSheetDefaults.DragHandle() },
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ) {

        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(24.dp)
                .imePadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            OutlinedTextField(
                value = "",
                onValueChange = {

                },
                modifier = modifier.fillMaxWidth(0.9f),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next)
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
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                modifier = modifier.padding(end = 15.dp, start = 15.dp)
            ) {
                Spacer(modifier = modifier.weight(1f))
                OutlinedButton(
                    onClick = {}
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