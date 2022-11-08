package com.cyrilpillai.androidplayground.food_delivery.state

import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.StorageBucket.FOOD_DELIVERY
import com.cyrilpillai.androidplayground.food_delivery.model.BottomNavItem
import com.cyrilpillai.androidplayground.food_delivery.model.CuisineTypeItem
import com.cyrilpillai.androidplayground.food_delivery.model.FilterItem
import com.cyrilpillai.androidplayground.food_delivery.model.FoodTypeItem
import com.cyrilpillai.androidplayground.food_delivery.model.RestaurantItem
import com.cyrilpillai.androidplayground.food_delivery.ui.components.BottomBarState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.CuisineTypeState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.FilterState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.FoodTypeState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.HorizontalRestaurantCarouselState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.LocationBarState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.SearchBarState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.VerticalRestaurantsState
import com.cyrilpillai.androidplayground.getQualifiedImageUrl

val locationNames = listOf("Home", "Office", "Work", "Hotel")

fun getLocationBarState(): LocationBarState {
    return LocationBarState(
        title = locationNames[0],
        description = "#101, Pinnacle Towers, Avenue Street, India"
    )
}

fun getSearchBarState(): SearchBarState {
    return SearchBarState(
        hint = "Search for restaurant, item or more"
    )
}

fun getFoodTypeState(): FoodTypeState {
    return FoodTypeState(
        firstFoodType = FoodTypeItem(
            title = "Offer Zone",
            icon = R.drawable.ic_discount
        ),
        secondFoodType = FoodTypeItem(
            title = "guiltfree",
            icon = R.drawable.ic_burger
        ),
        thirdFoodType = FoodTypeItem(
            title = "gourmet",
            icon = R.drawable.ic_sushi
        )
    )
}

fun getBottomBarState(): BottomBarState {
    return BottomBarState(
        listOf(
            BottomNavItem(
                id = 1,
                label = "Swiggy",
                icon = R.drawable.ic_swiggy,
                isSelected = false
            ),
            BottomNavItem(
                id = 2,
                label = "Food",
                icon = R.drawable.ic_food,
                isSelected = true
            ),
            BottomNavItem(
                id = 3,
                label = "Instamart",
                icon = R.drawable.ic_mart,
                isSelected = false
            ),
            BottomNavItem(
                id = 4,
                label = "Dineout",
                icon = R.drawable.ic_dining,
                isSelected = false
            ),
            BottomNavItem(
                id = 5,
                label = "Minis",
                icon = R.drawable.ic_shopping,
                isSelected = false
            ),
        )
    )
}


