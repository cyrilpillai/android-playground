package com.cyrilpillai.androidplayground.payments

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cyrilpillai.androidplayground.payments.model.CircularItem
import com.cyrilpillai.androidplayground.payments.state.getBillState
import com.cyrilpillai.androidplayground.payments.state.getBusinessState
import com.cyrilpillai.androidplayground.payments.state.getBusinesses
import com.cyrilpillai.androidplayground.payments.state.getFooterState
import com.cyrilpillai.androidplayground.payments.state.getHorizontalActionState
import com.cyrilpillai.androidplayground.payments.state.getPeople
import com.cyrilpillai.androidplayground.payments.state.getPeopleState
import com.cyrilpillai.androidplayground.payments.state.getPromotionState
import com.cyrilpillai.androidplayground.payments.state.getReferralState
import com.cyrilpillai.androidplayground.payments.state.getTopBarState
import com.cyrilpillai.androidplayground.payments.state.getUpiIdState
import com.cyrilpillai.androidplayground.payments.state.getVerticalActionState
import com.cyrilpillai.androidplayground.payments.ui.components.BillSection
import com.cyrilpillai.androidplayground.payments.ui.components.BillState
import com.cyrilpillai.androidplayground.payments.ui.components.CircularItemSection
import com.cyrilpillai.androidplayground.payments.ui.components.CircularState
import com.cyrilpillai.androidplayground.payments.ui.components.FooterSection
import com.cyrilpillai.androidplayground.payments.ui.components.HeaderTextSection
import com.cyrilpillai.androidplayground.payments.ui.components.HorizontalActionItemSection
import com.cyrilpillai.androidplayground.payments.ui.components.ReferralSection
import com.cyrilpillai.androidplayground.payments.ui.components.TopBarSection
import com.cyrilpillai.androidplayground.payments.ui.components.UpiIdSection
import com.cyrilpillai.androidplayground.payments.ui.components.VerticalActionItemSection
import com.cyrilpillai.androidplayground.ui.theme.AndroidPlaygroundTheme
import com.cyrilpillai.androidplayground.ui.theme.BlueBackdrop
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PaymentActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPlaygroundTheme(
                statusBarColor = BlueBackdrop
            ) {
                PaymentScreen()
            }
        }
    }

    @Composable
    private fun PaymentScreen() {
        val scaffoldState = rememberScaffoldState()
        val coroutineScope = rememberCoroutineScope()

        val people by remember { mutableStateOf(getPeople()) }
        val businesses by remember { mutableStateOf(getBusinesses()) }
        val topBarState by remember { mutableStateOf(getTopBarState()) }
        val horizontalActionState by remember { mutableStateOf(getHorizontalActionState()) }
        val upiIdState by remember { mutableStateOf(getUpiIdState()) }
        var peopleState by remember { mutableStateOf(getPeopleState(people)) }
        var businessState by remember { mutableStateOf(getBusinessState(businesses)) }
        val billState by remember { mutableStateOf(getBillState()) }
        val promotionState by remember { mutableStateOf(getPromotionState()) }
        val verticalActionState by remember { mutableStateOf(getVerticalActionState()) }
        val referralState by remember { mutableStateOf(getReferralState()) }
        val footerState by remember { mutableStateOf(getFooterState()) }

        Scaffold(
            scaffoldState = scaffoldState
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(4),
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                    TopBarSection(state = topBarState)
                }

                items(
                    items = horizontalActionState.actions,
                ) { action ->
                    HorizontalActionItemSection(
                        actionItem = action,
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

                addPeople(peopleState) { circularItem ->
                    when (circularItem) {
                        is CircularItem.Info -> {
                            coroutineScope.showSnackBar(
                                message = "${circularItem.description} clicked",
                                scaffoldState = scaffoldState
                            )
                        }
                        is CircularItem.Toggle -> {
                            peopleState = getPeopleState(
                                people = people,
                                isCollapsed = circularItem.description == "Less"
                            )
                        }
                    }
                }
                addBusinesses(businessState) { circularItem ->
                    when (circularItem) {
                        is CircularItem.Info -> {
                            coroutineScope.showSnackBar(
                                message = "${circularItem.description} clicked",
                                scaffoldState = scaffoldState
                            )
                        }
                        is CircularItem.Toggle -> {
                            businessState = getBusinessState(
                                businesses = businesses,
                                isCollapsed = circularItem.description == "Less"
                            )
                        }
                    }
                }
                addBills(billState)
                addPromotions(promotionState) { circularItem ->
                    if (circularItem is CircularItem.Info) {
                        coroutineScope.showSnackBar(
                            message = "${circularItem.description} clicked",
                            scaffoldState = scaffoldState
                        )
                    }
                }

                item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                    Spacer(
                        modifier = Modifier.height(
                            16.dp
                        )
                    )
                }

                verticalActionState.actions.forEach {
                    item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                        VerticalActionItemSection(
                            actionItem = it,
                            modifier = Modifier
                                .padding(16.dp)
                        )
                    }
                }

                item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                    ReferralSection(
                        state = referralState,
                        modifier = Modifier
                            .padding(top = 16.dp)
                    )
                }

                item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                    FooterSection(
                        state = footerState,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 24.dp)
                    )
                }
            }
        }
    }

    private fun LazyGridScope.addPeople(
        peopleState: CircularState,
        onClick: (CircularItem) -> Unit
    ) {
        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            HeaderTextSection(
                text = peopleState.header,
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
                onClick = onClick,
                modifier = Modifier
                    .padding(top = 8.dp)
            )
        }
    }

    private fun LazyGridScope.addBusinesses(
        businessState: CircularState,
        onClick: (CircularItem) -> Unit
    ) {
        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            HeaderTextSection(
                text = businessState.header,
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
                onClick = onClick,
                modifier = Modifier
                    .padding(top = 8.dp)
            )
        }
    }

    private fun LazyGridScope.addBills(
        billState: BillState
    ) {
        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            HeaderTextSection(
                text = billState.header,
                modifier = Modifier
                    .padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 24.dp
                    )
            )
        }

        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            BillSection(
                state = billState,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }

    private fun LazyGridScope.addPromotions(
        promotionState: CircularState,
        onClick: (CircularItem) -> Unit
    ) {
        item(span = { GridItemSpan(maxCurrentLineSpan) }) {
            HeaderTextSection(
                text = promotionState.header,
                modifier = Modifier
                    .padding(
                        start = 24.dp,
                        end = 24.dp,
                        bottom = 16.dp
                    )
            )
        }

        items(
            items = promotionState.circularItems,
        ) {
            CircularItemSection(
                circularItem = it,
                onClick = onClick,
                modifier = Modifier
            )
        }
    }

    private fun CoroutineScope.showSnackBar(
        message: String,
        scaffoldState: ScaffoldState
    ) {
        launch {
            scaffoldState.snackbarHostState.showSnackbar(
                message
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    private fun PaymentScreenPreview() {
        PaymentScreen()
    }
}