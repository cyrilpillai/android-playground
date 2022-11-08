package com.cyrilpillai.androidplayground.social_media.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.cyrilpillai.androidplayground.social_media.model.CtaItem
import com.cyrilpillai.androidplayground.social_media.model.FollowerItem
import com.cyrilpillai.androidplayground.social_media.state.getCtaState
import com.cyrilpillai.androidplayground.social_media.state.getFollowersState
import com.cyrilpillai.androidplayground.ui.theme.Grey900

data class FollowersState(
    val followers: List<FollowerItem>
)

@Composable
fun FollowersSection(
    state: FollowersState,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
            .fillMaxWidth()
    ) {
        val spanStyle = SpanStyle(
            fontWeight = FontWeight.SemiBold
        )
        with(state.followers) {
            FollowerIcon(
                imageUrl = get(0).imageUrl,
                modifier = Modifier
                    .offset(4.dp)
                    .zIndex(1f)
            )
            FollowerIcon(
                imageUrl = get(1).imageUrl,
                modifier = Modifier
            )
            Text(
                text = buildAnnotatedString {
                    append("Followed by ")
                    pushStyle(spanStyle)
                    append(get(0).name)
                    pop()
                    append(", ")
                    pushStyle(spanStyle)
                    append(get(1).name)
                    pop()
                    append(" and ")
                    pushStyle(spanStyle)
                    append("${(size - 2)} others")
                    pop()
                },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
        }
    }
}

@Composable
fun FollowerIcon(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "follower icon",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(24.dp)
            .clip(CircleShape)
            .border(
                border = BorderStroke(1.dp, Color.Black),
                shape = CircleShape
            )
    )
}

@Preview(showBackground = true)
@Composable
private fun FollowersSectionPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        FollowersSection(
            state = getFollowersState(),
            modifier = Modifier
                .padding(16.dp)
        )
    }
}