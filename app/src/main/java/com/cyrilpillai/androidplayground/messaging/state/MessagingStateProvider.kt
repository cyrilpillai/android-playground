package com.cyrilpillai.androidplayground.messaging.state

import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.messaging.model.TabItem
import com.cyrilpillai.androidplayground.messaging.ui.components.FloatingActionButtonState
import com.cyrilpillai.androidplayground.messaging.ui.components.TopBarState

fun getTopBarState(): TopBarState {
    return TopBarState("WhatsApp")
}

fun getTabs(): List<TabItem> {
    return listOf(
        TabItem.Community,
        TabItem.Chat,
        TabItem.Status,
        TabItem.Call
    )
}

fun getFloatingActionButtonState(selectedTabPosition: Int): FloatingActionButtonState {
    return FloatingActionButtonState(
        when (selectedTabPosition) {
            1 -> R.drawable.ic_message
            2 -> R.drawable.ic_camera_filled
            3 -> R.drawable.ic_add_call
            else -> null
        }
    )
}