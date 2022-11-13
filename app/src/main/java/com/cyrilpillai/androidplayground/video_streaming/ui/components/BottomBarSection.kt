package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cyrilpillai.androidplayground.video_streaming.model.BottomNavItem

@Composable
fun BottomBarSection(
    navController: NavController
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.NewAndHot,
        BottomNavItem.FastLaughs,
        BottomNavItem.Downloads
    )
    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            val isSelected = currentRoute == item.screenRoute
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(
                            id = if (isSelected) item.selectedIcon else item.unselectedIcon
                        ),
                        contentDescription = item.title,
                        modifier = Modifier
                            .size(20.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = isSelected,
                onClick = {
                    navController.navigate(item.screenRoute) {

                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
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
        BottomBarSection(navController = rememberNavController())
    }
}