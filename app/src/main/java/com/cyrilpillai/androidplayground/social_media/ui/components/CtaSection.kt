package com.cyrilpillai.androidplayground.social_media.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cyrilpillai.androidplayground.social_media.model.CtaItem
import com.cyrilpillai.androidplayground.social_media.state.getCtaState
import com.cyrilpillai.androidplayground.ui.theme.Grey900

data class CtaState(
    val ctas: List<CtaItem>
)

@Composable
fun CtaSection(
    state: CtaState,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .height(26.dp)
            .fillMaxWidth()
    ) {
        state.ctas.forEach { ctaItem ->
            Surface(
                shape = RoundedCornerShape(4.dp),
                color = Grey900,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(if (ctaItem.text != null) 1f else 0.2f)
                    .padding(horizontal = 2.dp)

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                ) {
                    ctaItem.text?.let {
                        Text(
                            text = it,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = ctaItem.color
                        )
                    }
                    ctaItem.icon?.let {
                        Icon(
                            painter = painterResource(id = it),
                            contentDescription = "cta",
                            tint = ctaItem.color,
                            modifier = Modifier
                                .size(14.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CtaSectionPreview() {
    Box(
        modifier = Modifier.background(Color.Black)
    ) {
        CtaSection(
            state = getCtaState(),
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
    }
}