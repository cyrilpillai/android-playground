package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.video_streaming.model.VideoItem
import com.cyrilpillai.androidplayground.video_streaming.state.getActionAdventureState
import com.cyrilpillai.androidplayground.video_streaming.state.getComediesState
import com.cyrilpillai.androidplayground.video_streaming.state.getDarkDramaState
import com.cyrilpillai.androidplayground.video_streaming.state.getExcitingState
import com.cyrilpillai.androidplayground.video_streaming.state.getInternationalState
import com.cyrilpillai.androidplayground.video_streaming.state.getMyListState
import com.cyrilpillai.androidplayground.video_streaming.state.getPromotionalVideoState
import com.cyrilpillai.androidplayground.video_streaming.state.getTopPicksState
import com.cyrilpillai.androidplayground.video_streaming.state.getTrendingState
import com.cyrilpillai.androidplayground.video_streaming.state.getWatchingState

@Composable
fun HomeScreenSection(
    listState: LazyListState,
    modifier: Modifier = Modifier
) {
    val promotionalVideoState by remember { mutableStateOf(getPromotionalVideoState()) }
    val myListState by remember { mutableStateOf(getMyListState()) }
    val trendingState by remember { mutableStateOf(getTrendingState()) }
    val darkDramaState by remember { mutableStateOf(getDarkDramaState()) }
    val watchingState by remember { mutableStateOf(getWatchingState()) }
    val excitingState by remember { mutableStateOf(getExcitingState()) }
    val topPicksState by remember { mutableStateOf(getTopPicksState()) }
    val internationalState by remember { mutableStateOf(getInternationalState()) }
    val comediesState by remember { mutableStateOf(getComediesState()) }
    val actionAdventureState by remember { mutableStateOf(getActionAdventureState()) }

    LazyColumn(
        contentPadding = PaddingValues(top = 16.dp),
        state = listState,
        modifier = modifier
            .fillMaxSize()
    ) {
        addPromotionalVideoSection(promotionalVideoState)
        addVideoCarouselSection(myListState) {}
        addVideoCarouselSection(trendingState) {}
        addVideoCarouselSection(darkDramaState) {}
        addVideoCarouselSection(watchingState) {}
        addVideoCarouselSection(excitingState) {}
        addVideoCarouselSection(topPicksState) {}
        addVideoCarouselSection(comediesState) {}
        addFastLaughCrossSellSection()
        addVideoCarouselSection(internationalState) {}
        addVideoCarouselSection(actionAdventureState) {}
    }
}

private fun LazyListScope.addPromotionalVideoSection(
    promotionalVideoState: PromotionalVideoState
) {
    item {
        PromotionalVideoSection(state = promotionalVideoState)
    }
}

private fun LazyListScope.addVideoCarouselSection(
    state: VideoCarouselState,
    onClick: (videoItem: VideoItem) -> Unit
) {
    item {
        VideoCarouselSection(
            state = state,
            onClick = onClick,
            modifier = Modifier
                .padding(top = 10.dp)
        )
    }
}

private fun LazyListScope.addFastLaughCrossSellSection(
) {
    item {
        FastLaughCrossSellSection(
            modifier = Modifier
                .padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenSectionPreview() {
    HomeScreenSection(
        listState = rememberLazyListState(),
        modifier = Modifier
            .padding(16.dp)
    )
}