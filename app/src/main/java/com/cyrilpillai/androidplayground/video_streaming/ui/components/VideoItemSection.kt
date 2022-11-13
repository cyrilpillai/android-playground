package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.ui.theme.BlackTransparent
import com.cyrilpillai.androidplayground.ui.theme.Grey900
import com.cyrilpillai.androidplayground.ui.theme.Red800
import com.cyrilpillai.androidplayground.video_streaming.model.VideoItem
import com.cyrilpillai.androidplayground.video_streaming.state.getVideoItems
import com.cyrilpillai.androidplayground.video_streaming.state.getWatchingState

@Composable
fun VideoItemSection(
    videoItem: VideoItem,
    modifier: Modifier = Modifier
) {
    when (videoItem) {
        is VideoItem.Watching -> WatchingVideoItemSection(
            videoItem = videoItem,
            modifier = modifier
        )
        is VideoItem.Generic -> GenericVideoItemSection(
            videoItem = videoItem,
            modifier = modifier
        )
        is VideoItem.Promotional -> GenericVideoItemSection(
            videoItem = VideoItem.Generic(
                id = videoItem.id,
                thumbnailUrl = videoItem.thumbnailUrl,
                isNetflixOriginal = videoItem.isNetflixOriginal,
                isTopTen = videoItem.isTopTen,
            ),
            modifier = modifier
        )
    }
}

@Composable
private fun GenericVideoItemSection(
    videoItem: VideoItem.Generic,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
    ) {
        AsyncImage(
            model = videoItem.thumbnailUrl,
            contentDescription = "video thumbnail",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        if (videoItem.isNetflixOriginal) {
            NetflixOriginalTag(
                modifier = Modifier
                    .align(Alignment.TopStart)
            )
        }

        if (videoItem.isTopTen) {
            TopTenBadge(
                modifier = Modifier
                    .align(Alignment.TopEnd)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 18.dp)
                .align(Alignment.BottomCenter)
        ) {
            videoItem.primaryPrompt?.let {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Red800,
                            shape = RoundedCornerShape(
                                topStart = 2.dp,
                                topEnd = 2.dp
                            )
                        )
                ) {
                    Text(
                        text = it,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                    )
                }

                videoItem.secondaryPrompt?.let {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.White)
                    ) {
                        Text(
                            text = it,
                            fontSize = 8.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 1.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun WatchingVideoItemSection(
    videoItem: VideoItem.Watching,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
    ) {
        Box(
            modifier = modifier
                .weight(1f)
        ) {
            AsyncImage(
                model = videoItem.thumbnailUrl,
                contentDescription = "video thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            if (videoItem.isNetflixOriginal) {
                NetflixOriginalTag(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                )
            }

            if (videoItem.isTopTen) {
                TopTenBadge(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                )
            }

            Surface(
                shape = CircleShape,
                color = BlackTransparent,
                border = BorderStroke((1.2).dp, Color.White),
                modifier = Modifier
                    .align(Alignment.Center)
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_play_arrow
                    ),
                    tint = Color.White,
                    contentDescription = "currently watching play icon",
                    modifier = Modifier
                        .padding(6.dp)
                        .size(36.dp)
                )
            }


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.Transparent,
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    )
            ) {
                Text(
                    text = videoItem.subText,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(vertical = 1.dp)
                )
            }
        }
        LinearProgressIndicator(
            progress = videoItem.progress,
            color = Red800
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .background(Grey900)
                .fillMaxWidth()
                .padding(4.dp)
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_info
                ),
                tint = Color.Gray,
                contentDescription = "currently watching info",
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(20.dp)
            )
            Icon(
                painter = painterResource(
                    id = R.drawable.ic_more_vertical
                ),
                tint = Color.Gray,
                contentDescription = "currently watching more",
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}

@Composable
private fun NetflixOriginalTag(
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(
            id = R.drawable.ic_netflix
        ),
        contentDescription = "video netflix original",
        modifier = modifier
            .padding(top = 5.dp, start = 1.dp)
            .size(14.dp)
    )
}

@Composable
private fun TopTenBadge(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Red800)
    ) {
        Text(
            text = getTopTenAnnotatedString(),
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(2.dp)
        )
    }
}

private fun getTopTenAnnotatedString(): AnnotatedString {
    return buildAnnotatedString {
        pushStyle(getSpanStyle(5.sp))
        append("TOP\n")
        pop()
        pushStyle(getSpanStyle(8.sp))
        append("10")
        pop()
    }
}

private fun getSpanStyle(fontSize: TextUnit): SpanStyle {
    return SpanStyle(
        fontSize = fontSize,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
private fun GenericVideoItemSectionPreview() {
    GenericVideoItemSection(
        videoItem = getVideoItems()[0],
        modifier = Modifier
            .width(100.dp)
            .height(140.dp)
    )
}

@Preview(showBackground = true)
@Composable
private fun WatchingVideoItemSectionPreview() {
    WatchingVideoItemSection(
        videoItem = getWatchingState().videos[0] as VideoItem.Watching,
        modifier = Modifier
            .width(100.dp)
            .height(140.dp)
    )
}