package com.cyrilpillai.androidplayground.food_delivery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.food_delivery.model.RestaurantItem
import com.cyrilpillai.androidplayground.food_delivery.state.getTopRatedRestaurantState
import com.cyrilpillai.androidplayground.ui.theme.Green700

data class HorizontalRestaurantCarouselState(
    val header: String,
    val restaurants: List<RestaurantItem>
)

@Composable
fun HorizontalRestaurantCarouselSection(
    state: HorizontalRestaurantCarouselState,
    modifier: Modifier = Modifier,
    onClick: (id: Int) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = state.header,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier
                .padding(horizontal = 16.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(top = 16.dp)
                .wrapContentSize()
        ) {
            items(state.restaurants) {
                TopRatedRestaurantItemSection(restaurantItem = it) {
                    onClick(it.id)
                }
            }
        }
    }
}

@Composable
private fun TopRatedRestaurantItemSection(
    restaurantItem: RestaurantItem,
    onClick: () -> Unit
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .width(110.dp)
            .wrapContentHeight()
    ) {
        RestaurantImageSection(
            imageUrl = restaurantItem.imageUrl,
            isFavorite = restaurantItem.isFavorite,
            dealTitle = restaurantItem.dealTitle,
            dealSubTitle = restaurantItem.dealSubTitle,
            onClick = onClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(130.dp)
        )
        Text(
            text = restaurantItem.name,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(top = 8.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_stars),
                contentDescription = "restaurant rating",
                tint = Green700,
                modifier = Modifier
                    .size(14.dp)
            )
            Text(
                text = "${restaurantItem.rating} • ${restaurantItem.eta}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = Color.DarkGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HorizontalRestaurantCarouselSectionPreview() {
    HorizontalRestaurantCarouselSection(
        state = getTopRatedRestaurantState(),
        modifier = Modifier
            .padding(16.dp)
    ) {}
}