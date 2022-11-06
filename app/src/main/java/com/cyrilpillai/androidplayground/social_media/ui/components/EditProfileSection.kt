package com.cyrilpillai.androidplayground.social_media.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.social_media.state.getEditProfileState
import com.cyrilpillai.androidplayground.ui.theme.Grey900

data class EditProfileState(
    val cta: String
)

@Composable
fun EditProfileSection(
    state: EditProfileState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(50.dp)
            .padding(horizontal = 16.dp)
    ) {
        Row {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Grey900,
                modifier = Modifier
                    .weight(1.8f)
                    .fillMaxHeight()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = state.cta,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 12.dp,
                            vertical = 6.dp
                        )
                )
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = Grey900,
                modifier = Modifier
                    .weight(0.3f)
                    .fillMaxHeight()
                    .padding(
                        start = 8.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_person),
                    contentDescription = "add person",
                    tint = Color.White,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditProfileSection() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        EditProfileSection(state = getEditProfileState())
    }
}