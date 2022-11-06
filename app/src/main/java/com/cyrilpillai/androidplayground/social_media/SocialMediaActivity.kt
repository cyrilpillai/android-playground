package com.cyrilpillai.androidplayground.social_media

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.social_media.state.getAccountBarState
import com.cyrilpillai.androidplayground.social_media.state.getBottomBarState
import com.cyrilpillai.androidplayground.social_media.state.getEditProfileState
import com.cyrilpillai.androidplayground.social_media.state.getProfileDetailsState
import com.cyrilpillai.androidplayground.social_media.state.getProfileImageState
import com.cyrilpillai.androidplayground.social_media.state.getStatisticsState
import com.cyrilpillai.androidplayground.social_media.ui.components.AccountBarSection
import com.cyrilpillai.androidplayground.social_media.ui.components.BottomBarSection
import com.cyrilpillai.androidplayground.social_media.ui.components.EditProfileSection
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileAndStatsSection
import com.cyrilpillai.androidplayground.social_media.ui.components.ProfileDetailsSection
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme

class SocialMediaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val accountBarState = getAccountBarState()
            val bottomBarState = getBottomBarState()
            val statisticsState = getStatisticsState()
            val profileImageState = getProfileImageState()
            val profileDetailsState = getProfileDetailsState()
            val editProfileState = getEditProfileState()

            AndroidPlaygroundTheme(
                statusBarColor = Color.Black,
                useDarkIcons = false
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize(),
                    backgroundColor = Color.Black,
                    topBar = {
                        AccountBarSection(state = accountBarState)
                    },
                    bottomBar = {
                        BottomBarSection(state = bottomBarState)
                    }) {
                    Column(
                        modifier = Modifier
                            .padding(it)
                    ) {
                        ProfileAndStatsSection(
                            profileImageState = profileImageState,
                            statisticsState = statisticsState
                        )
                        ProfileDetailsSection(
                            state = profileDetailsState
                        )
                        EditProfileSection(
                            state = editProfileState,
                        )
                    }
                }
            }
        }
    }
}