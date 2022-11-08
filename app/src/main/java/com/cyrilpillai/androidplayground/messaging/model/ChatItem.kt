package com.cyrilpillai.androidplayground.messaging.model

data class ChatItem(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val message: String,
    val timestamp: String
)