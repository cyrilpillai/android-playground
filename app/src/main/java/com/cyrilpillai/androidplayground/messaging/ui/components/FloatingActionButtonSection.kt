package com.cyrilpillai.androidplayground.messaging.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.messaging.state.getFloatingActionButtonState
import com.cyrilpillai.androidplayground.ui.theme.Grey200
import com.cyrilpillai.androidplayground.ui.theme.Grey900
import com.cyrilpillai.androidplayground.ui.theme.Teal600

data class FloatingActionButtonState(
    @DrawableRes val smallFabIcon: Int? = null,
    @DrawableRes val bigFabIcon: Int? = null
)

@Composable
fun FloatingActionButtonSection(
    state: FloatingActionButtonState,
    modifier: Modifier = Modifier,
    onSmallFabClick: () -> Unit,
    onBigFabClick: () -> Unit
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        state.smallFabIcon?.let {
            FloatingActionButton(
                backgroundColor = Grey200,
                onClick = onSmallFabClick,
                modifier = modifier
                    .size(40.dp)
            ) {
                Icon(
                    painter = painterResource(id = it),
                    tint = Color.DarkGray,
                    contentDescription = "floating action button",
                    modifier = Modifier
                )
            }
        }
        state.bigFabIcon?.let {
            FloatingActionButton(
                backgroundColor = Teal600,
                onClick = onBigFabClick,
                modifier = modifier
                    .padding(top = 12.dp)
                    .size(50.dp)
            ) {
                Icon(
                    painter = painterResource(id = it),
                    tint = Color.White,
                    contentDescription = "floating action button",
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FloatingActionButtonSectionPreview() {
    FloatingActionButtonSection(
        state = getFloatingActionButtonState(2),
        onSmallFabClick = {},
        onBigFabClick = {}
    )
}