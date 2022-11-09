package com.cyrilpillai.androidplayground.messaging.model

data class MyStatusItem(
    val title: String,
    val description: String,
    val imageUrl: String
)

data class StatusItem(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val timestamp: String,
    val count: Int
) {
    constructor(
        messagingItem: MessagingItem,
        count: Int
    ) : this(
        id = messagingItem.id,
        name = messagingItem.name,
        imageUrl = messagingItem.imageUrl,
        timestamp = messagingItem.timestamp,
        count = count
    )
}