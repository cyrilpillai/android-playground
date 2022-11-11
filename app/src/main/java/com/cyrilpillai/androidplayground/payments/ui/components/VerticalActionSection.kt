package com.cyrilpillai.androidplayground.payments.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.payments.model.ActionItem
import com.cyrilpillai.androidplayground.payments.state.getVerticalActionState
import com.cyrilpillai.androidplayground.ui.theme.Blue800
import com.cyrilpillai.androidplayground.ui.theme.Grey800

data class VerticalActionState(
    val actions: List<ActionItem>,
)


@Composable
fun VerticalActionItemSection(
    actionItem: ActionItem,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = actionItem.icon),
            contentDescription = "action icon",
            tint = Blue800,
            modifier = Modifier
                .size(20.dp)
        )
        Text(
            text = actionItem.description,
            fontSize = 16.sp,
            color = Grey800,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_keyboard_arrow_right),
            contentDescription = "action arrow",
            tint = Color.DarkGray,
            modifier = Modifier
                .size(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VerticalActionItemSectionPreview() {
    VerticalActionItemSection(
        actionItem = getVerticalActionState().actions[0],
        modifier = Modifier
            .padding(16.dp)
    )
}