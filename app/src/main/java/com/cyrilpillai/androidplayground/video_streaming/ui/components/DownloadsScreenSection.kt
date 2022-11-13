package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.ui.theme.Indigo500
import com.cyrilpillai.androidplayground.video_streaming.model.DownloadItem
import com.cyrilpillai.androidplayground.video_streaming.model.VideoItem
import com.cyrilpillai.androidplayground.video_streaming.state.getDownloadsScreenState

data class DownloadsScreenState(
    val downloadItem: DownloadItem
)

@Composable
fun DownloadsScreenSection(
    state: DownloadsScreenState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_settings
                ),
                tint = Color.White,
                contentDescription = "smart download icon",
                modifier = Modifier
                    .size(18.dp)
            )
            Text(
                text = "Smart Downloads",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 12.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
            )
        }
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
                .padding(
                    horizontal = 16.dp,
                    vertical = 32.dp
                )
        ) {
            Text(
                text = state.downloadItem.title,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 22.sp,
                modifier = Modifier
                    .padding(
                        horizontal = 36.dp,
                        vertical = 16.dp
                    )
            )
            Text(
                text = state.downloadItem.description,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(horizontal = 56.dp)
            )

            ThumbnailsSection(
                primaryVideoItem = state.downloadItem.primaryVideoItem,
                secondaryStartVideoItem = state.downloadItem.secondaryStartVideoItem,
                secondaryEndVideoItem = state.downloadItem.secondaryEndVideoItem,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            )

            Surface(
                color = Indigo500,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .padding(
                        start = 48.dp,
                        end = 48.dp,
                        top = 16.dp
                    )
                    .fillMaxWidth()
            ) {
                Text(
                    text = state.downloadItem.primaryCta,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                )
            }

            Surface(
                color = Color.White,
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier
                    .padding(
                        horizontal = 80.dp,
                        vertical = 16.dp
                    )
                    .fillMaxWidth()

            ) {
                Text(
                    text = state.downloadItem.secondaryCta,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun ThumbnailsSection(
    primaryVideoItem: VideoItem.Generic,
    secondaryStartVideoItem: VideoItem.Generic,
    secondaryEndVideoItem: VideoItem.Generic,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(vertical = 16.dp)
    ) {
        Surface(
            shape = CircleShape,
            color = Color.DarkGray,
            modifier = Modifier
                .size(190.dp)
                .align(Alignment.Center)
        ) {

        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            VideoItemSection(
                videoItem = secondaryStartVideoItem,
                modifier = Modifier
                    .width(90.dp)
                    .height(120.dp)
                    .offset(40.dp)
                    .rotate(-20f)
            )

            VideoItemSection(
                videoItem = primaryVideoItem,
                modifier = Modifier
                    .width(110.dp)
                    .height(140.dp)
                    .zIndex(1f)
            )

            VideoItemSection(
                videoItem = secondaryEndVideoItem,
                modifier = Modifier
                    .width(90.dp)
                    .height(120.dp)
                    .offset((-40).dp)
                    .rotate(20f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DownloadsScreenSectionPreview() {
    DownloadsScreenSection(
        state = getDownloadsScreenState(),
        modifier = Modifier
            .background(Color.Black)
            .padding(16.dp)
    )
}