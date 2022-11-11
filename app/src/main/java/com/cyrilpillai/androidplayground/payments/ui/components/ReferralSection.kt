package com.cyrilpillai.androidplayground.payments.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.payments.model.ReferralItem
import com.cyrilpillai.androidplayground.payments.state.getReferralState
import com.cyrilpillai.androidplayground.ui.theme.Blue100Transparent
import com.cyrilpillai.androidplayground.ui.theme.Grey700
import com.cyrilpillai.androidplayground.ui.theme.Grey800

data class ReferralState(
    val referralItem: ReferralItem
)

@Composable
fun ReferralSection(
    state: ReferralState,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Blue100Transparent,
        modifier = modifier
            .height(200.dp)
    ) {
        ReferralBackdropSection(
            illustration = R.drawable.ic_referral_illustration
        )
        ReferralDetailsSection(
            referralItem = state.referralItem
        )
    }
}

@Composable
fun ReferralDetailsSection(
    referralItem: ReferralItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        with(referralItem) {
            Text(
                text = title,
                fontSize = 14.sp,
                color = Grey800,
            )
            Text(
                text = description,
                fontSize = 12.sp,
                color = Grey700,
                modifier = Modifier
                    .padding(top = 4.dp)
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = getAnnotatedReferralCodeText(
                        codePrefix = codePrefix,
                        code = code
                    ),
                    fontSize = 12.sp,
                    color = Grey700
                )

                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_copy
                    ),
                    contentDescription = "referral copy icon",
                    tint = Grey700,
                    modifier = Modifier
                        .padding(start = 4.dp)
                        .align(Alignment.CenterVertically)
                        .size(14.dp)
                )
            }
            CtaSection(
                ctaItem = ctaItem,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}

@Composable
fun ReferralBackdropSection(
    @DrawableRes illustration: Int,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.BottomEnd,
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(
                id = illustration
            ),
            alignment = Alignment.BottomEnd,
            contentDescription = "referral illustration",
            modifier = Modifier
                .aspectRatio(
                    ratio = 1.2f,
                    matchHeightConstraintsFirst = true
                )
        )
    }
}

private fun getAnnotatedReferralCodeText(
    codePrefix: String,
    code: String
): AnnotatedString {
    return buildAnnotatedString {
        append(codePrefix)
        pushStyle(
            SpanStyle(
                fontWeight = FontWeight.SemiBold
            )
        )
        append(" ")
        append(code)
        pop()
    }
}

@Preview(showBackground = true)
@Composable
private fun ReferralSectionPreview() {
    ReferralSection(
        state = getReferralState(),
        modifier = Modifier
            .padding(16.dp)
    )
}