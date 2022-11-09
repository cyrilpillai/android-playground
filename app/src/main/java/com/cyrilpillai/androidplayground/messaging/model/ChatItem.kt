package com.cyrilpillai.androidplayground.messaging.model

data class ChatItem(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val message: String,
    val date: String
) {
    constructor(messagingItem: MessagingItem) : this(
        id = messagingItem.id,
        name = messagingItem.name,
        imageUrl = messagingItem.imageUrl,
        message = messagingItem.message,
        date = messagingItem.date
    )
}