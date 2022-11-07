package com.cyrilpillai.androidplayground.social_media.model

import androidx.annotation.DrawableRes

data class BottomNavItem(
    @DrawableRes val icon: Int,
    val isSelected: Boolean
)