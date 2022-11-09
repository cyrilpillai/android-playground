package com.cyrilpillai.androidplayground.payments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.cyrilpillai.androidplayground.payments.state.getTopBarState
import com.cyrilpillai.androidplayground.payments.ui.components.TopBarSection
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme
import com.cyrilpillai.androidplayground.ui.theme.BlueBackdrop

class PaymentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val topBarState by remember { mutableStateOf(getTopBarState()) }
            AndroidPlaygroundTheme(statusBarColor = BlueBackdrop) {
                LazyColumn {
                    item {
                        TopBarSection(state = topBarState)
                    }
                }
            }
        }
    }
}