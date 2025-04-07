package com.example.newziee.screens.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newziee.ui.theme.NewzieeTheme
import com.example.newziee.ui.theme.tertiaryDark

@Composable
fun EachItemRep(
    modifier: Modifier = Modifier,
    name: String = "Alisher"
) {

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp),
        onClick = {

        },
        color = MaterialTheme.colorScheme.surfaceContainerHigh
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                modifier = modifier
                    .drawBehind {
                        drawCircle(color = tertiaryDark)
                    }
                    .padding(10.dp),
                text = "${name[0]}"
            )
            Spacer(modifier = Modifier.width(10.dp))

            Text( name,
                style = MaterialTheme.typography.headlineSmall,
                modifier = modifier.padding(2.dp)
            )
        }
    }
}

@Preview()
@Composable()
fun PreviewOf() {
    NewzieeTheme(
        darkTheme = true
    ) {
        EachItemRep()
    }

}