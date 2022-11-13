package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.video_streaming.model.VideoItem
import com.cyrilpillai.androidplayground.video_streaming.state.getTrendingState

data class VideoCarouselState(
    val header: String,
    val videos: List<VideoItem>
)

@Composable
fun VideoCarouselSection(
    state: VideoCarouselState,
    modifier: Modifier = Modifier,
    onClick: (videoItem: VideoItem) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = state.header,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier
                .padding(horizontal = 16.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(top = 8.dp)
                .wrapContentSize()
        ) {
            items(state.videos) {
                val height = (if (it is VideoItem.Watching) 150 else 130).dp
                VideoItemSection(
                    videoItem = it,
                    modifier = Modifier
                        .width(90.dp)
                        .height(height)
                        .clickable { onClick(it) }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun VideoCarouselSectionPreview() {
    VideoCarouselSection(
        state = getTrendingState(),
        modifier = Modifier
            .padding(16.dp)
    ) {}
}