package com.example.piedrapapeltijera.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Esquema de colores de la aplicación
 */
private val ColorScheme = lightColorScheme(
    primary = Color(0xFF1976D2),
    secondary = Color(0xFF4CAF50),
    tertiary = Color(0xFFE53935),
    background = Color(0xFFFAFAFA),
    surface = Color(0xFFFFFFFF),
    error = Color(0xFFE53935),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
)

/**
 * Tema de la aplicación - Nombre original
 */
@Composable
fun PiedraPapelTijeraTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = ColorScheme,
        content = content
    )
}

/**
 * Tema de la aplicación - Alias
 */
@Composable
fun AppTheme(
    content: @Composable () -> Unit
) {
    PiedraPapelTijeraTheme(content)
}