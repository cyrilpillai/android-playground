package com.cyrilpillai.androidplayground.video_streaming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme
import com.cyrilpillai.androidplayground.video_streaming.state.getBottomBarState
import com.cyrilpillai.androidplayground.video_streaming.state.getTrendingState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.BottomBarSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.BottomBarState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.TopBarSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.VideoCarouselSection

class VideoStreamingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var bottomBarState by remember { mutableStateOf(getBottomBarState()) }
            val trendingState by remember { mutableStateOf(getTrendingState()) }

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
                    LazyColumn(
                        modifier = Modifier
                            .padding(it)
                    ) {
                        item {
                            VideoCarouselSection(state = trendingState) {

                            }
                        }
                    }
                }
            }
        }
    }
}