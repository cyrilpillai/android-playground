package com.cyrilpillai.androidplayground.social_media.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Brush.Companion
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cyrilpillai.androidplayground.social_media.model.HighlightItem
import com.cyrilpillai.androidplayground.social_media.state.getHighlightsState

data class HighlightState(
    val highlights: List<HighlightItem>
)

@Composable
fun HighlightSection(
    state: HighlightState,
    modifier: Modifier = Modifier
) {
    LazyRow(
        contentPadding = PaddingValues(
            horizontal = 10.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        items(state.highlights) {
            HighlightItemSection(
                highlightItem = it
            )
        }
    }
}

@Composable
fun HighlightItemSection(
    highlightItem: HighlightItem,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .width(60.dp)
    ) {
        AsyncImage(
            model = highlightItem.imageUrl,
            contentDescription = "highlight image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .border(
                    border = BorderStroke(1.dp, Color.DarkGray),
                    shape = CircleShape
                )
                .padding(3.dp)
                .clip(CircleShape)

        )

        Text(
            text = highlightItem.description,
            color = Color.White,
            fontSize = 10.sp,
            maxLines = 1,
            textAlign = TextAlign.Center,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HighlightSectionPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        HighlightSection(
            state = getHighlightsState(),
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
    }
}