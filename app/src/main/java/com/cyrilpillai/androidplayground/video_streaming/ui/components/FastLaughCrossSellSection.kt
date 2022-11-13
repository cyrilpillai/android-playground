package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.ui.theme.Blue100
import com.cyrilpillai.androidplayground.ui.theme.LightBlue800
import com.cyrilpillai.androidplayground.ui.theme.Purple700

@OptIn(ExperimentalTextApi::class)
@Composable
fun FastLaughCrossSellSection(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(
                Brush.linearGradient(
                    colors = listOf(
                        Purple700,
                        Color.Black,
                        Color.Black,
                        Color.Black,
                        Color.Black,
                        Purple700
                    ),
                    start = Offset(0f, Float.POSITIVE_INFINITY),
                    end = Offset(Float.POSITIVE_INFINITY, 0f)
                )
            )
            .padding(
                start = 32.dp,
                end = 32.dp,
                bottom = 16.dp,
            )
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_laughing_emoji_illustration
            ),
            contentDescription = "fast laughs icon",
            modifier = Modifier
                .size(130.dp)
        )
        Text(
            text = "Short clips.",
            color = LightBlue800,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                brush = Brush.horizontalGradient(
                    listOf(Blue100, LightBlue800)
                )
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Big laughs.",
            color = LightBlue800,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            style = TextStyle(
                brush = Brush.horizontalGradient(
                    listOf(Blue100, LightBlue800)
                )
            ),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "It's Fast Laughs ⎯   your one-stop shop for the funniest clips on Netflix.",
            color = Color.White,
            fontSize = 14.sp,
            maxLines = 2,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(vertical = 10.dp)
        )
        SolidButtonSection(
            text = "\uD83D\uDE02 Go to Fast Laughs"
        )
    }
}

@Composable
private fun SolidButtonSection(
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
            Text(
                text = text,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                textAlign = TextAlign.Center,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FastLaughCrossSellSectionPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        FastLaughCrossSellSection(
            modifier = Modifier
                .padding(16.dp)
        )
    }
}