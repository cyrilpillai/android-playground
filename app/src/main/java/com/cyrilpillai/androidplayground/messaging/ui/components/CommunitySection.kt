package com.cyrilpillai.androidplayground.messaging.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.ui.theme.Teal600

@Composable
fun CommunitySection() {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_community_illustration),
            contentDescription = "community image",
            modifier = Modifier
                .size(250.dp)
        )
        Text(
            text = "Introducing Communities",
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            color = Color.Black,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Easily organise your related groups and send announcements. Now, your communities, like neighborhoods or schools, can have their own space.",
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(
                    top = 10.dp,
                    bottom = 16.dp
                )
        )
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Teal600)
        ) {
            Text(
                text = "START YOUR COMMUNITY",
                color = Color.White,
                modifier = Modifier
                    .padding(horizontal = 28.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CommunitySectionPreview() {
    CommunitySection()
}