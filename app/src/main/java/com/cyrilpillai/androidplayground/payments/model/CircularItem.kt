package com.cyrilpillai.androidplayground.payments.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

sealed class CircularItem {
    data class Info(
        val description: String,
        val backgroundColor: Color,
        val imageUrl: String?
    ) : CircularItem()

    data class Toggle(
        val description: String,
        @DrawableRes val icon: Int
    ) : CircularItem()
}