package com.cyrilpillai.androidplayground.food_delivery.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.food_delivery.model.FilterItem
import com.cyrilpillai.androidplayground.food_delivery.state.getFilterState

data class FilterState(
    val filters: List<FilterItem>
)

@Composable
fun FilterSection(
    state: FilterState,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .wrapContentSize()
    ) {
        items(state.filters) {
            FilterItemSection(filterItem = it)
        }
    }
}

@Composable
private fun FilterItemSection(filterItem: FilterItem) {
    Card(
        border = BorderStroke(Dp.Hairline, Color.LightGray),
        shape = RoundedCornerShape(24.dp),
        elevation = 0.dp,
        modifier = Modifier
            .wrapContentSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(vertical = 6.dp, horizontal = 10.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = filterItem.title,
                fontSize = 12.sp,
                color = Color.DarkGray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(
                        end = if (filterItem.icon != null) 8.dp else 0.dp
                    )
            )

            if (filterItem.icon != null) {
                Icon(
                    painter = painterResource(
                        id = filterItem.icon
                    ),
                    contentDescription = "filter icon",
                    modifier = Modifier
                        .size(18.dp)
                )
            } else {
                Box(modifier = Modifier.height(18.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FilterSectionPreview() {
    FilterSection(
        state = getFilterState(),
        modifier = Modifier
            .padding(
                top = 24.dp,
            )
    )
}