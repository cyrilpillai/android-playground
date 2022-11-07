package com.cyrilpillai.androidplayground.food_delivery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.food_delivery.model.RestaurantItem
import com.cyrilpillai.androidplayground.food_delivery.state.getRestaurants
import com.cyrilpillai.androidplayground.ui.theme.Green700
import com.cyrilpillai.androidplayground.ui.theme.Grey100
import com.cyrilpillai.androidplayground.ui.theme.Grey50
import com.cyrilpillai.androidplayground.ui.theme.Orange900

data class VerticalRestaurantsState(
    val header: String,
    val restaurants: List<RestaurantItem>
)

@Composable
fun RestaurantItemSection(
    restaurantItem: RestaurantItem,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .height(130.dp)
    ) {
        RestaurantImageSection(
            imageUrl = restaurantItem.imageUrl,
            isFavorite = restaurantItem.isFavorite,
            dealTitle = restaurantItem.dealTitle,
            dealSubTitle = restaurantItem.dealSubTitle,
            onClick = onClick,
            modifier = Modifier
                .width(100.dp)
                .fillMaxHeight()
        )
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp)
        ) {

            Column(
                modifier = Modifier
                    .wrapContentSize()
            ) {
                Text(
                    text = restaurantItem.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(top = 8.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_stars),
                        contentDescription = "restaurant rating",
                        tint = Green700,
                        modifier = Modifier
                            .size(16.dp)
                    )
                    Text(
                        text = "${restaurantItem.rating} (${restaurantItem.reviewCount}) • ${restaurantItem.eta}",
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .padding(4.dp)
                    )
                }
                Text(
                    text = restaurantItem.description,
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray,
                    modifier = Modifier
                )
                Text(
                    text = "${restaurantItem.locality} • ${restaurantItem.distance}",
                    fontSize = 13.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.Gray,
                    modifier = Modifier
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color.Transparent,
                                Color.Transparent,
                                Grey50,
                                Grey100
                            )
                        ),
                        shape = RoundedCornerShape(32.dp)
                    )
                    .padding(
                        top = 4.dp,
                        bottom = 4.dp,
                        end = 16.dp,
                    )
            ) {
                Text(
                    text = restaurantItem.benefit,
                    fontSize = 12.sp,
                    maxLines = 1,
                    fontWeight = FontWeight.Bold,
                    overflow = TextOverflow.Ellipsis,
                    color = Orange900,
                )
                Image(
                    painter = painterResource(
                        id = R.drawable.ic_benefits_logo
                    ),
                    contentDescription = "one benefits logo",
                    modifier = Modifier
                        .size(32.dp)
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RestaurantItemSectionPreview() {
    RestaurantItemSection(
        restaurantItem = getRestaurants()[0],
        modifier = Modifier.padding(
            horizontal = 16.dp,
            vertical = 10.dp
        )
    ) {}
}