package com.cyrilpillai.androidplayground.messaging.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.messaging.state.getFloatingActionButtonState
import com.cyrilpillai.androidplayground.ui.theme.Teal600

data class FloatingActionButtonState(
    @DrawableRes val icon: Int? = null
)

@Composable
fun FloatingActionButtonSection(
    state: FloatingActionButtonState,
    modifier: Modifier = Modifier
) {
    state.icon?.let {
        FloatingActionButton(
            backgroundColor = Teal600,

            onClick = { /*TODO*/ },
            modifier = modifier
        ) {
            Icon(
                painter = painterResource(id = it),
                tint = Color.White,
                contentDescription = "floating action button",
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FloatingActionButtonSectionPreview() {
    FloatingActionButtonSection(
        state = getFloatingActionButtonState(1)
    )
}