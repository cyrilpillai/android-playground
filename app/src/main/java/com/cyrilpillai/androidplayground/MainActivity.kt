package com.cyrilpillai.androidplayground

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.food_delivery.FoodDeliveryActivity
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
import com.cyrilpillai.androidplayground.social_media.SocialMediaActivity
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPlaygroundTheme {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Button(
                        onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    FoodDeliveryActivity::class.java
                                )
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Food Delivery")
                    }

                    Button(
                        onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity,
                                    SocialMediaActivity::class.java
                                )
                            )
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Social Media")
                    }
                }
            }
        }
    }
}