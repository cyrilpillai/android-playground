package com.cyrilpillai.androidplayground.social_media.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.social_media.model.PostItem
import com.cyrilpillai.androidplayground.social_media.model.PostType
import com.cyrilpillai.androidplayground.social_media.state.getPostsState

data class PostState(
    val posts: List<PostItem>
)

@Composable
fun PostItemSection(
    postItem: PostItem,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(130.dp)
            .padding(1.dp)
    ) {
        AsyncImage(
            model = postItem.imageUrl,
            contentDescription = "post image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        when (postItem.postType) {
            PostType.MULTIPLE_IMAGES -> R.drawable.ic_images
            PostType.VIDEO -> R.drawable.ic_video_filled
            else -> null
        }?.let {
            Icon(
                painter = painterResource(id = it),
                contentDescription = "post type",
                tint = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.TopEnd)
                    .size(18.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PostItemSectionPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        PostItemSection(postItem = getPostsState().posts[0])
    }
}