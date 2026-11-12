package com.senai.carteirinhadigital.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
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
import com.senai.carteirinhadigital.core.designsystem.theme.AppTypography

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


private val PremiumLightColorScheme = lightColorScheme(
    primary = GoldDark,
    onPrimary = TextWhite,
    secondary = Gold,
    onSecondary = BackgroundBlack,
    tertiary = GoldDark,
    onTertiary = TextWhite,
    background = androidx.compose.ui.graphics.Color(0xFFF7F5EF),
    onBackground = androidx.compose.ui.graphics.Color(0xFF171717),
    surface = androidx.compose.ui.graphics.Color(0xFFFFFEFA),
    onSurface = androidx.compose.ui.graphics.Color(0xFF171717),
    surfaceVariant = androidx.compose.ui.graphics.Color(0xFFECE8DE),
    onSurfaceVariant = androidx.compose.ui.graphics.Color(0xFF5D5A52),
    outline = androidx.compose.ui.graphics.Color(0xFFD1C8B5),
    error = ErrorRed,
    onError = TextWhite
)

@Composable
fun CarteirinhaDigitalTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) PremiumDarkColorScheme else PremiumLightColorScheme,
        typography = AppTypography,
        content = content
    )
}