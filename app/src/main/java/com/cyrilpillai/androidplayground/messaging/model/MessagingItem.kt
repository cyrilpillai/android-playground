package com.cyrilpillai.androidplayground.messaging.model

data class MessagingItem(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val message: String,
    val date: String,
    val timestamp: String
)