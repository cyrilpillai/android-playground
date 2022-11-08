package com.cyrilpillai.androidplayground.messaging.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.cyrilpillai.androidplayground.messaging.state.getTopBarState
import com.cyrilpillai.androidplayground.ui.theme.Teal600

data class TopBarState(
    val name: String
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
            .background(Teal600)
            .fillMaxWidth()
            .padding(16.dp)
            .wrapContentHeight()
    ) {
        Text(
            text = state.name,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_camera_outline
                ),
                contentDescription = "camera",
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 26.dp)
                    .size(20.dp)
            )
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_search_outline
                ),
                contentDescription = "search",
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(20.dp)
            )
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_more_vertical
                ),
                contentDescription = "more",
                tint = Color.White,
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopBarSectionPreview() {
    TopBarSection(
        state = getTopBarState()
    )
}