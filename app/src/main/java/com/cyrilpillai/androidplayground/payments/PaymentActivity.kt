package com.cyrilpillai.androidplayground.payments

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.payments.state.getActionState
import com.cyrilpillai.androidplayground.payments.state.getTopBarState
import com.cyrilpillai.androidplayground.payments.state.getUpiIdState
import com.cyrilpillai.androidplayground.payments.ui.components.ActionItemSection
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

            AndroidPlaygroundTheme(statusBarColor = BlueBackdrop) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4)
                ) {
                    item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                        TopBarSection(state = topBarState)
                    }

                    itemsIndexed(
                        items = actionState.actions,
                    ) { index, actionItem ->
                        val endPadding = (if ((index + 1) % 4 == 0) 18 else 0).dp
                        ActionItemSection(
                            actionItem = actionItem,
                            modifier = Modifier
                                .padding(
                                    top = 18.dp,
                                    start = 18.dp,
                                    end = endPadding
                                )
                        )
                    }

                    item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                        UpiIdSection(
                            state = upiIdState,
                            modifier = Modifier
                                .padding(16.dp)
                        )
                    }
                }
            }
        }
    }
}