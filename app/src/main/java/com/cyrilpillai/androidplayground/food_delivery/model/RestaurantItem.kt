package com.cyrilpillai.androidplayground.food_delivery.model

data class RestaurantItem(
    val name: String,
    val description: String,
    val imageUrl: String,
    val rating: Double,
    val reviewCount: String,
    val benefit: String,
    val locality: String,
    val eta: String,
    val distance: String,
    val dealTitle: String? = null,
    val dealSubTitle: String? = null,
    val isFavorite: Boolean = false
)
