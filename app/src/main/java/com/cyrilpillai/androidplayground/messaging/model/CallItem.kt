package com.cyrilpillai.androidplayground.messaging.model

import androidx.annotation.DrawableRes

data class CallLinkItem(
    val title: String,
    val description: String,
    @DrawableRes val icon: Int
)

data class CallItem(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val timestamp: String,
    val type: CallType,
    val mode: CallMode,
    val status: CallStatus
) {
    constructor(
        messagingItem: MessagingItem,
        callType: CallType,
        callMode: CallMode,
        callStatus: CallStatus
    ) : this(
        id = messagingItem.id,
        name = messagingItem.name,
        imageUrl = messagingItem.imageUrl,
        timestamp = messagingItem.timestamp,
        type = callType,
        mode = callMode,
        status = callStatus
    )
}

enum class CallType { INCOMING, OUTGOING }
enum class CallMode { VIDEO, VOICE }
enum class CallStatus { MISSED, PICKED }