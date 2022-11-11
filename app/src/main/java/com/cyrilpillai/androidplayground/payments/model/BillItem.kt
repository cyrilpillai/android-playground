package com.cyrilpillai.androidplayground.payments.model

import androidx.annotation.DrawableRes

data class BillItem(
    @DrawableRes val icon: Int,
    val description: String,
    val suggestionHeader: String,
    val cta: String,
    val billSuggestions: List<BillSuggestion>
)

data class BillSuggestion(
    @DrawableRes val icon: Int,
    val description: String
)