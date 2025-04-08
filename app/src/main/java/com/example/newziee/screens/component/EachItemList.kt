package com.example.newziee.screens.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newziee.data.contact

@Composable
fun ContactLists(
    modifier: Modifier = Modifier,
    list: MutableList<contact>,
    deleteAction: (contact) -> Unit,
    changeInformationSheet: (contact) -> Unit
) {

    val oddShape = CutCornerShape(topStart = 25.dp, bottomEnd = 35.dp)
    val evenShape = CutCornerShape(topEnd = 35.dp, bottomStart = 25.dp)


    LazyColumn(
        modifier = modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        contentPadding = PaddingValues(horizontal = 5.dp, vertical = 5.dp)
    ) {

        itemsIndexed(list) { index, item ->
            EachItemRep(
                name = item.name,
                shape = if (index % 2 == 0) evenShape else oddShape,
                itemForChangeClicked = {
                    changeInformationSheet(item)
                },
                itemToDeleteClicked = {
                    deleteAction(item)
                }
            )
        }
    }
}
