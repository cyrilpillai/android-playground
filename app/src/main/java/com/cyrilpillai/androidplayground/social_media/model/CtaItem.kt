package com.cyrilpillai.androidplayground.social_media.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class CtaItem(
    val text: String? = null,
    @DrawableRes val icon: Int? = null,
    val color: Color = Color.White
)