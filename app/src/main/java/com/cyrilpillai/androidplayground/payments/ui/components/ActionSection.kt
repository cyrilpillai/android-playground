package com.cyrilpillai.androidplayground.payments.ui.components

import androidx.compose.foundation.layout.Column
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
import com.cyrilpillai.androidplayground.payments.model.ActionItem
import com.cyrilpillai.androidplayground.payments.state.getActionState

data class ActionState(
    val actions: List<ActionItem>,
)


@Composable
fun ActionItemSection(
    actionItem: ActionItem,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = actionItem.icon),
            contentDescription = "action icon",
            tint = Color.DarkGray,
            modifier = Modifier
                .size(24.dp)
        )
        Text(
            text = actionItem.description,
            fontSize = 10.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ActionItemSectionPreview() {
    ActionItemSection(
        actionItem = getActionState().actions[0]
    )
}