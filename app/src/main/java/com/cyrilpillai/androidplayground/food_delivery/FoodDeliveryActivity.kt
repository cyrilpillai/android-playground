package com.cyrilpillai.androidplayground.food_delivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.food_delivery.model.RestaurantItem
import com.cyrilpillai.androidplayground.food_delivery.state.getCuisineTypeState
import com.cyrilpillai.androidplayground.food_delivery.state.getFilterState
import com.cyrilpillai.androidplayground.food_delivery.state.getFoodTypeState
import com.cyrilpillai.androidplayground.food_delivery.state.getLocationBarState
import com.cyrilpillai.androidplayground.food_delivery.state.getRestaurantState
import com.cyrilpillai.androidplayground.food_delivery.state.getSearchBarState
import com.cyrilpillai.androidplayground.food_delivery.state.getTopRatedRestaurantState
import com.cyrilpillai.androidplayground.food_delivery.state.locationNames
import com.cyrilpillai.androidplayground.food_delivery.ui.components.CuisineTypeSection
import com.cyrilpillai.androidplayground.food_delivery.ui.components.FilterSection
import com.cyrilpillai.androidplayground.food_delivery.ui.components.FoodTypeSection
import com.cyrilpillai.androidplayground.food_delivery.ui.components.LocationBar
import com.cyrilpillai.androidplayground.food_delivery.ui.components.RestaurantItemSection
import com.cyrilpillai.androidplayground.food_delivery.ui.components.SearchBar
import com.cyrilpillai.androidplayground.food_delivery.ui.components.TopRatedRestaurantSection
import com.cyrilpillai.androidplayground.food_delivery.ui.theme.AndroidPlaygroundTheme
import kotlin.random.Random

class FoodDeliveryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            var locationBarState by remember { mutableStateOf(getLocationBarState()) }

            val searchBarState by remember { mutableStateOf(getSearchBarState()) }

            val foodTypeState by remember { mutableStateOf(getFoodTypeState()) }

            val cuisineTypeState by remember { mutableStateOf(getCuisineTypeState()) }

            val filterState by remember { mutableStateOf(getFilterState()) }

            var topRatedRestaurantState by remember { mutableStateOf(getTopRatedRestaurantState()) }

            var restaurantState by remember { mutableStateOf(getRestaurantState()) }

            AndroidPlaygroundTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    LocationBar(state = locationBarState) {
                        locationBarState = locationBarState.copy(
                            title = locationNames[Random.nextInt(locationNames.size - 1)]
                        )
                    }

                    SearchBar(state = searchBarState)
                    Spacer(modifier = Modifier.padding(6.dp))

                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {

                        item { FoodTypeSection(state = foodTypeState) }

                        item {
                            TopRatedRestaurantSection(state = topRatedRestaurantState) {
                                topRatedRestaurantState = topRatedRestaurantState.copy(
                                    restaurants = onFavoriteClick(it, restaurantState.restaurants)
                                )
                            }
                        }

                        item { CuisineTypeSection(state = cuisineTypeState) }

                        item { FilterSection(state = filterState) }

                        item {
                            Text(
                                text = restaurantState.header,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier
                                    .padding(16.dp)
                            )
                        }

                        itemsIndexed(restaurantState.restaurants) { index, item ->
                            RestaurantItemSection(restaurantItem = item) {
                                restaurantState = restaurantState.copy(
                                    restaurants = onFavoriteClick(
                                        index,
                                        restaurantState.restaurants
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun onFavoriteClick(
    index: Int,
    restaurants: List<RestaurantItem>
): List<RestaurantItem> {
    return restaurants.mapIndexed { i, item ->
        if (i == index) {
            item.copy(isFavorite = !item.isFavorite)
        } else {
            item
        }
    }
}