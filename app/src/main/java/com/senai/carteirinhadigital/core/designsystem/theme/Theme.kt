package com.senai.carteirinhadigital.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import com.senai.carteirinhadigital.core.designsystem.theme.BackgroundBlack
import com.senai.carteirinhadigital.core.designsystem.theme.BorderDark
import com.senai.carteirinhadigital.core.designsystem.theme.CardDark
import com.senai.carteirinhadigital.core.designsystem.theme.ErrorRed
import com.senai.carteirinhadigital.core.designsystem.theme.Gold
import com.senai.carteirinhadigital.core.designsystem.theme.GoldDark
import com.senai.carteirinhadigital.core.designsystem.theme.GoldLight
import com.senai.carteirinhadigital.core.designsystem.theme.SurfaceDark
import com.senai.carteirinhadigital.core.designsystem.theme.TextSecondary
import com.senai.carteirinhadigital.core.designsystem.theme.TextWhite

private val PremiumDarkColorScheme = darkColorScheme(
    primary = Gold,
    onPrimary = BackgroundBlack,

    secondary = GoldLight,
    onSecondary = BackgroundBlack,

    tertiary = GoldDark,
    onTertiary = TextWhite,

    background = BackgroundBlack,
    onBackground = TextWhite,

    surface = SurfaceDark,
    onSurface = TextWhite,

    surfaceVariant = CardDark,
    onSurfaceVariant = TextSecondary,

    outline = BorderDark,

    error = ErrorRed,
    onError = TextWhite
)

@Composable
fun CarteirinhaDigitalTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = PremiumDarkColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = androidx.compose.material3.Typography(),
        content = content
    )
}