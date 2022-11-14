package com.cyrilpillai.androidplayground.payments.state

import androidx.compose.ui.graphics.Color
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.payments.model.ActionItem
import com.cyrilpillai.androidplayground.payments.model.BillItem
import com.cyrilpillai.androidplayground.payments.model.BillSuggestion
import com.cyrilpillai.androidplayground.payments.model.CircularItem
import com.cyrilpillai.androidplayground.payments.model.CtaItem
import com.cyrilpillai.androidplayground.payments.model.ReferralItem
import com.cyrilpillai.androidplayground.payments.model.SearchBarItem
import com.cyrilpillai.androidplayground.payments.ui.components.BillState
import com.cyrilpillai.androidplayground.payments.ui.components.CircularState
import com.cyrilpillai.androidplayground.payments.ui.components.FooterState
import com.cyrilpillai.androidplayground.payments.ui.components.HorizontalActionState
import com.cyrilpillai.androidplayground.payments.ui.components.ReferralState
import com.cyrilpillai.androidplayground.payments.ui.components.TopBarState
import com.cyrilpillai.androidplayground.payments.ui.components.UpiIdState
import com.cyrilpillai.androidplayground.payments.ui.components.VerticalActionState
import com.cyrilpillai.androidplayground.ui.theme.Blue800
import com.cyrilpillai.androidplayground.utils.StorageBucket.PAYMENT
import com.cyrilpillai.androidplayground.utils.getQualifiedImageUrl
import com.cyrilpillai.androidplayground.utils.getRandomColor

fun getTopBarState(): TopBarState {
    return TopBarState(
        backdrop = R.drawable.payment_backdrop,
        searchBarItem = SearchBarItem(
            hint = "Pay by name or phone",
            icon = R.drawable.ic_search_outline,
            profileImageUrl = getQualifiedImageUrl(
                relativeName = "chandler_bing",
                storageBucket = PAYMENT
            )
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

fun getPeopleState(
    people: List<CircularItem>,
    isCollapsed: Boolean = true
): CircularState {
    val result = if (isCollapsed) people.take(7) else people
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
    return CircularState(header = "People", circularItems = result + toggle)
}

fun getBusinessState(
    businesses: List<CircularItem>,
    isCollapsed: Boolean = true
): CircularState {
    val result = if (isCollapsed) businesses.take(3) else businesses
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
    return CircularState(header = "Businesses", circularItems = result + toggle)
}

fun getPromotionState(): CircularState {
    return CircularState(
        header = "Promotions",
        circularItems = listOf(
            CircularItem.Info(
                description = "Rewards",
                backgroundColor = getRandomColor(),
                imageUrl = getQualifiedImageUrl(
                    relativeName = "rewards",
                    storageBucket = PAYMENT
                )
            ),
            CircularItem.Info(
                description = "Offers",
                backgroundColor = getRandomColor(),
                imageUrl = getQualifiedImageUrl(
                    relativeName = "offers",
                    storageBucket = PAYMENT
                )
            ),
            CircularItem.Info(
                description = "Referrals",
                backgroundColor = getRandomColor(),
                imageUrl = getQualifiedImageUrl(
                    relativeName = "referrals",
                    storageBucket = PAYMENT
                )
            ),
            CircularItem.Info(
                description = "Indi-Home",
                backgroundColor = getRandomColor(),
                imageUrl = getQualifiedImageUrl(
                    relativeName = "indi_home",
                    storageBucket = PAYMENT
                )
            )
        )
    )
}

fun getBillState(): BillState {
    return BillState(
        header = "Bills, recharges and more",
        BillItem(
            icon = R.drawable.ic_bills_paid,
            description = "All your bills are paid and up to\ndate",
            suggestionHeader = "ALSO TRY ADDING",
            ctaItem = CtaItem(
                text = "See all",
                color = Blue800
            ),
            billSuggestions = listOf(
                BillSuggestion(
                    icon = R.drawable.ic_tv,
                    description = "DTH /\nCable TV"
                ),
                BillSuggestion(
                    icon = R.drawable.ic_smartphone,
                    description = "Potspaid\nmobile"
                ),
                BillSuggestion(
                    icon = R.drawable.ic_router,
                    description = "Broadband/Landline"
                ),
            )
        )
    )
}

fun getReferralState(): ReferralState {
    return ReferralState(
        referralItem = ReferralItem(
            title = "Invite your friends to Google Pay",
            description = "Invite friends to Google Pay and get ₹201 when your friend sends their first payment. They get ₹21!",
            codePrefix = "Copy your code",
            code = "121qe",
            ctaItem = CtaItem(
                text = "Invite",
                color = Color.DarkGray
            )
        )
    )
}

fun getFooterState(): FooterState {
    return FooterState(
        text = "Showing businesses based on your location - Learn more"
    )
}

fun getPeople(): List<CircularItem> {
    return listOf(
        CircularItem.Info(
            description = "Joey",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "joey_tribbiani",
                storageBucket = PAYMENT
            )
        ),
        CircularItem.Info(
            description = "Monica",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "monica_geller",
                storageBucket = PAYMENT
            )
        ),
        CircularItem.Info(
            description = "Ross",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Rachel",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "rachel_green",
                storageBucket = PAYMENT
            )
        ),
        CircularItem.Info(
            description = "Phoebe",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "phoebe_buffay",
                storageBucket = PAYMENT
            )
        ),
        CircularItem.Info(
            description = "Mike",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Janice",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "janice_hosenstein",
                storageBucket = PAYMENT
            )
        ),
        CircularItem.Info(
            description = "Gunther",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Jill",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "jill_green",
                storageBucket = PAYMENT
            )
        ),
        CircularItem.Info(
            description = "Judy",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Emily",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "emily_waltham",
                storageBucket = PAYMENT
            )
        ),
        CircularItem.Info(
            description = "Ursula",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Roy",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Jack",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "jack_geller",
                storageBucket = PAYMENT
            )
        ),
        CircularItem.Info(
            description = "Danny",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
    )
}

fun getBusinesses(): List<CircularItem> {
    return listOf(
        CircularItem.Info(
            description = "Airtel Postpaid",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "airtel",
                storageBucket = PAYMENT
            )
        ),
        CircularItem.Info(
            description = "Citibank",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Bharatpe",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "bharatpe",
                storageBucket = PAYMENT
            )
        ),
        CircularItem.Info(
            description = "Adani Electricity",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Apple Inc",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "apple",
                storageBucket = PAYMENT
            )
        ),
        CircularItem.Info(
            description = "HDFC Bank",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Cred",
            backgroundColor = getRandomColor(),
            imageUrl = null
        ),
        CircularItem.Info(
            description = "Zerodha Broking",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "zerodha",
                storageBucket = PAYMENT
            )
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
        ),
        CircularItem.Info(
            description = "Swiggy",
            backgroundColor = getRandomColor(),
            imageUrl = getQualifiedImageUrl(
                relativeName = "swiggy",
                storageBucket = PAYMENT
            )
        ),
    )
}