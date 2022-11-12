package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.ui.theme.Yellow500
import com.cyrilpillai.androidplayground.ui.theme.Yellow800

@Composable
fun TopBarSection(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_netflix
            ),
            contentDescription = "netflix icon",
            modifier = Modifier
                .size(32.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_cast
                ),
                contentDescription = "cast",
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(20.dp)
            )
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_search_outline
                ),
                contentDescription = "notifications",
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(20.dp)
            )
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Yellow800,
                                Yellow500
                            )
                        )
                    )
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_smile
                    ),
                    tint = Color.White,
                    contentDescription = "account icon",
                    modifier = Modifier
                        .padding(4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopBarSectionPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        TopBarSection(
            modifier = Modifier
                .padding(16.dp)
        )
    }
}