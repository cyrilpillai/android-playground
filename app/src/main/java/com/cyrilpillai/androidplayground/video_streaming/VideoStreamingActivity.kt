package com.cyrilpillai.androidplayground.video_streaming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme
import com.cyrilpillai.androidplayground.ui.theme.BlackTransparent
import com.cyrilpillai.androidplayground.video_streaming.model.BottomNavItem
import com.cyrilpillai.androidplayground.video_streaming.model.FastLaughItem
import com.cyrilpillai.androidplayground.video_streaming.state.getDownloadsScreenState
import com.cyrilpillai.androidplayground.video_streaming.state.getFastLaughsState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.BottomBarSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.DownloadsScreenSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.DownloadsScreenState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.FastLaughsScreenSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.FastLaughsState
import com.cyrilpillai.androidplayground.video_streaming.ui.components.HomeScreenSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.NewAndHotScreenSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.TopBarSection
import com.cyrilpillai.androidplayground.video_streaming.ui.components.TopBarState

class VideoStreamingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var topBarState by remember {
                mutableStateOf(
                    TopBarState(
                        showLogo = true,
                        showIcons = true
                    )
                )
            }
            var fastLaughsState by remember { mutableStateOf(getFastLaughsState()) }
            val downloadsScreenState by remember { mutableStateOf(getDownloadsScreenState()) }
            val navController = rememberNavController()
            val listState = rememberLazyListState()
            val firstVisibleIndex by remember {
                derivedStateOf { listState.firstVisibleItemIndex }
            }
            val firstVisibleItemScrollOffset by remember {
                derivedStateOf { listState.firstVisibleItemScrollOffset }
            }


            AndroidPlaygroundTheme(
                statusBarColor = Color.Black,
                useDarkIcons = false
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    backgroundColor = Color.Black,
                    bottomBar = {
                        BottomBarSection(navController = navController)
                    }) {
                    NavigationGraph(
                        navController = navController,
                        listState = listState,
                        downloadsScreenState = downloadsScreenState,
                        fastLaughsState = fastLaughsState,
                        onFastLaughVolumeToggleClick = { fastLaughItem ->
                            fastLaughsState = FastLaughsState(
                                fastLaughsState.fastLaughs
                                    .map { item ->
                                        if (fastLaughItem.id == item.id) {
                                            item.copy(volumeOn = !item.volumeOn)
                                        } else {
                                            item
                                        }
                                    }
                            )
                        },
                        modifier = Modifier
                            .padding(it)
                    )

                    navController.addOnDestinationChangedListener { _, destination, _ ->
                        topBarState = when (destination.route) {
                            BottomNavItem.Home.screenRoute -> TopBarState(
                                showLogo = true,
                                showIcons = true
                            )
                            BottomNavItem.NewAndHot.screenRoute -> TopBarState(
                                title = BottomNavItem.NewAndHot.title,
                                showIcons = true
                            )
                            BottomNavItem.Downloads.screenRoute -> TopBarState(
                                title = BottomNavItem.Downloads.title,
                                showIcons = true
                            )
                            else -> TopBarState()
                        }
                    }

                    val color = if (firstVisibleIndex == 0 && firstVisibleItemScrollOffset == 0) {
                        Color.Transparent
                    } else {
                        BlackTransparent
                    }
                    TopBarSection(
                        state = topBarState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color)
                            .padding(
                                horizontal = 16.dp,
                                vertical = 8.dp
                            )
                    )
                }
            }
        }
    }

    @Composable
    fun NavigationGraph(
        navController: NavHostController,
        listState: LazyListState,
        downloadsScreenState: DownloadsScreenState,
        fastLaughsState: FastLaughsState,
        onFastLaughVolumeToggleClick: (fastLaughItem: FastLaughItem) -> Unit,
        modifier: Modifier = Modifier
    ) {
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Home.screenRoute,
            modifier = modifier
                .fillMaxSize()
        ) {
            composable(BottomNavItem.Home.screenRoute) {
                HomeScreenSection(listState = listState)
            }
            composable(BottomNavItem.NewAndHot.screenRoute) {
                NewAndHotScreenSection()
            }
            composable(BottomNavItem.FastLaughs.screenRoute) {
                FastLaughsScreenSection(
                    state = fastLaughsState,
                    onVolumeToggleClick = onFastLaughVolumeToggleClick
                )
            }
            composable(BottomNavItem.Downloads.screenRoute) {
                DownloadsScreenSection(
                    state = downloadsScreenState,
                    modifier = Modifier
                        .padding(top = 48.dp)
                )
            }
        }
    }

}