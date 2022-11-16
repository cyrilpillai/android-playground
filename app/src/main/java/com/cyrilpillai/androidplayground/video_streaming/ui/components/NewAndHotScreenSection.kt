package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.video_streaming.model.BottomNavItem
import com.cyrilpillai.androidplayground.video_streaming.model.NewAndHotItem
import com.cyrilpillai.androidplayground.video_streaming.model.NewAndHotType
import com.cyrilpillai.androidplayground.video_streaming.state.getNewAndHotContentState

data class NewAndHotState(
    val newAndHotList: List<NewAndHotItem>
)

@Composable
fun NewAndHotScreenSection(
    state: NewAndHotState,
    onVolumeToggleClick: (newAndHotItem: NewAndHotItem) -> Unit,
    modifier: Modifier = Modifier
) {
    val topBarState by remember {
        mutableStateOf(
            TopBarState(
                title = BottomNavItem.NewAndHot.title, showIcons = true
            )
        )
    }
    val listState = rememberLazyListState()
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TopBarSection(
            state = topBarState, modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .padding(
                    horizontal = 16.dp,
                    vertical = 8.dp
                )
        )

        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {
                HeaderSection(
                    title = "Coming Soon",
                    icon = R.drawable.ic_popcorn
                )
            }

            items(state.newAndHotList.filter {
                it.type == NewAndHotType.COMING_SOON
            }) {
                NewAndHotContentSection(newAndHotItem = it,
                    onVolumeToggleClick = { onVolumeToggleClick(it) })
            }

            item {
                HeaderSection(
                    title = "Everyone's Watching",
                    icon = R.drawable.ic_fire
                )
            }

            items(state.newAndHotList.filter {
                it.type == NewAndHotType.EVERYONE_WATCHING
            }) {
                NewAndHotContentSection(newAndHotItem = it,
                    onVolumeToggleClick = { onVolumeToggleClick(it) }
                )
            }

            item {
                HeaderSection(
                    title = "Top 10 TV Shows",
                    icon = R.drawable.ic_top_ten
                )
            }

            items(state.newAndHotList.filter {
                it.type == NewAndHotType.TOP_10_TV_SHOWS
            }) {
                NewAndHotContentSection(newAndHotItem = it,
                    onVolumeToggleClick = { onVolumeToggleClick(it) }
                )
            }

            item {
                HeaderSection(
                    title = "Top 10 Movies",
                    icon = R.drawable.ic_top_ten
                )
            }

            items(state.newAndHotList.filter {
                it.type == NewAndHotType.TOP_10_MOVIES
            }) {
                NewAndHotContentSection(newAndHotItem = it,
                    onVolumeToggleClick = { onVolumeToggleClick(it) })
            }
        }
    }
}

@Composable
private fun HeaderSection(
    title: String,
    @DrawableRes icon: Int,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
    ) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = "new and hot header icon",
            modifier = Modifier
                .size(20.dp)
        )
        Text(
            text = title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(horizontal = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NewAndHotScreenSectionPreview() {
    NewAndHotScreenSection(
        state = getNewAndHotContentState(),
        onVolumeToggleClick = {},
        modifier = Modifier.background(Color.Black)
    )
}