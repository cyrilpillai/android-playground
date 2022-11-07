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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.social_media.state.getBottomBarState
import com.cyrilpillai.androidplayground.social_media.state.getCtaState
import com.cyrilpillai.androidplayground.social_media.state.getHighlightsState
import com.cyrilpillai.androidplayground.social_media.state.getPostsState
import com.cyrilpillai.androidplayground.social_media.state.getProfileDetailsState
import com.cyrilpillai.androidplayground.social_media.state.getProfileImageState
import com.cyrilpillai.androidplayground.social_media.state.getStatisticsState
import com.cyrilpillai.androidplayground.social_media.state.getTopBarState
import com.cyrilpillai.androidplayground.social_media.ui.components.BottomBarSection
import com.cyrilpillai.androidplayground.social_media.ui.components.CtaSection
import com.cyrilpillai.androidplayground.social_media.ui.components.HighlightSection
import com.cyrilpillai.androidplayground.social_media.ui.components.PostItemSection
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileAndStatsSection
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileDetailsSection
import com.cyrilpillai.androidplayground.social_media.ui.components.TopBarSection
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme

class SocialMediaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val topBarState by remember { mutableStateOf(getTopBarState()) }
            val bottomBarState by remember { mutableStateOf(getBottomBarState()) }
            val statisticsState by remember { mutableStateOf(getStatisticsState()) }
            val profileImageState by remember { mutableStateOf(getProfileImageState()) }
            val profileDetailsState by remember { mutableStateOf(getProfileDetailsState()) }
            val ctaState by remember { mutableStateOf(getCtaState()) }
            val highlightsState by remember { mutableStateOf(getHighlightsState()) }
            val postsState by remember { mutableStateOf(getPostsState()) }

            AndroidPlaygroundTheme(
                statusBarColor = Color.Black,
                useDarkIcons = false
            ) {
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
                        BottomBarSection(state = bottomBarState)
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
                            ProfileDetailsSection(state = profileDetailsState)
                        }
                        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                            CtaSection(
                                state = ctaState,
                                modifier = Modifier
                                    .padding(top = 16.dp)
                            )
                        }
                        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                            HighlightSection(
                                state = highlightsState,
                                modifier = Modifier
                                    .padding(vertical = 16.dp)
                            )
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
        }
    }
}