package com.example.piedrapapeltijera.domain.usecases

import com.example.piedrapapeltijera.domain.entities.Jugada
import com.example.piedrapapeltijera.domain.entities.ResultadoRonda
import com.example.piedrapapeltijera.domain.entities.ganaA

/**
 * Caso de uso: Calcular el resultado de una ronda
 *
 * Encapsula la lógica de negocio para determinar quién gana
 * una ronda del juego piedra-papel-tijeras
 */
class CalcularResultadoRonda {

    /**
     * Ejecuta el cálculo del resultado
     *
     * @param jugadaJugador Jugada del jugador humano
     * @param jugadaIA Jugada de la IA
     * @return Resultado desde la perspectiva del jugador
     */
    operator fun invoke(jugadaJugador: Jugada, jugadaIA: Jugada): ResultadoRonda {
        return when {
            jugadaJugador == jugadaIA -> ResultadoRonda.EMPATE
            jugadaJugador.ganaA(jugadaIA) -> ResultadoRonda.VICTORIA
            else -> ResultadoRonda.DERROTA
        }
    }
}