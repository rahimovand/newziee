package com.example.newziee.screens.component

import android.content.SharedPreferences
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newziee.ui.theme.NewzieeTheme
import com.example.newziee.ui.theme.tertiaryDark

@Composable
fun EachItemRep(
    modifier: Modifier = Modifier,
    name: String = "Alisher",
    itemClicked: () -> Unit,
    shape: Shape =  RoundedCornerShape(topEnd = 20.dp , topStart = 35.dp, bottomStart = 25.dp),
    colorOfCircle: Color = MaterialTheme.colorScheme.surfaceContainerHighest
) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(5.dp)
            .clip(shape),
        onClick = {
            itemClicked()
            isExpanded = !isExpanded
        },
        shape =shape,
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
                        .drawBehind {
                            drawCircle(color = colorOfCircle)
                        }
                        .padding(15.dp)
                    ,
                    text = "${name[0].uppercase()}",

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
                        itemClicked()
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
                        onClick = {}
                    ) {
                        Text("Remove")
                    }
                    Button(
                        onClick = {}
                    ) {
                        Text("Edit")
                    }
                }
            }
        }
    }
}

@Preview()
@Composable()
fun PreviewOf() {
    NewzieeTheme(
        darkTheme = true
    ) {
        EachItemRep(itemClicked = {})
    }

}