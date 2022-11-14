package com.cyrilpillai.androidplayground.utils

const val STORAGE_BUCKET_BASE_URL =
    "https://firebasestorage.googleapis.com/v0/b/compose-a1b16.appspot.com/o"

enum class StorageBucket(val key: String) {
    FOOD_DELIVERY("food_delivery"),
    SOCIAL_MEDIA("social_media"),
    MESSAGING("messaging"),
    PAYMENT("payment"),
    VIDEO_STREAMING("video_streaming")
}

enum class ImageType(val key: String) {
    JPEG("jpeg"),
    PNG("png")
}

fun getQualifiedImageUrl(
    relativeName: String,
    storageBucket: StorageBucket,
    imageType: ImageType = ImageType.JPEG
): String {
    return "$STORAGE_BUCKET_BASE_URL/${storageBucket.key}%2F$relativeName.${imageType.key}?alt=media"
}