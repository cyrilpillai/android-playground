package com.cyrilpillai.androidplayground.food_delivery.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.food_delivery.state.getLocationBarState
import com.cyrilpillai.androidplayground.food_delivery.state.getSearchBarState

@Composable
fun TopBarSection(
    locationBarState: LocationBarState,
    searchBarState: SearchBarState,
    modifier: Modifier = Modifier,
    onLocationClick: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        LocationBar(
            state = locationBarState,
            onClick = onLocationClick
        )

        SearchBar(
            state = searchBarState,
            modifier = Modifier
                .padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TopBarSectionPreview() {
    TopBarSection(
        locationBarState = getLocationBarState(),
        searchBarState = getSearchBarState(),
        modifier = Modifier
            .padding(16.dp)
    ) {}
}