fun getCuisineTypeState(): CuisineTypeState {
    return CuisineTypeState(
        header = "What's on your mind?",
        cuisines = listOf(
            CuisineTypeItem(
                name = "Biryani",
                imageUrl = getQualifiedImageUrl("cuisine_1", FOOD_DELIVERY)
            ), CuisineTypeItem(
                name = "Pizza",
                imageUrl = getQualifiedImageUrl("cuisine_2", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Chinese",
                imageUrl = getQualifiedImageUrl("cuisine_3", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "North Indian",
                imageUrl = getQualifiedImageUrl("cuisine_4", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "South Indian",
                imageUrl = getQualifiedImageUrl("cuisine_5", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Pure Veg",
                imageUrl = getQualifiedImageUrl("cuisine_6", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Pasta",
                imageUrl = getQualifiedImageUrl("cuisine_7", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Dosa",
                imageUrl = getQualifiedImageUrl("cuisine_8", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Idli",
                imageUrl = getQualifiedImageUrl("cuisine_9", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Vada",
                imageUrl = getQualifiedImageUrl("cuisine_10", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Paratha",
                imageUrl = getQualifiedImageUrl("cuisine_11", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Tea",
                imageUrl = getQualifiedImageUrl("cuisine_12", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Coffee",
                imageUrl = getQualifiedImageUrl("cuisine_13", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Upma",
                imageUrl = getQualifiedImageUrl("cuisine_14", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Shawarma",
                imageUrl = getQualifiedImageUrl("cuisine_15", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Shakes",
                imageUrl = getQualifiedImageUrl("cuisine_16", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Pancake",
                imageUrl = getQualifiedImageUrl("cuisine_17", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Ice Cream",
                imageUrl = getQualifiedImageUrl("cuisine_18", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Khichdi",
                imageUrl = getQualifiedImageUrl("cuisine_19", FOOD_DELIVERY)
            ),
            CuisineTypeItem(
                name = "Rolls",
                imageUrl = getQualifiedImageUrl("cuisine_20", FOOD_DELIVERY)
            )
        )
    )
}

fun getFilterState(): FilterState {
    return FilterState(
        filters = listOf(
            FilterItem(
                title = "Filter",
                icon = R.drawable.ic_filter
            ),
            FilterItem(
                title = "Sort By",
                icon = R.drawable.ic_expand_more
            ),
            FilterItem(
                title = "Fast Delivery"
            ),
            FilterItem(
                title = "Cuisines",
                icon = R.drawable.ic_expand_more
            ),
            FilterItem(
                title = "New on Swiggy"
            ),
            FilterItem(
                title = "Ratings 4.0+"
            ),
            FilterItem(
                title = "Pure Veg"
            ),
            FilterItem(
                title = "Offers"
            ),
            FilterItem(
                title = "Rs.300-Rs.600"
            ),
            FilterItem(
                title = "Less than Rs.300"
            )
        )
    )
}

fun getTopRatedRestaurantState(): HorizontalRestaurantCarouselState {
    return HorizontalRestaurantCarouselState(
        header = "Top rated near you",
        restaurants = getRestaurants().toList().shuffled()
    )
}

fun getFastDeliveryRestaurantState(): HorizontalRestaurantCarouselState {
    return HorizontalRestaurantCarouselState(
        header = "Get it quickly",
        restaurants = getRestaurants().toList().shuffled()
    )
}

fun getRestaurantState(): VerticalRestaurantsState {
    return VerticalRestaurantsState(
        header = "140 restaurants to explore",
        restaurants = getRestaurants().toList().shuffled()
    )
}

fun getRestaurants(): List<RestaurantItem> {
    return listOf(
        RestaurantItem(
            id = 1,
            name = "McDonald's",
            description = "Burgers, Beverages",
            imageUrl = getQualifiedImageUrl("restaurant_1", FOOD_DELIVERY),
            rating = 4.3,
            reviewCount = "1K+",
            benefit = "EXTRA 10% OFF",
            locality = "Saki Naka",
            eta = "35 mins",
            distance = "1.6 kms",
            isFavorite = false,
            dealTitle = "10% OFF",
            dealSubTitle = "UPTO ₹40",
        ),
        RestaurantItem(
            id = 2,
            name = "Trupti Sweets and Farsan",
            description = "Sweets, Desserts",
            imageUrl = getQualifiedImageUrl("restaurant_2", FOOD_DELIVERY),
            rating = 4.4,
            reviewCount = "1K+",
            benefit = "FREE DELIVERY",
            locality = "Vile Parle",
            eta = "40 mins",
            distance = "4.5 kms",
            isFavorite = false,
            dealTitle = "40% OFF",
            dealSubTitle = "UPTO ₹80",
        ),
        RestaurantItem(
            id = 3,
            name = "Subway",
            description = "Salads, Snacks",
            imageUrl = getQualifiedImageUrl("restaurant_3", FOOD_DELIVERY),
            rating = 4.3,
            reviewCount = "1K+",
            benefit = "EXTRA 10% OFF",
            locality = "Andheri East",
            eta = "36 mins",
            distance = "2.7 kms",
            isFavorite = true,
            dealTitle = "20% OFF",
            dealSubTitle = "UPTO ₹50",
        ),
        RestaurantItem(
            id = 4,
            name = "Jeden - the Cake Expert",
            description = "Desserts, Bakery",
            imageUrl = getQualifiedImageUrl("restaurant_4", FOOD_DELIVERY),
            rating = 4.3,
            reviewCount = "100+",
            benefit = "EXTRA 10% OFF",
            locality = "Andheri East",
            eta = "25 mins",
            distance = "1.2 kms",
            isFavorite = false,
            dealTitle = "60% OFF",
            dealSubTitle = "UPTO ₹280",
        ),
        RestaurantItem(
            id = 5,
            name = "Babu Vada Pav",
            description = "Desserts, Bakery",
            imageUrl = getQualifiedImageUrl("restaurant_5", FOOD_DELIVERY),
            rating = 4.5,
            reviewCount = "500+",
            benefit = "FREE DELIVERY",
            locality = "Vile Parle",
            eta = "41 mins",
            distance = "2.8 kms",
            isFavorite = false,
            dealTitle = "FREE ITEM"
        ),
        RestaurantItem(
            id = 6,
            name = "Apsara Ice Creams",
            description = "Ice Cream, Desserts",
            imageUrl = getQualifiedImageUrl("restaurant_6", FOOD_DELIVERY),
            rating = 4.6,
            reviewCount = "100+",
            benefit = "EXTRA 10% OFF",
            locality = "Andheri East",
            eta = "32 mins",
            distance = "0.6 kms",
            isFavorite = true,
            dealTitle = "20% OFF",
            dealSubTitle = "UPTO ₹150"
        ),
        RestaurantItem(
            id = 7,
            name = "Persia Darbar",
            description = "Mughlai, North Indian",
            imageUrl = getQualifiedImageUrl("restaurant_7", FOOD_DELIVERY),
            rating = 4.1,
            reviewCount = "50+",
            benefit = "EXTRA 10% OFF",
            locality = "Jogeshwari West",
            eta = "51 mins",
            distance = "5.3 kms",
            isFavorite = false,
            dealTitle = "FLAT DEAL ₹125 OFF",
            dealSubTitle = "ABOVE ₹249"
        )
    )
}