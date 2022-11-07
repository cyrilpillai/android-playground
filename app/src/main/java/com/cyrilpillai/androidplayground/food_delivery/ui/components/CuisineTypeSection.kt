package com.cyrilpillai.androidplayground.food_delivery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cyrilpillai.androidplayground.food_delivery.model.CuisineTypeItem
import com.cyrilpillai.androidplayground.food_delivery.state.getCuisineTypeState

data class CuisineTypeState(
    val header: String,
    val cuisines: List<CuisineTypeItem>
)

@Composable
fun CuisineTypeSection(
    state: CuisineTypeState,
    modifier: Modifier = Modifier,
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
                .padding(
                    vertical = 16.dp,
                    horizontal = 16.dp
                )
        )

        LazyHorizontalGrid(
            rows = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = modifier
                .fillMaxWidth()
                .height(150.dp)
        ) {
            items(state.cuisines) {
                CuisineTypeItemSection(cuisineTypeItem = it)
            }
        }
    }
}

@Composable
private fun CuisineTypeItemSection(cuisineTypeItem: CuisineTypeItem) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .width(80.dp)
    ) {
        AsyncImage(
            model = cuisineTypeItem.imageUrl,
            contentDescription = "cuisine type icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Text(
            text = cuisineTypeItem.name,
            fontSize = 10.sp,
            color = Color.DarkGray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CuisineTypeSectionPreview() {
    CuisineTypeSection(
        state = getCuisineTypeState(),
        modifier = Modifier
            .padding(top = 10.dp)
    )
}