package com.cyrilpillai.androidplayground.food_delivery.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.food_delivery.model.BottomNavItem
import com.cyrilpillai.androidplayground.food_delivery.state.getBottomBarState

data class BottomBarState(
    val items: List<BottomNavItem>
)

@Composable
fun BottomBarSection(
    state: BottomBarState,
    modifier: Modifier = Modifier,
    onClick: (id: Int) -> Unit
) {
    BottomNavigation(
        backgroundColor = Color.White,
        modifier = modifier
    ) {
        state.items.forEach {
            val color = if (it.isSelected) Color.DarkGray else Color.Gray
            BottomNavigationItem(
                selected = it.isSelected,
                icon = {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = "bottom navigation icon",
                        tint = color,
                        modifier = Modifier
                            .size(if (it.isSelected) 25.dp else 20.dp)
                    )
                },
                label = {
                    Text(
                        text = it.label,
                        fontSize = 10.sp,
                        color = color
                    )
                },
                onClick = { onClick(it.id) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomBarSectionPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        BottomBarSection(state = getBottomBarState()) {}
    }
}