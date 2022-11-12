package com.cyrilpillai.androidplayground.social_media.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.social_media.state.getTopBarState

data class TopBarState(
    val username: String
)

@Composable
fun TopBarSection(
    state: TopBarState,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        Icon(
            painter = painterResource(
                id = R.drawable.ic_back
            ),
            contentDescription = "back",
            tint = Color.White
        )
        Text(
            text = state.username,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_notification_outlined
                ),
                contentDescription = "notifications",
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 20.dp)
            )
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_more_vertical
                ),
                contentDescription = "more",
                tint = Color.White,
                modifier = Modifier
            )
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
            state = getTopBarState(),
            modifier = Modifier
                .padding(16.dp)
        )
    }
}