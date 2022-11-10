package com.cyrilpillai.androidplayground.payments.state

import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.payments.model.ActionItem
import com.cyrilpillai.androidplayground.payments.model.SearchBarItem
import com.cyrilpillai.androidplayground.payments.ui.components.ActionState
import com.cyrilpillai.androidplayground.payments.ui.components.TopBarState
import com.cyrilpillai.androidplayground.payments.ui.components.UpiIdState
import com.cyrilpillai.androidplayground.utils.StorageBucket.MESSAGING
import com.cyrilpillai.androidplayground.utils.getQualifiedImageUrl

fun getTopBarState(): TopBarState {
    return TopBarState(
        backdrop = R.drawable.payment_backdrop,
        searchBarItem = SearchBarItem(
            hint = "Pay by name or phone",
            icon = R.drawable.ic_search_outline,
            profileImageUrl = getQualifiedImageUrl("ryan_howard", MESSAGING)
        )
    )
}

fun getActionState(): ActionState {
    return ActionState(
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

fun getUpiIdState(): UpiIdState {
    return UpiIdState(
        text = "UPI ID: chandler.bing@friendsbank"
    )
}