package com.cyrilpillai.androidplayground.social_media.model

import androidx.annotation.DrawableRes

data class TabItem(
    val position: Int,
    val isSelected: Boolean,
    @DrawableRes val icon: Int,
    val contentDescription: String
)