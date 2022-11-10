package com.cyrilpillai.androidplayground.payments.state

import androidx.compose.ui.graphics.Color
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.payments.model.ActionItem
import com.cyrilpillai.androidplayground.payments.model.CircularItem
import com.cyrilpillai.androidplayground.payments.model.SearchBarItem
import com.cyrilpillai.androidplayground.payments.ui.components.CircularState
import com.cyrilpillai.androidplayground.payments.ui.components.HorizontalActionState
import com.cyrilpillai.androidplayground.payments.ui.components.TopBarState
import com.cyrilpillai.androidplayground.payments.ui.components.UpiIdState
import com.cyrilpillai.androidplayground.payments.ui.components.VerticalActionState
import com.cyrilpillai.androidplayground.ui.theme.Amber800
import com.cyrilpillai.androidplayground.ui.theme.Blue800
import com.cyrilpillai.androidplayground.ui.theme.BlueGrey800
import com.cyrilpillai.androidplayground.ui.theme.Brown800
import com.cyrilpillai.androidplayground.ui.theme.Cyan800
import com.cyrilpillai.androidplayground.ui.theme.DeepOrange800
import com.cyrilpillai.androidplayground.ui.theme.DeepPurple800
import com.cyrilpillai.androidplayground.ui.theme.Green800
import com.cyrilpillai.androidplayground.ui.theme.Grey800
import com.cyrilpillai.androidplayground.ui.theme.Indigo800
import com.cyrilpillai.androidplayground.ui.theme.LightBlue800
import com.cyrilpillai.androidplayground.ui.theme.LightGreen800
import com.cyrilpillai.androidplayground.ui.theme.Lime800
import com.cyrilpillai.androidplayground.ui.theme.Orange800
import com.cyrilpillai.androidplayground.ui.theme.Pink800
import com.cyrilpillai.androidplayground.ui.theme.Purple800
import com.cyrilpillai.androidplayground.ui.theme.Red800
import com.cyrilpillai.androidplayground.ui.theme.Teal800
import com.cyrilpillai.androidplayground.ui.theme.Yellow800
import com.cyrilpillai.androidplayground.utils.StorageBucket.PAYMENT
import com.cyrilpillai.androidplayground.utils.getQualifiedImageUrl
import kotlin.random.Random

fun getTopBarState(): TopBarState {
    return TopBarState(
        backdrop = R.drawable.payment_backdrop,
        searchBarItem = SearchBarItem(
            hint = "Pay by name or phone",
            icon = R.drawable.ic_search_outline,
            profileImageUrl = getQualifiedImageUrl("chandler_bing", PAYMENT)
        )
    )
}

fun getHorizontalActionState(): HorizontalActionState {
    return HorizontalActionState(
        listOf(
            ActionItem(
                description = "Scan any\nQR code",
                icon = R.drawable.ic_qr_code_scanner
            ),
            ActionItem(
                description = "Pay\ncontacts",
                icon = R.drawable.ic_phonebook
            ),
            ActionItem(
                description = "Pay phone\nnumber",
                icon = R.drawable.ic_send_to_mobile
            ),
            ActionItem(
                description = "Bank\ntransfer",
                icon = R.drawable.ic_bank
            ),
            ActionItem(
                description = "Pay UPI ID\nor number",
                icon = R.drawable.ic_email
            ),
            ActionItem(
                description = "Self\nTransfer",
                icon = R.drawable.ic_person
            ),
            ActionItem(
                description = "Pay\nbills",
                icon = R.drawable.ic_bills
            ),
            ActionItem(
                description = "Mobile\nrecharge",
                icon = R.drawable.ic_mobile_recharge
            )
        )
    )
}

fun getVerticalActionState(): VerticalActionState {
    return VerticalActionState(
        actions = listOf(
            ActionItem(
                description = "Show transaction history",
                icon = R.drawable.ic_history
            ),
            ActionItem(
                description = "Check bank balance",
                icon = R.drawable.ic_bank
            )
        )
    )
}

fun getUpiIdState(): UpiIdState {
    return UpiIdState(
        text = "UPI ID: chandler.bing@friendsbank"
    )
}

fun getPeopleState(isCollapsed: Boolean = true): CircularState {
    val people = if (isCollapsed) getPeople().take(7) else getPeople()
    val toggle = if (isCollapsed) {
        CircularItem.Toggle(
            description = "More",
            icon = R.drawable.ic_expand_more
        )
    } else {
        CircularItem.Toggle(
            description = "Less",
            icon = R.drawable.ic_expand_less
        )
    }
    return CircularState(circularItems = people + toggle)
}

fun getBusinessState(isCollapsed: Boolean = true): CircularState {
    val businesses = if (isCollapsed) getBusinesses().take(3) else getBusinesses()
    val toggle = if (isCollapsed) {
        CircularItem.Toggle(
            description = "More",
            icon = R.drawable.ic_expand_more
        )
    } else {
        CircularItem.Toggle(
            description = "Less",
            icon = R.drawable.ic_expand_less
        )
    }
    return CircularState(circularItems = businesses + toggle)
}

fun getPromotionState(): CircularState {
    return CircularState(
        circularItems = listOf(
            CircularItem.Info(
                description = "Rewards",
                backgroundColor = getRandomColor(),
                imageUrl = getQualifiedImageUrl("rewards", PAYMENT)
            ),
            CircularItem.Info(
                description = "Offers",
                backgroundColor = getRandomColor(),
                imageUrl = getQualifiedImageUrl("offers", PAYMENT)
            ),
            CircularItem.Info(
                description = "Referrals",
                backgroundColor = getRandomColor(),
                imageUrl = getQualifiedImageUrl("referrals", PAYMENT)
            ),
            CircularItem.Info(
                description = "Indi-Home",
                backgroundColor = getRandomColor(),
                imageUrl = getQualifiedImageUrl("indi_home", PAYMENT)
            )
        )
    )
}

private fun getPeople(): List<CircularItem> {
    return listOf(
        CircularItem.Info(
            description = "Joey",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl("joey_tribbiani", PAYMENT)
        ),
        CircularItem.Info(
            description = "Monica",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl("monica_geller", PAYMENT)
        ),
        CircularItem.Info(
            description = "Ross",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Rachel",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl("rachel_green", PAYMENT)
        ),
        CircularItem.Info(
            description = "Phoebe",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl("phoebe_buffay", PAYMENT)
        ),
        CircularItem.Info(
            description = "Mike",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Janice",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl("janice_hosenstein", PAYMENT)
        )
    )
}

private fun getBusinesses(): List<CircularItem> {
    return listOf(
        CircularItem.Info(
            description = "Airtel Postpaid",
            backgroundColor = getRandomColor(),
            imageUrl = null,
        ),
        CircularItem.Info(
            description = "Citibank",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Adani Electricity",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Bharatpe",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "HDFC Bank",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Zerodha Broking",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Zomato",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "HP Gas",
            backgroundColor = getRandomColor(),
            imageUrl = null
        )
    )
}

private fun getRandomColor(): Color {
    return colors[Random.nextInt(colors.size)]
}

private val colors = listOf(
    Red800,
    Pink800,
    Purple800,
    DeepPurple800,
    Indigo800,
    Blue800,
    LightBlue800,
    Cyan800,
    Teal800,
    Green800,
    LightGreen800,
    Lime800,
    Yellow800,
    Amber800,
    Orange800,
    DeepOrange800,
    Brown800,
    Grey800,
    BlueGrey800
)