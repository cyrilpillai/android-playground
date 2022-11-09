package com.cyrilpillai.androidplayground.messaging.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
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
import com.cyrilpillai.androidplayground.messaging.model.CallItem
import com.cyrilpillai.androidplayground.messaging.model.CallLinkItem
import com.cyrilpillai.androidplayground.messaging.model.CallMode
import com.cyrilpillai.androidplayground.messaging.model.CallStatus
import com.cyrilpillai.androidplayground.messaging.model.CallType
import com.cyrilpillai.androidplayground.messaging.state.getCallState
import com.cyrilpillai.androidplayground.ui.theme.Green700
import com.cyrilpillai.androidplayground.ui.theme.Teal600

data class CallState(
    val linkItem: CallLinkItem,
    val headerText: String,
    val calls: List<CallItem>
)

@Composable
fun CallSection(
    state: CallState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(top = 16.dp),
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        item {
            CallLinkSection(state.linkItem)
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
        items(state.calls) {
            CallItemSection(it)
        }
    }
}

@Composable
fun CallLinkSection(callLinkItem: CallLinkItem) {
    Row {
        Surface(
            shape = CircleShape,
            color = Teal600,
            modifier = Modifier
                .size(45.dp)
        ) {
            Icon(
                painter = painterResource(
                    id = callLinkItem.icon
                ),
                contentDescription = "call link icon",
                tint = Color.White,
                modifier = Modifier
                    .padding(12.dp)
                    .rotate(120f)
            )
        }
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = callLinkItem.title,
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp
            )
            Text(
                text = callLinkItem.description,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun CallItemSection(
    callItem: CallItem,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = callItem.imageUrl,
            contentDescription = "chat profile icon",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(45.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = callItem.name,
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(
                        id = when (callItem.type) {
                            CallType.INCOMING -> R.drawable.ic_incoming_call
                            CallType.OUTGOING -> R.drawable.ic_outgoing_call
                        }
                    ),
                    contentDescription = "call type",
                    tint = when (callItem.status) {
                        CallStatus.MISSED -> Color.Red
                        CallStatus.PICKED -> Green700
                    },
                    modifier = Modifier
                        .size(14.dp)
                )
                Text(
                    text = callItem.timestamp,
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                )
            }
        }
        Icon(
            painter = painterResource(
                id = when (callItem.mode) {
                    CallMode.VOICE -> R.drawable.ic_call
                    CallMode.VIDEO -> R.drawable.ic_video_cam
                }
            ),
            contentDescription = "call mode",
            tint = Teal600,
            modifier = Modifier
                .size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CallSectionPreview() {
    CallSection(state = getCallState())
}