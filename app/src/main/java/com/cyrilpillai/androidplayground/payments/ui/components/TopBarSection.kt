package com.cyrilpillai.androidplayground.payments.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.payments.model.SearchBarItem
import com.cyrilpillai.androidplayground.payments.state.getTopBarState

data class TopBarState(
    @DrawableRes val backdrop: Int,
    val searchBarItem: SearchBarItem,
)

@Composable
fun TopBarSection(
    state: TopBarState,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = state.backdrop),
            contentDescription = "backdrop image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            SearchBarSection(searchBarItem = state.searchBarItem)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TopBarSectionPreview() {
    TopBarSection(
        state = getTopBarState()
    )
}