package com.example.newziee.screens


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.newziee.SharedPref.PreferenceManager
import com.example.newziee.data.contact
import com.example.newziee.screens.component.AddFloatingActionButton
import com.example.newziee.screens.component.ChangeItemSheet
import com.example.newziee.screens.component.ContactLists
import com.example.newziee.screens.component.SaveInformation
import com.example.newziee.ui.theme.NewzieeTheme


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {

    val context = LocalContext.current

    var isAddButtonClicked by rememberSaveable { mutableStateOf(false) }
    var isChangeInformationClicked by rememberSaveable { mutableStateOf(false) }

    val obj = remember { PreferenceManager(context) }
    var list by rememberSaveable { mutableStateOf(obj.getAllContact()) }
    var selectedItem by rememberSaveable { mutableStateOf<contact?>(null) }



    Scaffold(
        floatingActionButton = {
            AddFloatingActionButton(
                isClicked = {
                    isAddButtonClicked = it
                }
            )
        }
    ) { paddingValues ->

        ContactLists(
            modifier = modifier.padding(paddingValues),
            list = list,
            deleteAction = { deleteMe ->
                obj.deleteContact(deleteMe)
                list = obj.getAllContact()
            },
            changeInformationSheet = {
                selectedItem = it
                isChangeInformationClicked = !isChangeInformationClicked
            }
        )

        if (isAddButtonClicked) {
            SaveInformation(
                onDismissRequest = {
                    isAddButtonClicked = it
                },
                takeNewContact = {
                    obj.addContact(it)
                    list = obj.getAllContact()
                }
            )
        }   // alertDialog pops up and saves information
        if (isChangeInformationClicked && selectedItem != null){
            ChangeItemSheet(
                contact = selectedItem!!,
                isClosedBottomSheet = {
                    isChangeInformationClicked = false
                }
            )
        }
    }
}

@Preview
@Composable
fun DarkMode() {
    NewzieeTheme(
        darkTheme = true
    ) {
        MainScreen()
    }
}

@Preview
@Composable
fun LightMode() {
    NewzieeTheme(
        darkTheme = false
    ) {
        MainScreen()
    }
}