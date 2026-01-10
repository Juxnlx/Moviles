package com.example.piedrapapeltijera.domain.entities

/**
 * Representa una opción del juego
 */
enum class Jugada(val displayName: String) {
    PIEDRA("Piedra"),
    PAPEL("Papel"),
    TIJERAS("Tijeras");

    companion object {
        /**
         * Genera una jugada aleatoria
         */
        fun random(): Jugada = entries.random()
    }
}

/**
 * Extension function para determinar si una jugada gana a otra
 */
fun Jugada.ganaA(otra: Jugada): Boolean {
    return when (this) {
        Jugada.PIEDRA -> otra == Jugada.TIJERAS
        Jugada.PAPEL -> otra == Jugada.PIEDRA
        Jugada.TIJERAS -> otra == Jugada.PAPEL
    }
}