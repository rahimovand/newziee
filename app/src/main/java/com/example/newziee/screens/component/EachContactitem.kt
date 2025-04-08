package com.example.newziee.screens.component


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newziee.SharedPref.PreferenceManager
import com.example.newziee.ui.theme.NewzieeTheme

@Composable
fun EachItemRep(
    modifier: Modifier = Modifier,
    name: String = "Alisher",
    itemForChangeClicked: () -> Unit,
    itemToDeleteClicked: () -> Unit,
    shape: Shape = CutCornerShape(topStart = 25.dp, bottomEnd = 35.dp),
    colorOfCircle: Color = MaterialTheme.colorScheme.inversePrimary
) {

    var isExpanded by rememberSaveable { mutableStateOf(false) }


    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
            .clip(shape)
            .border(shape = shape, color = MaterialTheme.colorScheme.surfaceTint, width = 1.dp)
        ,
        onClick = {
            isExpanded = !isExpanded
        },
        shape = shape,
        color = MaterialTheme.colorScheme.surfaceContainerHigh
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .animateContentSize()
                    .padding(start = 10.dp, end = 10.dp, top = 7.dp, bottom = 5.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    modifier = modifier
                        .padding(start = 10.dp)
                        .drawBehind {
                            drawCircle(color = colorOfCircle)
                        }
                        .padding(15.dp)
                    ,
                    text = name[0].uppercase(),

                    )
                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    name,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = modifier.padding(2.dp)
                )
                Spacer(modifier = modifier.weight(1f))
                IconButton(
                    onClick = {
                        isExpanded = !isExpanded
                    }
                ) {

                    Icon(
                        imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = null
                    )
                }

            }
            AnimatedVisibility(
                visible = isExpanded
            ) {
                Row(
                    modifier = modifier.padding(10.dp),
                    horizontalArrangement = Arrangement.spacedBy(15.dp)
                ) {
                    Spacer(modifier = modifier.weight(1f))
                    OutlinedButton(
                        onClick = {
                            itemToDeleteClicked()
                        }
                    ) {
                        Text("Remove")
                    }
                    Button(
                        onClick = {
                            itemForChangeClicked()
                        },
                        modifier = modifier.padding(end = 15.dp)
                    ) {
                        Text("Edit")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewOf() {
    NewzieeTheme(
        darkTheme = true
    ) {
        EachItemRep(itemToDeleteClicked = {}, itemForChangeClicked = {})
    }

}