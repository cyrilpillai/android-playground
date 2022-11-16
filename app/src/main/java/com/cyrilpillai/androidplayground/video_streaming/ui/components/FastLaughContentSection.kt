package com.cyrilpillai.androidplayground.video_streaming.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
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
import com.cyrilpillai.androidplayground.video_streaming.model.FastLaughItem
import com.cyrilpillai.androidplayground.video_streaming.state.getFastLaughsState

@Composable
fun FastLaughContentSection(
    fastLaughItem: FastLaughItem,
    onVolumeToggleClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = fastLaughItem.backgroundColor,
        modifier = modifier
            .fillMaxSize()
    ) {
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = fastLaughItem.contentType,
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            modifier = Modifier
                .background(
                    color = Color.Black,
                    shape = RoundedCornerShape(2.dp)
                )
                .padding(horizontal = 6.dp)
                .align(Alignment.TopEnd)
        )
        val volumeIcon = if (fastLaughItem.volumeOn) {
            R.drawable.ic_volume_off
        } else {
            R.drawable.ic_volume_on
        }
        Icon(
            painter = painterResource(id = volumeIcon),
            tint = Color.White,
            contentDescription = "fast laugh mute toggle",
            modifier = Modifier
                .size(28.dp)
                .align(Alignment.BottomStart)
                .clickable { onVolumeToggleClick() }
        )

        AsyncImage(
            model = fastLaughItem.logoUrl,
            contentDescription = "fast laugh video logo",
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .align(Alignment.TopStart)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            AsyncImage(
                model = fastLaughItem.thumbnailUrl,
                contentDescription = "fast laugh thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(42.dp)
                    .border(
                        border = BorderStroke(Dp.Hairline, Color.White),
                        shape = CircleShape
                    )
                    .clip(CircleShape)
            )
            ImageButtonSection(
                icon = R.drawable.ic_smiley_filled,
                text = "LOL"
            )
            ImageButtonSection(
                icon = R.drawable.ic_add,
                text = "My List"
            )
            ImageButtonSection(
                icon = R.drawable.ic_send,
                text = "Share",
                iconSize = 24.dp,
                rotateAngle = -45f
            )
            ImageButtonSection(
                icon = R.drawable.ic_play_arrow,
                text = "Play",
                iconSize = 36.dp
            )
        }
    }
}

@Composable
private fun ImageButtonSection(
    @DrawableRes icon: Int,
    text: String,
    iconSize: Dp = 28.dp,
    rotateAngle: Float = 0f
) {
    Icon(
        painter = painterResource(id = icon),
        tint = Color.White,
        contentDescription = text,
        modifier = Modifier
            .padding(top = 16.dp)
            .size(iconSize)
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

@Preview(showBackground = true)
@Composable
private fun FastLaughContentSectionPreview() {
    FastLaughContentSection(
        fastLaughItem = getFastLaughsState().fastLaughs[0],
        onVolumeToggleClick = {}
    )
}