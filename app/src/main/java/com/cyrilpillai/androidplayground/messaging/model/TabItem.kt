package com.cyrilpillai.androidplayground.messaging.model

import com.cyrilpillai.androidplayground.R

sealed class TabItem(
    val icon: Int? = null,
    val title: String? = null
) {
    object Community : TabItem(icon = R.drawable.ic_community)
    object Chat : TabItem(title = "CHATS")
    object Status : TabItem(title = "STATUS")
    object Call : TabItem(title = "CALLS")
}