package com.cyrilpillai.androidplayground.messaging.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.messaging.model.CallMode
import com.cyrilpillai.androidplayground.messaging.model.CallStatus
import com.cyrilpillai.androidplayground.messaging.model.CallType
import com.cyrilpillai.androidplayground.messaging.model.MyStatusItem
import com.cyrilpillai.androidplayground.messaging.model.StatusItem
import com.cyrilpillai.androidplayground.messaging.state.getStatusState
import com.cyrilpillai.androidplayground.ui.theme.Green700
import com.cyrilpillai.androidplayground.ui.theme.Teal600

data class StatusState(
    val myStatusItem: MyStatusItem,
    val headerText: String,
    val statuses: List<StatusItem>
)

@Composable
fun StatusSection(
    state: StatusState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(top = 16.dp),
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        item {
            MyStatusSection(state.myStatusItem)
        }
        item {
            Text(
                text = state.headerText,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Gray,
                modifier = Modifier
                    .padding(vertical = 12.dp)
            )
        }
        items(state.statuses) {
            StatusItemSection(it)
        }
    }
}

@Composable
fun MyStatusSection(myStatusItem: MyStatusItem) {
    Row {
        Box(
            modifier = Modifier
        ) {
            AsyncImage(
                model = myStatusItem.imageUrl,
                contentDescription = "self profile icon",
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape)
            )
            Surface(
                border = BorderStroke(1.dp, Color.White),
                shape = CircleShape,
                color = Teal600,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(x = 4.dp, y = 2.dp)
                    .size(22.dp)
            ) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_add
                    ),
                    contentDescription = "add status icon",
                    tint = Color.White,
                    modifier = Modifier
                        .padding(2.dp)
                )
            }

        }
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = myStatusItem.title,
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp
            )
            Text(
                text = myStatusItem.description,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun StatusItemSection(
    statusItem: StatusItem,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(vertical = 8.dp)
            .height(48.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = statusItem.imageUrl,
            contentDescription = "chat profile icon",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .width(48.dp)
                .fillMaxHeight()
                .border(
                    border = BorderStroke((1.4).dp, Teal600),
                    shape = CircleShape
                )
                .padding(4.dp)
                .clip(CircleShape)
        )
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = statusItem.name,
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp
            )
            Text(
                text = statusItem.timestamp,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp,
                modifier = Modifier
                    .padding(horizontal = 4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StatusSectionPreview() {
    StatusSection(state = getStatusState())
}