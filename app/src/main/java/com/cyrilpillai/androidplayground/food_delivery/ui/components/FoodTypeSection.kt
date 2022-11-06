package com.cyrilpillai.androidplayground.food_delivery.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
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
import com.cyrilpillai.androidplayground.food_delivery.model.FoodTypeItem
import com.cyrilpillai.androidplayground.food_delivery.state.getFoodTypeState
import com.cyrilpillai.androidplayground.ui.theme.Grey200

data class FoodTypeState(
    val firstFoodType: FoodTypeItem,
    val secondFoodType: FoodTypeItem,
    val thirdFoodType: FoodTypeItem,
)

@Composable
fun FoodTypeSection(
    state: FoodTypeState,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp)
    ) {
        FoodTypeItemSection(foodTypeItem = state.firstFoodType)
        FoodTypeItemSection(foodTypeItem = state.secondFoodType)
        FoodTypeItemSection(foodTypeItem = state.thirdFoodType)
    }
}

@Composable
private fun FoodTypeItemSection(foodTypeItem: FoodTypeItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            color = Grey200,
            modifier = Modifier
                .width(100.dp)
                .height(60.dp)
        ) {
            Image(
                painter = painterResource(
                    id = foodTypeItem.icon
                ),
                contentDescription = "food type icon",
                modifier = Modifier
                    .padding(12.dp)
                    .size(60.dp)
            )
        }
        Text(
            text = foodTypeItem.title,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            color = Color.DarkGray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(top = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun FoodTypeSectionPreview() {
    FoodTypeSection(state = getFoodTypeState())
}