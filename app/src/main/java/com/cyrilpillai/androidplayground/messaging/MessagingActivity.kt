package com.cyrilpillai.androidplayground.messaging

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.FabPosition.Companion
import androidx.compose.material.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import com.cyrilpillai.androidplayground.messaging.model.TabItem
import com.cyrilpillai.androidplayground.messaging.state.getChatState
import com.cyrilpillai.androidplayground.messaging.state.getFloatingActionButtonState
import com.cyrilpillai.androidplayground.messaging.state.getTabs
import com.cyrilpillai.androidplayground.messaging.state.getTopBarState
import com.cyrilpillai.androidplayground.messaging.ui.components.CallSection
import com.cyrilpillai.androidplayground.messaging.ui.components.ChatSection
import com.cyrilpillai.androidplayground.messaging.ui.components.ChatState
import com.cyrilpillai.androidplayground.messaging.ui.components.CommunitySection
import com.cyrilpillai.androidplayground.messaging.ui.components.FloatingActionButtonSection
import com.cyrilpillai.androidplayground.messaging.ui.components.FloatingActionButtonState
import com.cyrilpillai.androidplayground.messaging.ui.components.StatusSection
import com.cyrilpillai.androidplayground.messaging.ui.components.TabsContentSection
import com.cyrilpillai.androidplayground.messaging.ui.components.TabsSection
import com.cyrilpillai.androidplayground.messaging.ui.components.TopBarSection
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme
import com.cyrilpillai.androidplayground.ui.theme.Teal600
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.flow.collect

class MessagingActivity : ComponentActivity() {
    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val topBarState by remember { mutableStateOf(getTopBarState()) }
            val chatState by remember { mutableStateOf(getChatState()) }
            val tabs = getTabs()
            val pagerState = rememberPagerState(1)
            var floatingActionButtonState by remember {
                mutableStateOf(
                    getFloatingActionButtonState(
                        pagerState.currentPage
                    )
                )
            }

            //Change FAB icon when tab is changed
            LaunchedEffect(pagerState) {
                snapshotFlow { pagerState.currentPage }.collect { page ->
                    floatingActionButtonState = getFloatingActionButtonState(page)
                }
            }

            AndroidPlaygroundTheme(
                statusBarColor = Teal600,
                useDarkIcons = false
            ) {
                Scaffold(
                    topBar = {
                        TopBarSection(
                            state = topBarState
                        )
                    },
                    floatingActionButton = {
                        FloatingActionButtonSection(state = floatingActionButtonState) {

                        }
                    }
                ) {
                    Column(
                        modifier = Modifier
                            .padding(it)
                    ) {
                        TabsSection(
                            tabs = tabs,
                            pagerState = pagerState
                        )
                        TabsContentSection(
                            tabSize = tabs.size,
                            pagerState = pagerState,
                            modifier = Modifier
                                .fillMaxSize()
                        ) { index ->
                            when (tabs[index]) {
                                is TabItem.Community -> CommunitySection()
                                is TabItem.Chat -> ChatSection(chatState)
                                is TabItem.Status -> StatusSection()
                                is TabItem.Call -> CallSection()
                            }
                        }
                    }
                }
            }
        }
    }
}
