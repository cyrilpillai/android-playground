package com.cyrilpillai.androidplayground.payments.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.payments.model.SearchBarItem

@Composable
fun SearchBarSection(
    searchBarItem: SearchBarItem,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Card(
            shape = RoundedCornerShape(24.dp),
            elevation = 8.dp,
            modifier = Modifier
                .weight(1f)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Icon(
                    painter = painterResource(
                        id = searchBarItem.icon
                    ),
                    contentDescription = "search",
                    modifier = Modifier
                        .size(18.dp)
                )
                Text(
                    text = searchBarItem.hint,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(start = 8.dp)
                )
            }
        }

        AsyncImage(
            model = searchBarItem.profileImageUrl,
            contentDescription = "profile icon",
            modifier = Modifier
                .padding(start = 12.dp)
                .size(28.dp)
                .clip(CircleShape)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchBarSectionPreview() {
    SearchBarSection(
        SearchBarItem(
            hint = "Pay by name or phone",
            icon = R.drawable.ic_search_outline,
            profileImageUrl = "",
        )
    )
}