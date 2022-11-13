package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.ui.theme.Yellow500
import com.cyrilpillai.androidplayground.ui.theme.Yellow800
import com.cyrilpillai.androidplayground.video_streaming.model.VideoItem
import com.cyrilpillai.androidplayground.video_streaming.state.getPromotionalVideoState

data class PromotionalVideoState(
    val videoItem: VideoItem.Promotional,
)

@Composable
fun PromotionalVideoSection(
    state: PromotionalVideoState,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Black,
                        Yellow500,
                        Color.Black
                    )
                )
            )
            .padding(top = 32.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "TV Shows",
                color = Color.White,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Movies",
                color = Color.White,
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Categories",
                    color = Color.White,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_expand_more
                    ),
                    tint = Color.White,
                    contentDescription = "categories expand"
                )
            }

        }
        VideoItemSection(
            videoItem = state.videoItem,
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth(0.6f)

        )
        Text(
            text = getGenreAnnotatedString(state.videoItem.genres),
            color = Color.White,
            fontSize = 16.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 10.dp
            )
        )

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ImageButtonSection(
                icon = R.drawable.ic_done,
                text = "My List"
            )
            SolidButtonSection(
                icon = R.drawable.ic_play_arrow,
                text = "Play"
            )
            ImageButtonSection(
                icon = R.drawable.ic_info,
                text = "Info"
            )
        }
    }
}

@Composable
private fun ImageButtonSection(
    @DrawableRes icon: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = icon),
            tint = Color.White,
            contentDescription = "image button icon",
            modifier = Modifier
                .size(20.dp)
        )

        Text(
            text = text,
            color = Color.White,
            fontSize = 10.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Composable
private fun SolidButtonSection(
    @DrawableRes icon: Int,
    text: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color.White,
        shape = RoundedCornerShape(2.dp),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(
                    vertical = 4.dp,
                    horizontal = 12.dp
                )
        ) {
            Icon(
                painter = painterResource(id = icon),
                tint = Color.Black,
                contentDescription = "solid button icon",
                modifier = Modifier
                    .size(20.dp)
            )

            Text(
                text = text,
                color = Color.Black,
                fontSize = 12.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
            )
        }
    }
}

private fun getGenreAnnotatedString(genres: List<String>): AnnotatedString {
    val spanStyle = SpanStyle(color = Yellow800)
    return buildAnnotatedString {
        genres.forEachIndexed { index, genre ->
            append(genre)
            if (index < genres.size - 1) {
                pushStyle(spanStyle)
                append(" • ")
                pop()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PromotionalVideoSectionPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        PromotionalVideoSection(
            state = getPromotionalVideoState(),
            modifier = Modifier
        )
    }
}