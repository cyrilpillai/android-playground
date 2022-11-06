package com.cyrilpillai.androidplayground.social_media.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.social_media.state.getProfileImageState


data class ProfileImageState(
    val imageUrl: String
)

@Composable
fun ProfileImageSection(
    state: ProfileImageState,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        AsyncImage(
            model = state.imageUrl,
            contentDescription = "profile image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_add_circle),
            contentDescription = "change profile photo",
            tint = Color.White,
            modifier = Modifier
                .size(24.dp)
                .border(BorderStroke(2.dp, Color.Black), shape = CircleShape)
                .align(Alignment.BottomEnd)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileImageSectionPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        ProfileImageSection(state = getProfileImageState())
    }
}