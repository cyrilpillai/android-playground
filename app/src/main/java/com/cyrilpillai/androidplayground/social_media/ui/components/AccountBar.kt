package com.cyrilpillai.androidplayground.social_media.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.social_media.state.getAccountBarState

data class AccountBarState(
    val username: String
)

@Composable
fun AccountBarSection(
    state: AccountBarState,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = state.username,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_expand_more
                ),
                contentDescription = "profile expand",
                tint = Color.White
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_add_square
                ),
                contentDescription = "profile expand",
                tint = Color.White,
                modifier = Modifier
                    .padding(end = 20.dp)
                    .size(21.dp)
            )
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_menu
                ),
                contentDescription = "profile expand",
                tint = Color.White,
                modifier = Modifier
                    .size(26.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AccountBarSectionPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        AccountBarSection(state = getAccountBarState())
    }
}