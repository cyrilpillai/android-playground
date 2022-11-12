package com.cyrilpillai.androidplayground.video_streaming.ui.components

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
import com.cyrilpillai.androidplayground.video_streaming.model.BottomNavItem
import com.cyrilpillai.androidplayground.video_streaming.state.getBottomBarState

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
        backgroundColor = Color.Black,
        modifier = modifier
    ) {
        state.items.forEach {
            val iconId = if (it.isSelected) it.selectedIcon else it.unselectedIcon
            BottomNavigationItem(
                selected = it.isSelected,
                icon = {
                    Icon(
                        painter = painterResource(id = iconId),
                        contentDescription = "bottom navigation icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(20.dp)
                    )
                },
                label = {
                    Text(
                        text = it.label,
                        fontSize = 8.sp,
                        color = Color.White
                    )
                },
                alwaysShowLabel = true,
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