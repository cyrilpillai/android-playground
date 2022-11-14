package com.cyrilpillai.androidplayground.utils

import androidx.compose.ui.graphics.Color
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
import kotlin.random.Random

fun getRandomColor(): Color {
    return colors[Random.nextInt(colors.size)]
}

val colors = listOf(
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