package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cyrilpillai.androidplayground.video_streaming.model.FastLaughItem
import com.cyrilpillai.androidplayground.video_streaming.state.getFastLaughsState
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager

data class FastLaughsState(
    val fastLaughs: List<FastLaughItem>
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FastLaughsScreenSection(
    state: FastLaughsState,
    onVolumeToggleClick: (fastLaughItem: FastLaughItem) -> Unit,
    modifier: Modifier = Modifier
) {
    VerticalPager(
        count = state.fastLaughs.size,
        modifier = modifier
    ) { page ->
        val fastLaughItem = state.fastLaughs[page]
        FastLaughContentSection(
            fastLaughItem = fastLaughItem,
            onVolumeToggleClick = { onVolumeToggleClick(fastLaughItem) }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FastLaughsScreenSectionPreview() {
    FastLaughsScreenSection(
        state = getFastLaughsState(),
        onVolumeToggleClick = {}
    )
}