package com.cyrilpillai.androidplayground.payments.state

import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.payments.model.SearchBarItem
import com.cyrilpillai.androidplayground.payments.ui.components.TopBarState
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