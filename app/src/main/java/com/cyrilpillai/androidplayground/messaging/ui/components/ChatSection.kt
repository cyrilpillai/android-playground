package com.cyrilpillai.androidplayground.messaging.ui.components

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cyrilpillai.androidplayground.messaging.model.ChatItem
import com.cyrilpillai.androidplayground.messaging.state.getChatState

data class ChatState(
    val chats: List<ChatItem>
)

@Composable
fun ChatSection(
    state: ChatState,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(top = 16.dp),
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        items(state.chats) {
            ChatItemSection(it)
        }
    }
}

@Composable
fun ChatItemSection(
    chatItem: ChatItem,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {
        AsyncImage(
            model = chatItem.imageUrl,
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
                text = chatItem.name,
                color = Color.DarkGray,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 16.sp
            )
            Text(
                text = chatItem.message,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontSize = 14.sp
            )
        }
        Text(
            text = chatItem.timestamp,
            color = Color.Gray,
            fontSize = 12.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ChatSectionPreview() {
    ChatSection(state = getChatState())
}