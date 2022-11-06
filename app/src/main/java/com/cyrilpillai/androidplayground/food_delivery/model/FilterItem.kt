package com.cyrilpillai.androidplayground.food_delivery.model

import androidx.annotation.DrawableRes

data class FilterItem(
    val title: String,
    @DrawableRes val icon: Int? = null
)