package com.cyrilpillai.androidplayground.payments.model

import androidx.annotation.DrawableRes

data class SearchBarItem(
    val hint: String,
    @DrawableRes val icon: Int,
    val profileImageUrl: String
)