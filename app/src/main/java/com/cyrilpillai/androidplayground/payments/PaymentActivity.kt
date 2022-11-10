package com.cyrilpillai.androidplayground.payments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.payments.state.getActionState
import com.cyrilpillai.androidplayground.payments.state.getBusinessState
import com.cyrilpillai.androidplayground.payments.state.getPeopleState
import com.cyrilpillai.androidplayground.payments.state.getTopBarState
import com.cyrilpillai.androidplayground.payments.state.getUpiIdState
import com.cyrilpillai.androidplayground.payments.ui.components.ActionItemSection
import com.cyrilpillai.androidplayground.payments.ui.components.CircularItemSection
import com.cyrilpillai.androidplayground.payments.ui.components.HeaderTextSection
import com.cyrilpillai.androidplayground.payments.ui.components.TopBarSection
import com.cyrilpillai.androidplayground.payments.ui.components.UpiIdSection
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme
import com.cyrilpillai.androidplayground.ui.theme.BlueBackdrop

class PaymentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val topBarState by remember { mutableStateOf(getTopBarState()) }
            val actionState by remember { mutableStateOf(getActionState()) }
            val upiIdState by remember { mutableStateOf(getUpiIdState()) }
            val peopleState by remember { mutableStateOf(getPeopleState()) }
            val businessState by remember { mutableStateOf(getBusinessState()) }

            AndroidPlaygroundTheme(statusBarColor = BlueBackdrop) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                        TopBarSection(state = topBarState)
                    }

                    items(
                        items = actionState.actions,
                    ) {
                        ActionItemSection(
                            actionItem = it,
                            modifier = Modifier
                                .padding(top = 18.dp)
                        )
                    }

                    item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                        UpiIdSection(
                            state = upiIdState,
                            modifier = Modifier
                                .padding(16.dp)
                        )
                    }

                    item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                        HeaderTextSection(
                            text = "People",
                            modifier = Modifier
                                .padding(
                                    start = 24.dp,
                                    end = 24.dp,
                                    bottom = 8.dp
                                )
                        )
                    }

                    items(
                        items = peopleState.circularItems,
                    ) {
                        CircularItemSection(
                            circularItem = it,
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )
                    }

                    item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                        HeaderTextSection(
                            text = "Businesses",
                            modifier = Modifier
                                .padding(
                                    horizontal = 24.dp,
                                    vertical = 16.dp
                                )
                        )
                    }

                    items(
                        items = businessState.circularItems,
                    ) {
                        CircularItemSection(
                            circularItem = it,
                            modifier = Modifier
                                .padding(top = 8.dp)
                        )
                    }
                }
            }
        }
    }
}