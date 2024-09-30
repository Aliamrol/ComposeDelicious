package com.example.general.screens


import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color

enum class CustomTheme {
    DARK, LIGHT
}

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val dark22 = Color(0xFF222222)
val lightCC = Color(0xFFCCCCCC)

val Pink = Color(0xFFB50F53)
val LightGray = Color(0xFFF1F1F1)
val DarkGray = Color(0xFFACACAC)

@Stable
class CustomColors(
    backgroundColor: Color,
    buttonBackgroundColor: Color,
    buttonTextColor: Color,
    textColor: Color
) {
    var backgroundColor by mutableStateOf(backgroundColor)
        private set

    var buttonBackgroundColor by mutableStateOf(buttonBackgroundColor)
        private set

    var buttonTextColor by mutableStateOf(buttonTextColor)
        private set

    var textColor by mutableStateOf(textColor)
        private set

    fun update(colors: CustomColors) {
        this.backgroundColor = colors.backgroundColor
        this.buttonBackgroundColor = colors.buttonBackgroundColor
        this.buttonTextColor = colors.buttonTextColor
        this.textColor = colors.textColor
    }

    fun initColors() =
        CustomColors(backgroundColor, buttonBackgroundColor, buttonTextColor, textColor)
}