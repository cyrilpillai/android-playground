package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.video_streaming.model.NewAndHotItem
import com.cyrilpillai.androidplayground.video_streaming.state.getNewAndHotContentState

@Composable
fun NewAndHotContentSection(
    newAndHotItem: NewAndHotItem,
    onVolumeToggleClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(bottom = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .height(180.dp)
        ) {
            Surface(
                shape = RoundedCornerShape(6.dp),
                color = newAndHotItem.backgroundColor,
                modifier = Modifier
                    .fillMaxSize()
            ) {}
            Text(
                text = newAndHotItem.contentType,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .background(
                        color = Color.Black,
                        shape = RoundedCornerShape(2.dp)
                    )
                    .padding(horizontal = 6.dp)
                    .align(Alignment.TopEnd)
            )

            val volumeIcon = if (newAndHotItem.volumeOn) {
                R.drawable.ic_volume_off
            } else {
                R.drawable.ic_volume_on
            }
            Icon(
                painter = painterResource(id = volumeIcon),
                tint = Color.White,
                contentDescription = "fast laugh mute toggle",
                modifier = Modifier
                    .padding(8.dp)
                    .background(
                        color = Color.Black,
                        shape = CircleShape
                    )
                    .padding(4.dp)
                    .size(14.dp)
                    .align(Alignment.BottomEnd)
                    .clickable { onVolumeToggleClick() }
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(70.dp)
        ) {
            AsyncImage(
                model = newAndHotItem.logoUrl,
                contentDescription = "fast laugh video logo",
                modifier = Modifier
                    .padding(start = 16.dp)
                    .aspectRatio(1.5f)
            )
            Box(modifier = Modifier.weight(1f))
            ImageButtonSection(
                icon = R.drawable.ic_send,
                text = "Share",
                rotateAngle = -45f,
                iconPadding = 4.dp,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
            ImageButtonSection(
                icon = R.drawable.ic_add,
                text = "My List",
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            )
            ImageButtonSection(
                icon = R.drawable.ic_play_arrow,
                text = "Play",
                modifier = Modifier
                    .padding(end = 16.dp)
            )
        }

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
        ) {
            newAndHotItem.subtitle?.let {
                Text(
                    text = it,
                    fontSize = 12.sp,
                    color = Color.White,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )
            }
            Text(
                text = newAndHotItem.name,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(top = 4.dp)
            )
            Text(
                text = newAndHotItem.description,
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 6,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(top = 4.dp)
            )
        }
    }
}

@Composable
private fun ImageButtonSection(
    @DrawableRes icon: Int,
    text: String,
    modifier: Modifier = Modifier,
    iconPadding: Dp = 0.dp,
    rotateAngle: Float = 0f,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = icon),
            tint = Color.White,
            contentDescription = text,
            modifier = Modifier
                .size(24.dp)
                .padding(iconPadding)
                .rotate(rotateAngle)
        )
        Text(
            text = text,
            fontSize = 12.sp,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun NewAndHotContentSectionPreview() {
    NewAndHotContentSection(
        newAndHotItem = getNewAndHotContentState().newAndHotList[0],
        onVolumeToggleClick = {},
        modifier = Modifier
            .background(Color.Black)
    )
}