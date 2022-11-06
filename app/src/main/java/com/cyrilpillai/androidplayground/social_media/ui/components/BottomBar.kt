package com.cyrilpillai.androidplayground.social_media.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.social_media.model.BottomNavItem
import com.cyrilpillai.androidplayground.social_media.state.getAccountBarState
import com.cyrilpillai.androidplayground.social_media.state.getBottomBarState

data class BottomBarState(
    val items: List<BottomNavItem>
)

@Composable
fun BottomBarSection(
    state: BottomBarState,
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        backgroundColor = Color.Black,
        modifier = modifier
    ) {
        state.items.forEach {
            BottomNavigationItem(
                selected = it.isSelected,
                icon = {
                    val padding = if (it.label == "Reels") 2.dp else 0.dp
                    
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = "bottom navigation icon",
                        tint = Color.White,
                        modifier = Modifier
                            .size(26.dp)
                            .padding(padding)
                    )
                },
                label = { it.label },
                onClick = { },
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
        BottomBarSection(state = getBottomBarState())
    }
}