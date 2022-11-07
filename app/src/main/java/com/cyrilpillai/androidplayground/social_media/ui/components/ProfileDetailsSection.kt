package com.cyrilpillai.androidplayground.social_media.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.social_media.state.getProfileDetailsState
import com.cyrilpillai.androidplayground.ui.theme.Blue100

data class ProfileDetailsState(
    val name: String,
    val bio: String,
    val website: String
)

@Composable
fun ProfileDetailsSection(
    state: ProfileDetailsState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = state.name,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )
        Text(
            text = state.bio,
            color = Color.White,
            fontSize = 12.sp,
            maxLines = 5,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = state.website,
            color = Blue100,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileDetailsSectionPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        ProfileDetailsSection(
            state = getProfileDetailsState(),
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
    }
}