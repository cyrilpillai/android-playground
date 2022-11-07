package com.cyrilpillai.androidplayground.food_delivery.model

import androidx.annotation.DrawableRes

data class BottomNavItem(
    val id: Int,
    val label: String,
    @DrawableRes val icon: Int,
    val isSelected: Boolean
)