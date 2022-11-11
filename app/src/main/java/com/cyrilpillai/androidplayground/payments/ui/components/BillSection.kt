package com.cyrilpillai.androidplayground.payments.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.R
import com.cyrilpillai.androidplayground.payments.model.BillItem
import com.cyrilpillai.androidplayground.payments.model.BillSuggestion
import com.cyrilpillai.androidplayground.payments.model.CtaItem
import com.cyrilpillai.androidplayground.payments.state.getBillState
import com.cyrilpillai.androidplayground.ui.theme.Blue800
import com.cyrilpillai.androidplayground.ui.theme.Grey100
import com.cyrilpillai.androidplayground.ui.theme.Grey700
import com.cyrilpillai.androidplayground.ui.theme.Grey800

data class BillState(
    val header: String,
    val billItem: BillItem
)

@Composable
fun BillSection(
    state: BillState,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        with(state.billItem) {
            BillStatusSection(
                icon = icon,
                description = description
            )
            BillSuggestionSection(
                header = suggestionHeader,
                billSuggestions = billSuggestions,
                modifier = Modifier
                    .padding(top = 4.dp)
            )
            CtaSection(
                ctaItem = CtaItem(
                    text = cta,
                    color = Blue800
                ),
                modifier = Modifier
                    .padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun BillStatusSection(
    @DrawableRes icon: Int,
    description: String,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Grey100,
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "bill status icon",
                modifier = Modifier
                    .size(60.dp)
            )

            Text(
                text = description,
                fontSize = 15.sp,
                color = Grey700,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
        }
    }
}

@Composable
fun BillSuggestionSection(
    header: String,
    billSuggestions: List<BillSuggestion>,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Grey100,
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Text(
                text = header,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                letterSpacing = 2.sp,
                color = Color.DarkGray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 4.dp)
            ) {
                billSuggestions.take(3).forEach {
                    BillSuggestionItemSection(
                        billSuggestion = it,
                        modifier = Modifier
                            .padding(8.dp)
                            .weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun BillSuggestionItemSection(
    billSuggestion: BillSuggestion,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color.White,
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(12.dp)
        ) {
            with(billSuggestion) {
                Icon(
                    painter = painterResource(id = icon),
                    tint = Blue800,
                    contentDescription = "bill suggestion icon",
                    modifier = Modifier
                        .size(16.dp)
                )
                Text(
                    text = description,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    color = Grey800,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(top = 4.dp)
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BillSectionPreview() {
    BillSection(
        state = getBillState(),
        modifier = Modifier
    )
}