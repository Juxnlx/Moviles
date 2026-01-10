package com.example.piedrapapeltijera.ui.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.piedrapapeltijera.domain.entities.Jugada

/**
 * Modelo de UI que mapea las jugadas del dominio
 * con sus representaciones visuales
 */
data class JugadaUI(
    val jugada: Jugada,
    val nombre: String,
    val icono: ImageVector
)

/**
 * Convierte una Jugada del dominio a su representación UI
 */
fun Jugada.toUI(): JugadaUI {
    return when (this) {
        Jugada.PIEDRA -> JugadaUI(
            jugada = this,
            nombre = "Piedra",
            icono = Icons.Default.Circle
        )
        Jugada.PAPEL -> JugadaUI(
            jugada = this,
            nombre = "Papel",
            icono = Icons.Default.Description
        )
        Jugada.TIJERAS -> JugadaUI(
            jugada = this,
            nombre = "Tijeras",
            icono = Icons.Default.ContentCut
        )
    }
}

/**
 * Lista de todas las jugadas con su representación UI
 */
object JugadasUI {
    val todas: List<JugadaUI> = Jugada.entries.map { it.toUI() }
}