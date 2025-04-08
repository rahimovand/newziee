package com.example.newziee.screens.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AddFloatingActionButton(
    isClicked: (Boolean) -> Unit,
    containerColor: Color = MaterialTheme.colorScheme.surfaceContainerHighest,

    ) {
    FloatingActionButton(
        onClick = {
            isClicked(true)
        },
        containerColor = containerColor,
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