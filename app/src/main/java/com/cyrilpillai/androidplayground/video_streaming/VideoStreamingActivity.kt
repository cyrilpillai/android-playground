package com.cyrilpillai.androidplayground.video_streaming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme
import com.cyrilpillai.androidplayground.video_streaming.state.getActionAdventureState
import com.cyrilpillai.androidplayground.video_streaming.state.getBottomBarState
import com.cyrilpillai.androidplayground.video_streaming.state.getComediesState
import com.cyrilpillai.androidplayground.video_streaming.state.getDarkDramaState
import com.cyrilpillai.androidplayground.video_streaming.state.getExcitingState
import com.cyrilpillai.androidplayground.video_streaming.state.getInternationalState
import com.cyrilpillai.androidplayground.video_streaming.state.getMyListState
import com.cyrilpillai.androidplayground.video_streaming.state.getTopPicksState
import com.cyrilpillai.androidplayground.video_streaming.state.getTrendingState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.BottomBarSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.BottomBarState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.TopBarSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.VideoCarouselSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.VideoCarouselState

class VideoStreamingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var bottomBarState by remember { mutableStateOf(getBottomBarState()) }
            val myListState by remember { mutableStateOf(getMyListState()) }
            val trendingState by remember { mutableStateOf(getTrendingState()) }
            val darkDramaState by remember { mutableStateOf(getDarkDramaState()) }
            val excitingState by remember { mutableStateOf(getExcitingState()) }
            val topPicksState by remember { mutableStateOf(getTopPicksState()) }
            val internationalState by remember { mutableStateOf(getInternationalState()) }
            val comediesState by remember { mutableStateOf(getComediesState()) }
            val actionAdventureState by remember { mutableStateOf(getActionAdventureState()) }

            AndroidPlaygroundTheme(
                statusBarColor = Color.Black,
                useDarkIcons = false
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    backgroundColor = Color.Black,
                    bottomBar = {
                        BottomBarSection(state = bottomBarState) { id ->
                            bottomBarState = BottomBarState(bottomBarState.items.map {
                                it.copy(isSelected = it.id == id)
                            })
                        }
                    }) {
                    LazyColumn(
                        contentPadding = PaddingValues(top = 16.dp),
                        modifier = Modifier
                            .padding(it)
                    ) {
                        addVideoCarouselSection(myListState) {}
                        addVideoCarouselSection(trendingState) {}
                        addVideoCarouselSection(darkDramaState) {}
                        addVideoCarouselSection(excitingState) {}
                        addVideoCarouselSection(topPicksState) {}
                        addVideoCarouselSection(comediesState) {}
                        addVideoCarouselSection(internationalState) {}
                        addVideoCarouselSection(actionAdventureState) {}
                    }

                    TopBarSection(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                    )
                }
            }
        }
    }

    private fun LazyListScope.addVideoCarouselSection(
        state: VideoCarouselState,
        onClick: (Int) -> Unit
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
}