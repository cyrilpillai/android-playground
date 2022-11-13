package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.cyrilpillai.androidplayground.ui.theme.Red800
import com.cyrilpillai.androidplayground.video_streaming.model.VideoItem
import com.cyrilpillai.androidplayground.video_streaming.state.getVideoItems

@Composable
fun VideoItemSection(
    videoItem: VideoItem,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(6.dp))
    ) {
        AsyncImage(
            model = videoItem.thumbnailUrl,
            contentDescription = "video thumbnail",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        if (videoItem.isNetflixOriginal) {
            Image(
                painter = painterResource(
                    id = R.drawable.ic_netflix
                ),
                contentDescription = "video netflix original",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 5.dp, start = 1.dp)
                    .size(14.dp)
            )
        }

        if (videoItem.isTopTen) {
            Box(
                modifier = Modifier
                    .background(Red800)
                    .align(Alignment.TopEnd)
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
private fun VideoItemSectionPreview() {
    VideoItemSection(
        videoItem = getVideoItems()[0],
        modifier = Modifier
            .padding(16.dp)
    )
}