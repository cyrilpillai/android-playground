package com.cyrilpillai.androidplayground.payments.model

import androidx.annotation.DrawableRes

data class ActionItem(
    val description: String,
    @DrawableRes val icon: Int
)