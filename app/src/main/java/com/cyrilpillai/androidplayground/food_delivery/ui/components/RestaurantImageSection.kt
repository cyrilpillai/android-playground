package com.cyrilpillai.androidplayground.food_delivery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cyrilpillai.androidplayground.R

@Composable
fun RestaurantImageSection(
    imageUrl: String,
    isFavorite: Boolean,
    dealTitle: String?,
    dealSubTitle: String?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "restaurant image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.DarkGray,
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    contentAlignment = Alignment.TopEnd,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    val drawable = if (isFavorite) {
                        R.drawable.ic_favorite_selected
                    } else {
                        R.drawable.ic_favorite_unselected
                    }
                    Icon(
                        painter = painterResource(id = drawable),
                        contentDescription = "favorite",
                        tint = Color.White,
                        modifier = Modifier
                            .clickable(onClick = onClick)
                    )
                }

                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(8.dp)
                ) {
                    dealTitle?.let {
                        Text(
                            text = it,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                        )
                    }
                    dealSubTitle?.let {
                        Text(
                            text = it,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.LightGray,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RestaurantImageSectionPreview() {
    RestaurantImageSection(
        imageUrl = "",
        isFavorite = true,
        dealTitle = "20% OFF",
        dealSubTitle = "UPTO ₹150",
        onClick = {},
        modifier = Modifier
            .width(140.dp)
            .height(180.dp)
    )
}