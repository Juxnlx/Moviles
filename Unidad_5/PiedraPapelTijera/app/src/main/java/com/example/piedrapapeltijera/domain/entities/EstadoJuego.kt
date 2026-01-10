
package com.example.piedrapapeltijera.domain.entities

/**
 * Entidad que representa el estado completo de una partida
 */
data class EstadoJuego(
    val nombreJugador: String = "",
    val nombreIA: String = "¡IA!",
    val jugadaJugador: Jugada? = null,
    val jugadaIA: Jugada? = null,
    val resultadoRonda: ResultadoRonda? = null,
    val puntosJugador: Int = 0,
    val puntosIA: Int = 0,
    val rondaActual: Int = 0,
    val rondasMaximas: Int = 3,
    val juegoTerminado: Boolean = false
) {
    /**
     * Obtiene el nombre del ganador de la partida
     * @return Nombre del ganador, "Empate" o null si no ha terminado
     */
    fun obtenerGanador(): String? {
        return when {
            !juegoTerminado -> null
            puntosJugador > puntosIA -> nombreJugador
            puntosIA > puntosJugador -> nombreIA
            else -> "Empate"
        }
    }

    /**
     * @return Texto formateado del marcador
     */
    fun obtenerMarcador(): String = "$puntosJugador - $puntosIA"

    /**
     * @return Texto de la ronda actual
     */
    fun obtenerTextoRonda(): String = "Ronda $rondaActual/$rondasMaximas"
}