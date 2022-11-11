package com.cyrilpillai.androidplayground.payments.model

data class ReferralItem(
    val title: String,
    val description: String,
    val codePrefix: String,
    val code: String,
    val ctaItem: CtaItem
)
