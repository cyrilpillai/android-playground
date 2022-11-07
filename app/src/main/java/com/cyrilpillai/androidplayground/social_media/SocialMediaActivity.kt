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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.cyrilpillai.androidplayground.social_media.state.getAccountBarState
import com.cyrilpillai.androidplayground.social_media.state.getBottomBarState
import com.cyrilpillai.androidplayground.social_media.state.getEditProfileState
import com.cyrilpillai.androidplayground.social_media.state.getPostsState
import com.cyrilpillai.androidplayground.social_media.state.getProfileDetailsState
import com.cyrilpillai.androidplayground.social_media.state.getProfileImageState
import com.cyrilpillai.androidplayground.social_media.state.getStatisticsState
import com.cyrilpillai.androidplayground.social_media.ui.components.TopBarSection
import com.cyrilpillai.androidplayground.social_media.ui.components.BottomBarSection
import com.cyrilpillai.androidplayground.social_media.ui.components.CtaSection
import com.cyrilpillai.androidplayground.social_media.ui.components.PostItemSection
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileAndStatsSection
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileDetailsSection
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme

class SocialMediaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val accountBarState = getAccountBarState()
            val bottomBarState = getBottomBarState()
            val statisticsState = getStatisticsState()
            val profileImageState = getProfileImageState()
            val profileDetailsState = getProfileDetailsState()
            val editProfileState = getEditProfileState()
            val postsState = getPostsState()

            AndroidPlaygroundTheme(
                statusBarColor = Color.Black,
                useDarkIcons = false
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    backgroundColor = Color.Black,
                    topBar = {
                        TopBarSection(state = accountBarState)
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
                                statisticsState = statisticsState
                            )
                        }

                        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                            ProfileDetailsSection(
                                state = profileDetailsState
                            )
                        }
                        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                            CtaSection(
                                state = editProfileState,
                            )
                        }

                        items(postsState.posts) { postItem ->
                            PostItemSection(postItem = postItem)
                        }
                    }

                }
            }
        }
    }
}