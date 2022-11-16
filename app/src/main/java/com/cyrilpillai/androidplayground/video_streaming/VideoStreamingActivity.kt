package com.cyrilpillai.androidplayground.video_streaming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme
import com.cyrilpillai.androidplayground.video_streaming.model.BottomNavItem
import com.cyrilpillai.androidplayground.video_streaming.model.FastLaughItem
import com.cyrilpillai.androidplayground.video_streaming.model.NewAndHotItem
import com.cyrilpillai.androidplayground.video_streaming.state.getDownloadsScreenState
import com.cyrilpillai.androidplayground.video_streaming.state.getFastLaughsState
import com.cyrilpillai.androidplayground.video_streaming.state.getNewAndHotContentState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.BottomBarSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.DownloadsScreenSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.DownloadsScreenState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.FastLaughsScreenSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.FastLaughsState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.HomeScreenSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.NewAndHotScreenSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.NewAndHotState

class VideoStreamingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            var fastLaughsState by remember { mutableStateOf(getFastLaughsState()) }
            var newAndHotState by remember { mutableStateOf(getNewAndHotContentState()) }
            val downloadsScreenState by remember { mutableStateOf(getDownloadsScreenState()) }
            val navController = rememberNavController()

            AndroidPlaygroundTheme(
                statusBarColor = Color.Black, useDarkIcons = false
            ) {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    backgroundColor = Color.Black,
                    bottomBar = {
                        BottomBarSection(navController = navController)
                    }) {
                    NavigationGraph(
                        navController = navController,
                        downloadsScreenState = downloadsScreenState,
                        fastLaughsState = fastLaughsState,
                        onFastLaughVolumeToggleClick = { fastLaughItem ->
                            fastLaughsState =
                                FastLaughsState(
                                    fastLaughsState.fastLaughs.map { item ->
                                        if (fastLaughItem.id == item.id) {
                                            item.copy(volumeOn = !item.volumeOn)
                                        } else {
                                            item
                                        }
                                    })
                        },
                        newAndHotState = newAndHotState,
                        onNewAndHotItemVolumeToggleClick = { newAndHotItem ->
                            newAndHotState =
                                NewAndHotState(
                                    newAndHotState.newAndHotList.map { item ->
                                        if (newAndHotItem.id == item.id) {
                                            item.copy(volumeOn = !item.volumeOn)
                                        } else {
                                            item
                                        }
                                    })
                        },
                        modifier = Modifier.padding(it)
                    )
                }
            }
        }
    }

    @Composable
    fun NavigationGraph(
        navController: NavHostController,
        downloadsScreenState: DownloadsScreenState,
        fastLaughsState: FastLaughsState,
        onFastLaughVolumeToggleClick: (fastLaughItem: FastLaughItem) -> Unit,
        newAndHotState: NewAndHotState,
        onNewAndHotItemVolumeToggleClick: (newAndHotItem: NewAndHotItem) -> Unit,
        modifier: Modifier = Modifier
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.screenRoute,
            modifier = modifier.fillMaxSize()
        ) {
            composable(BottomNavItem.Home.screenRoute) {
                HomeScreenSection()
            }
            composable(BottomNavItem.NewAndHot.screenRoute) {
                NewAndHotScreenSection(
                    state = newAndHotState,
                    onVolumeToggleClick = onNewAndHotItemVolumeToggleClick
                )
            }
            composable(BottomNavItem.FastLaughs.screenRoute) {
                FastLaughsScreenSection(
                    state = fastLaughsState,
                    onVolumeToggleClick = onFastLaughVolumeToggleClick
                )
            }
            composable(BottomNavItem.Downloads.screenRoute) {
                DownloadsScreenSection(
                    state = downloadsScreenState
                )
            }
        }
    }

}