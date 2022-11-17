package com.cyrilpillai.androidplayground

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.food_delivery.FoodDeliveryActivity
import com.cyrilpillai.androidplayground.messaging.MessagingActivity
import com.cyrilpillai.androidplayground.payments.PaymentActivity
import com.cyrilpillai.androidplayground.social_media.SocialMediaActivity
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme
import com.cyrilpillai.androidplayground.video_streaming.VideoStreamingActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPlaygroundTheme {
                MainScreen(this)
            }
        }
    }

    @Composable
    private fun MainScreen(activity: MainActivity) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Button(
                onClick = {
                    activity.startActivity(
                        Intent(
                            activity,
                            FoodDeliveryActivity::class.java
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Food Delivery")
            }

            Button(
                onClick = {
                    activity.startActivity(
                        Intent(
                            activity,
                            SocialMediaActivity::class.java
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Social Media")
            }

            Button(
                onClick = {
                    activity.startActivity(
                        Intent(
                            activity,
                            MessagingActivity::class.java
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Messaging")
            }
            Button(
                onClick = {
                    activity.startActivity(
                        Intent(
                            activity,
                            PaymentActivity::class.java
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Payments")
            }
            Button(
                onClick = {
                    activity.startActivity(
                        Intent(
                            activity,
                            VideoStreamingActivity::class.java
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Video Streaming")
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun MainScreenPreview() {
        MainScreen(MainActivity())
    }

}