package com.cyrilpillai.androidplayground.social_media.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.social_media.model.TabItem
import com.cyrilpillai.androidplayground.social_media.state.getTabsState

data class TabsState(
    val tabs: List<TabItem>
)

@Composable
fun TabsSection(
    state: TabsState,
    modifier: Modifier = Modifier,
    onClick: (position: Int) -> Unit
) {
    val selectedPosition = state.tabs.first { it.isSelected }.position
    TabRow(
        selectedTabIndex = selectedPosition,
        backgroundColor = Color.Black,
        contentColor = Color.White,
        modifier = modifier
            .fillMaxWidth()
    ) {
        state.tabs.forEach { tabItem ->
            Tab(
                selected = tabItem.isSelected,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.Gray,
                onClick = { onClick(tabItem.position) }
            ) {
                Icon(
                    painter = painterResource(
                        id = tabItem.icon
                    ),
                    contentDescription = tabItem.contentDescription,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TabsSectionPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        TabsSection(
            state = getTabsState(),
            modifier = Modifier
                .padding(vertical = 16.dp)
        ) {}
    }
}