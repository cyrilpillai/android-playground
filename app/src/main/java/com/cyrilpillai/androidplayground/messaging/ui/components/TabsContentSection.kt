package com.cyrilpillai.androidplayground.messaging.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cyrilpillai.androidplayground.messaging.model.TabItem
import com.cyrilpillai.androidplayground.messaging.state.getTabs
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContentSection(
    pagerState: PagerState,
    tabSize: Int,
    modifier: Modifier = Modifier,
    onTabSelect: @Composable (position: Int) -> Unit
) {
    HorizontalPager(
        state = pagerState,
        count = tabSize,
        modifier = modifier
    ) { page ->
        onTabSelect(page)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Preview(showBackground = true)
@Composable
fun TabsContentSectionPreview() {
    TabsContentSection(
        tabSize = 5,
        pagerState = rememberPagerState()
    ) {}
}