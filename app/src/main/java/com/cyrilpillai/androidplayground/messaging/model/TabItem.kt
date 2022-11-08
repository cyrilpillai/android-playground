package com.cyrilpillai.androidplayground.messaging.model

import androidx.compose.runtime.Composable
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.messaging.ui.components.CallSection
import com.cyrilpillai.androidplayground.messaging.ui.components.ChatSection
import com.cyrilpillai.androidplayground.messaging.ui.components.CommunitySection

sealed class TabItem(
    val icon: Int? = null,
    val title: String? = null,
    val screen: @Composable () -> Unit
) {
    object Community : TabItem(icon = R.drawable.ic_community, screen = { CommunitySection() })
    object Chat : TabItem(title = "CHATS", screen = { ChatSection() })
    object Status : TabItem(title = "STATUS", screen = { ChatSection() })
    object Call : TabItem(title = "CALLS", screen = { CallSection() })
}