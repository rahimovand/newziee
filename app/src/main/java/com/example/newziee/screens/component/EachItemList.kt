package com.example.newziee.screens.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.newziee.data.contact

@Composable
fun EachItemList(
    modifier: Modifier,
    list: List<contact>
) {
    var isClickedToChange by rememberSaveable { mutableStateOf(false) }

    LazyColumn(
        modifier = modifier
            .statusBarsPadding()
            .navigationBarsPadding(),
        contentPadding = PaddingValues(horizontal = 4.dp, vertical = 4.dp)
    ) {
        items(list.size) {
            EachItemRep(
                name = list[it].name,
                itemClicked = {
                    isClickedToChange = !isClickedToChange
                    /*
                    scenario:
                    1) eachClicked item goes there
                    2) when item is clicked bottom sheet opens up
                    3) bottom sheet textfield value areas will be filled with local info
                    4) user can change and save it
                    5) when the area is blank user cannot save it
                     */
                }
            )
        }
    }


}