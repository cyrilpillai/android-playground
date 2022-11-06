package com.cyrilpillai.androidplayground.social_media.model

data class PostItem(
    val imageUrl: String,
    val postType: PostType
)

enum class PostType {
    SINGLE_IMAGE, MULTIPLE_IMAGES, VIDEO
}