package com.cyrilpillai.androidplayground.food_delivery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
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
import com.cyrilpillai.androidplayground.food_delivery.state.getBottomBarState
import com.cyrilpillai.androidplayground.food_delivery.state.getCuisineTypeState
import com.cyrilpillai.androidplayground.food_delivery.state.getFastDeliveryRestaurantState
import com.cyrilpillai.androidplayground.food_delivery.state.getFilterState
import com.cyrilpillai.androidplayground.food_delivery.state.getFoodTypeState
import com.cyrilpillai.androidplayground.food_delivery.state.getLocationBarState
import com.cyrilpillai.androidplayground.food_delivery.state.getRestaurantState
import com.cyrilpillai.androidplayground.food_delivery.state.getSearchBarState
import com.cyrilpillai.androidplayground.food_delivery.state.getTopRatedRestaurantState
import com.cyrilpillai.androidplayground.food_delivery.state.locationNames
import com.cyrilpillai.androidplayground.food_delivery.ui.components.BottomBarSection
import com.cyrilpillai.androidplayground.food_delivery.ui.components.BottomBarState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.CuisineTypeSection
import com.cyrilpillai.androidplayground.food_delivery.ui.components.FilterSection
import com.cyrilpillai.androidplayground.food_delivery.ui.components.FoodTypeSection
import com.cyrilpillai.androidplayground.food_delivery.ui.components.HorizontalRestaurantCarouselSection
import com.cyrilpillai.androidplayground.food_delivery.ui.components.RestaurantItemSection
import com.cyrilpillai.androidplayground.food_delivery.ui.components.TopBarSection
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme
import kotlin.random.Random

class FoodDeliveryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var locationBarState by remember { mutableStateOf(getLocationBarState()) }
            val searchBarState by remember { mutableStateOf(getSearchBarState()) }
            var bottomBarState by remember { mutableStateOf(getBottomBarState()) }
            val foodTypeState by remember { mutableStateOf(getFoodTypeState()) }
            val cuisineTypeState by remember { mutableStateOf(getCuisineTypeState()) }
            val filterState by remember { mutableStateOf(getFilterState()) }
            var topRatedRestaurantState by remember { mutableStateOf(getTopRatedRestaurantState()) }
            var fastDeliveryRestaurantState by remember {
                mutableStateOf(
                    getFastDeliveryRestaurantState()
                )
            }

            var restaurantState by remember { mutableStateOf(getRestaurantState()) }

            AndroidPlaygroundTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    backgroundColor = Color.White,
                    topBar = {
                        TopBarSection(
                            locationBarState = locationBarState,
                            searchBarState = searchBarState,
                            modifier = Modifier
                                .padding(
                                    top = 8.dp,
                                    start = 16.dp,
                                    end = 16.dp,
                                    bottom = 16.dp
                                )
                        ) {
                            locationBarState = locationBarState.copy(
                                title = locationNames[Random.nextInt(locationNames.size - 1)]
                            )
                        }
                    },
                    bottomBar = {
                        BottomBarSection(state = bottomBarState) { id ->
                            bottomBarState = BottomBarState(bottomBarState.items.map {
                                it.copy(isSelected = it.id == id)
                            })
                        }
                    }) {

                    LazyColumn(
                        modifier = Modifier
                            .padding(it)
                    ) {
                        item {
                            FoodTypeSection(
                                state = foodTypeState,
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                            )
                        }

                        item {
                            HorizontalRestaurantCarouselSection(
                                state = topRatedRestaurantState,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                            ) { id ->
                                topRatedRestaurantState = topRatedRestaurantState.copy(
                                    restaurants = onFavoriteClick(
                                        id,
                                        topRatedRestaurantState.restaurants
                                    )
                                )
                            }
                        }

                        item {
                            CuisineTypeSection(
                                state = cuisineTypeState,
                                modifier = Modifier
                                    .padding(top = 8.dp)
                            )
                        }

                        item {
                            HorizontalRestaurantCarouselSection(
                                state = fastDeliveryRestaurantState,
                                modifier = Modifier
                                    .padding(top = 10.dp)
                            ) { id ->
                                fastDeliveryRestaurantState = fastDeliveryRestaurantState.copy(
                                    restaurants = onFavoriteClick(
                                        id,
                                        fastDeliveryRestaurantState.restaurants
                                    )
                                )
                            }
                        }

                        item {
                            FilterSection(
                                state = filterState,
                                modifier = Modifier
                                    .padding(top = 32.dp)
                            )
                        }

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

                        items(restaurantState.restaurants) { item ->
                            RestaurantItemSection(
                                restaurantItem = item,
                                modifier = Modifier
                                    .padding(
                                        vertical = 8.dp,
                                        horizontal = 16.dp
                                    )
                            ) {
                                restaurantState = restaurantState.copy(
                                    restaurants = onFavoriteClick(
                                        item.id,
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
    id: Int,
    restaurants: List<RestaurantItem>
): List<RestaurantItem> {
    return restaurants.map {
        if (it.id == id) {
            it.copy(isFavorite = !it.isFavorite)
        } else {
            it
        }
    }
}