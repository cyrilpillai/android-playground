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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.food_delivery.FoodDeliveryActivity
import com.cyrilpillai.androidplayground.messaging.MessagingActivity
import com.cyrilpillai.androidplayground.payments.PaymentActivity
import com.cyrilpillai.androidplayground.social_media.SocialMediaActivity
import com.cyrilpillai.androidplayground.video_streaming.VideoStreamingActivity
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPlaygroundTheme {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Button(
                        onClick = {
                            startActivity(
                                Intent(
                                    this@MainActivity,
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
                            startActivity(
                                Intent(
                                    this@MainActivity,
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
                            startActivity(
                                Intent(
                                    this@MainActivity,
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
                            startActivity(
                                Intent(
                                    this@MainActivity,
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
                            startActivity(
                                Intent(
                                    this@MainActivity,
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
        }
    }
}