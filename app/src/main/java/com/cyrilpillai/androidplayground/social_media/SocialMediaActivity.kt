package com.cyrilpillai.androidplayground.social_media

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.MainActivity
import com.cyrilpillai.androidplayground.social_media.state.getBottomBarState
import com.cyrilpillai.androidplayground.social_media.state.getCtaState
import com.cyrilpillai.androidplayground.social_media.state.getFollowersState
import com.cyrilpillai.androidplayground.social_media.state.getHighlightsState
import com.cyrilpillai.androidplayground.social_media.state.getPostsState
import com.cyrilpillai.androidplayground.social_media.state.getProfileDetailsState
import com.cyrilpillai.androidplayground.social_media.state.getProfileImageState
import com.cyrilpillai.androidplayground.social_media.state.getStatisticsState
import com.cyrilpillai.androidplayground.social_media.state.getTabsState
import com.cyrilpillai.androidplayground.social_media.state.getTopBarState
import com.cyrilpillai.androidplayground.social_media.ui.components.BottomBarSection
import com.cyrilpillai.androidplayground.social_media.ui.components.BottomBarState
import com.cyrilpillai.androidplayground.social_media.ui.components.CtaSection
import com.cyrilpillai.androidplayground.social_media.ui.components.FollowersSection
import com.cyrilpillai.androidplayground.social_media.ui.components.HighlightSection
import com.cyrilpillai.androidplayground.social_media.ui.components.PostItemSection
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileAndStatsSection
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileDetailsSection
import com.cyrilpillai.androidplayground.social_media.ui.components.TabsSection
import com.cyrilpillai.androidplayground.social_media.ui.components.TabsState
import com.cyrilpillai.androidplayground.social_media.ui.components.TopBarSection
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme

class SocialMediaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPlaygroundTheme(
                statusBarColor = Color.Black,
                useDarkIcons = false
            ) {
                SocialMediaScreen()
            }
        }
    }

    @Composable
    private fun SocialMediaScreen() {
        val topBarState by remember { mutableStateOf(getTopBarState()) }
        var bottomBarState by remember { mutableStateOf(getBottomBarState()) }
        val statisticsState by remember { mutableStateOf(getStatisticsState()) }
        val profileImageState by remember { mutableStateOf(getProfileImageState()) }
        val profileDetailsState by remember { mutableStateOf(getProfileDetailsState()) }
        val ctaState by remember { mutableStateOf(getCtaState()) }
        val highlightsState by remember { mutableStateOf(getHighlightsState()) }
        val followersState by remember { mutableStateOf(getFollowersState()) }
        var tabsState by remember { mutableStateOf(getTabsState()) }
        val postsState by remember { mutableStateOf(getPostsState()) }

        Scaffold(
            modifier = Modifier
                .fillMaxSize(),
            backgroundColor = Color.Black,
            topBar = {
                TopBarSection(
                    state = topBarState,
                    modifier = Modifier
                        .padding(16.dp)
                )
            },
            bottomBar = {
                BottomBarSection(state = bottomBarState) { id ->
                    bottomBarState = BottomBarState(bottomBarState.items.map {
                        it.copy(isSelected = it.id == id)
                    })
                }
            }) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .padding(it)
            ) {
                item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                    ProfileAndStatsSection(
                        profileImageState = profileImageState,
                        statisticsState = statisticsState,
                        modifier = Modifier
                            .padding(16.dp)
                    )
                }

                item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                    ProfileDetailsSection(
                        state = profileDetailsState,
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                    )
                }

                item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                    FollowersSection(
                        state = followersState,
                        modifier = Modifier
                            .padding(
                                top = 8.dp,
                                start = 12.dp,
                                end = 12.dp
                            )
                    )
                }

                item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                    CtaSection(
                        state = ctaState,
                        modifier = Modifier
                            .padding(
                                top = 12.dp,
                                start = 12.dp,
                                end = 12.dp
                            )
                    )
                }
                item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                    HighlightSection(
                        state = highlightsState,
                        modifier = Modifier
                            .padding(vertical = 16.dp)
                    )
                }

                item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                    TabsSection(
                        state = tabsState,
                        modifier = Modifier
                    ) { position ->
                        tabsState =
                            TabsState(tabsState.tabs.map { tabItem ->
                                tabItem.copy(
                                    isSelected = tabItem.position == position
                                )
                            })
                    }
                }
                items(postsState.posts) { postItem ->
                    PostItemSection(
                        postItem = postItem,
                        modifier = Modifier
                    )
                }
            }

        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun SocialMediaScreenPreview() {
        SocialMediaScreen()
    }

}