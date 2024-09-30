package com.example.general.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color


private val CustomDarkColors = CustomColors(
    backgroundColor = dark22,
    buttonBackgroundColor = Teal200,
    buttonTextColor = dark22,
    textColor = lightCC
)

private val CustomLightColors = CustomColors(
    backgroundColor = lightCC,
    buttonBackgroundColor = Purple500,
    buttonTextColor = lightCC,
    textColor = dark22
)

private val LocalColorsProvider = staticCompositionLocalOf {
    CustomLightColors
}

@Composable
private fun CustomLocalProvider(
    colors: CustomColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        colors.initColors()
    }
    colorPalette.update(colors)

    CompositionLocalProvider(
        LocalColorsProvider provides colorPalette,
        content = content
    )


}

private val CustomTheme.colors: Pair<Colors, CustomColors>
    get() = when (this) {
        CustomTheme.DARK -> darkColors() to CustomDarkColors
        CustomTheme.LIGHT -> lightColors() to CustomLightColors
    }


object CustomThemeManager {
    val colors: CustomColors
        @Composable
        get() = LocalColorsProvider.current

    var customTheme by mutableStateOf(CustomTheme.LIGHT)

    fun isSystemInDarkTheme() : Boolean {
        return customTheme == CustomTheme.DARK
    }
}


@Composable
fun GeneralTheme(
    customTheme: CustomTheme = CustomThemeManager.customTheme,
    content: @Composable () -> Unit
) {

    val (colorPalette , myColor) = customTheme.colors


    CustomLocalProvider(colors = myColor) {
        MaterialTheme(
            colors = colorPalette,
//            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }

}