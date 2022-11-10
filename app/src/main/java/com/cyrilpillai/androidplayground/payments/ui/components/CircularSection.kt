package com.cyrilpillai.androidplayground.payments.ui.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cyrilpillai.androidplayground.payments.model.CircularItem
import com.cyrilpillai.androidplayground.payments.state.getPeopleState
import com.cyrilpillai.androidplayground.ui.theme.Grey100

val CIRCLE_SIZE = 45.dp

data class CircularState(
    val circularItems: List<CircularItem>,
)

@Composable
fun CircularItemSection(
    circularItem: CircularItem,
    modifier: Modifier = Modifier
) {
    when (circularItem) {
        is CircularItem.Info -> CircularInfoItemSection(circularItem, modifier)
        is CircularItem.Toggle -> CircularToggleItemSection(circularItem, modifier)
    }
}

@Composable
private fun CircularInfoItemSection(
    circularInfoItem: CircularItem.Info,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        if (circularInfoItem.imageUrl != null) {

            AsyncImage(
                model = circularInfoItem.imageUrl,
                contentDescription = "circular info icon",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(CIRCLE_SIZE)
                    .clip(CircleShape)
            )
        } else {
            Surface(
                color = circularInfoItem.backgroundColor,
                shape = CircleShape,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .size(CIRCLE_SIZE)
            ) {
                Box {
                    Text(
                        text = circularInfoItem.description[0].toString(),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.White,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .align(Alignment.Center)

                    )
                }
            }

        }
        Text(
            text = circularInfoItem.description,
            fontSize = 12.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(top = 4.dp)
        )
    }
}

@Composable
private fun CircularToggleItemSection(
    circularToggleItem: CircularItem.Toggle,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Surface(
            color = Grey100,
            border = BorderStroke(1.dp, Color.LightGray),
            shape = CircleShape,
            modifier = Modifier
                .padding(top = 4.dp)
                .size(CIRCLE_SIZE)
        ) {
            Icon(
                painter = painterResource(id = circularToggleItem.icon),
                contentDescription = "circular toggle icon",
                tint = Color.DarkGray,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
        Text(
            text = circularToggleItem.description,
            fontSize = 12.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CircularInfoItemPreview() {
    CircularItemSection(
        circularItem = getPeopleState().circularItems.first { it is CircularItem.Info },
        modifier = Modifier
            .padding(16.dp)
    )
}


@Preview(showBackground = true)
@Composable
private fun CircularToggleItemPreview() {
    CircularItemSection(
        circularItem = getPeopleState().circularItems.first { it is CircularItem.Toggle },
        modifier = Modifier
            .padding(16.dp)
    )
}