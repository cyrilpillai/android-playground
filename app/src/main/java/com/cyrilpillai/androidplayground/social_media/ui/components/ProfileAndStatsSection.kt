package com.cyrilpillai.androidplayground.social_media.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.social_media.state.getProfileImageState
import com.cyrilpillai.androidplayground.social_media.state.getStatisticsState

@Composable
fun ProfileAndStatsSection(
    profileImageState: ProfileImageState,
    statisticsState: StatisticsState,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        ProfileImageSection(
            state = profileImageState,
            modifier = Modifier
                .padding(end = 16.dp)
        )
        StatisticsSection(
            state = statisticsState,
            modifier = Modifier
                .padding(horizontal = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileAndStatsSection() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        ProfileAndStatsSection(
            profileImageState = getProfileImageState(),
            statisticsState = getStatisticsState()
        )
    }
}