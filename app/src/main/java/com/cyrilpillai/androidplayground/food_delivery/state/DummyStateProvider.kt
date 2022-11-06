package com.cyrilpillai.androidplayground.food_delivery.state

import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.food_delivery.model.CuisineTypeItem
import com.cyrilpillai.androidplayground.food_delivery.model.FilterItem
import com.cyrilpillai.androidplayground.food_delivery.model.FoodTypeItem
import com.cyrilpillai.androidplayground.food_delivery.model.RestaurantItem
import com.cyrilpillai.androidplayground.food_delivery.ui.components.CuisineTypeState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.FilterState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.FoodTypeState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.LocationBarState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.RestaurantState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.SearchBarState
import com.cyrilpillai.androidplayground.food_delivery.ui.components.TopRatedRestaurantState

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

fun getCuisineTypeState(): CuisineTypeState {
    return CuisineTypeState(
        header = "What's on your mind?",
        cuisines = listOf(
            CuisineTypeItem(
                name = "Biryani",
                imageUrl = "https://www.pngitem.com/pimgs/m/151-1519906_chicken-biryani-top-view-hd-png-download.png"
            ), CuisineTypeItem(
                name = "Pizza",
                imageUrl = "https://www.dominos.co.in/theme2/front/images/menu-images/my-nonveg.webp"
            ),
            CuisineTypeItem(
                name = "Chinese",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYUyra9cjgThp3HVFh0jlY6JUi4uXeCb4ETw&usqp=CAU"
            ),
            CuisineTypeItem(
                name = "North Indian",
                imageUrl = "https://img.favpng.com/19/25/17/north-indian-cuisine-vegetarian-cuisine-thali-south-indian-cuisine-png-favpng-jJh0Qjxkr0kzX2v4q1hZefe7R.jpg"
            ),
            CuisineTypeItem(
                name = "South Indian",
                imageUrl = "https://i.pinimg.com/originals/10/31/7b/10317b1eb2d6df590aca903ec599ba2d.jpg"
            ),
            CuisineTypeItem(
                name = "Pure Veg",
                imageUrl = "https://theviewfromgreatisland.com/wp-content/uploads/2019/01/roasted-vegetable-bliss-bowl-3937-January-05-2019-2.jpg"
            ),
            CuisineTypeItem(
                name = "Pasta",
                imageUrl = "https://www.licious.in/blog/wp-content/uploads/2020/12/Penne-Alfredo-750x750.jpg"
            ),
            CuisineTypeItem(
                name = "Dosa",
                imageUrl = "https://www.cookwithmanali.com/wp-content/uploads/2020/05/Masala-Dosa.jpg"
            ),
            CuisineTypeItem(
                name = "Idli",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQRhienzTJmixP6QxPytA9yuqGS16nvsVtBFA&usqp=CAU"
            ),
            CuisineTypeItem(
                name = "Vada",
                imageUrl = "https://images.herzindagi.info/image/2021/Aug/making-a-medu-vada_g.jpg"
            ),
            CuisineTypeItem(
                name = "Paratha",
                imageUrl = "https://www.vidhyashomecooking.com/wp-content/uploads/2020/08/AlooParathaRecipe-500x500.jpg"
            ),
            CuisineTypeItem(
                name = "Tea",
                imageUrl = "https://florel-en-provence.fr/img/cms/vert.jpg"
            ),
            CuisineTypeItem(
                name = "Coffee",
                imageUrl = "https://www.pngfind.com/pngs/m/59-596246_cup-of-coffee-top-view-png-transparent-png.png"
            ),
            CuisineTypeItem(
                name = "Upma",
                imageUrl = "https://thumbs.dreamstime.com/b/upma-rava-made-samolina-most-famous-south-indian-breakfast-item-which-beautifully-arranged-plate-banana-leaf-216111514.jpg"
            ),
            CuisineTypeItem(
                name = "Shawarma",
                imageUrl = "https://just-eat-prod-sg-res.cloudinary.com/image/upload/c_fill,f_auto,q_auto,w_1200,h_630,d_au:cuisines:kebab-1.jpg/v1/au/restaurants/11050161.jpg"
            ),
            CuisineTypeItem(
                name = "Shakes",
                imageUrl = "https://previews.123rf.com/images/derkien/derkien1511/derkien151100023/48556164-delicious-milk-shake-raspberry-smoothie-top-view-close-up.jpg"
            ),
            CuisineTypeItem(
                name = "Pancake",
                imageUrl = "https://img.freepik.com/free-photo/top-view-yummy-pancakes-with-fruits-honey-light_140725-120949.jpg?w=500"
            ),
            CuisineTypeItem(
                name = "Ice Cream",
                imageUrl = "https://previews.123rf.com/images/baibaz/baibaz1702/baibaz170200063/72491555-bowl-of-various-colorful-ice-cream-and-chocolate-sauce-isolated-on-white-background-from-top-view.jpg"
            ),
            CuisineTypeItem(
                name = "Khichdi",
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR3DZQChcSSyEXJW5P4PQvgL3HGCjwNhO1Ejw&usqp=CAU"
            ),
            CuisineTypeItem(
                name = "Rolls",
                imageUrl = "https://thumbs.dreamstime.com/b/vegetable-indian-rolls-filled-tasty-concoction-car-carrots-potatoes-pepper-peas-cooked-blend-spices-vertical-110010966.jpg"
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

fun getTopRatedRestaurantState(): TopRatedRestaurantState {
    return TopRatedRestaurantState(
        header = "Top rated near you",
        restaurants = getRestaurants().toList()
    )
}

fun getRestaurantState(): RestaurantState {
    return RestaurantState(
        header = "140 restaurants to explore",
        restaurants = getRestaurants().toList()
    )
}

fun getRestaurants(): List<RestaurantItem> {
    return listOf(
        RestaurantItem(
            name = "McDonald's",
            description = "Burgers, Beverages",
            imageUrl = "https://b.zmtcdn.com/data/pictures/chains/1/171/56b717a2094bcb7b5704be31d4108df6_featured_v2.jpg",
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
            name = "Trupti Sweets and Farsan",
            description = "Sweets, Desserts",
            imageUrl = "https://im.whatshot.in/content/2015/Aug/1439797986-sweet-shops.jpg",
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
            name = "Subway",
            description = "Salads, Snacks",
            imageUrl = "https://content.jdmagicbox.com/comp/def_content/subway/subway-4-subway-4-yotrh.jpg",
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
            name = "Jeden - the Cake Expert",
            description = "Desserts, Bakery",
            imageUrl = "https://cdn.pickuplimes.com/cache/e8/d2/e8d2767ce7ba58f8bf0ffb62b17415c8.jpg",
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
            name = "Babu Vada Pav",
            description = "Desserts, Bakery",
            imageUrl = "https://www.cookwithmanali.com/wp-content/uploads/2018/04/Vada-Pav-500x500.jpg",
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
            name = "Apsara Ice Creams",
            description = "Ice Cream, Desserts",
            imageUrl = "https://www.carveyourcraving.com/wp-content/uploads/2021/06/chocolate-icecream-in-an-icecream-maker.jpg",
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
            name = "Persia Darbar",
            description = "Mughlai, North Indian",
            imageUrl = "https://www.recipetineats.com/wp-content/uploads/2018/08/Chicken-Biryani_1-1.jpg",
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