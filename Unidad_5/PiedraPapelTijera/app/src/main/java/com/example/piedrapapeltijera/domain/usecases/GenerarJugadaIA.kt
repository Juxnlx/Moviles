package com.example.piedrapapeltijera.domain.usecases

import com.example.piedrapapeltijera.domain.entities.Jugada

/**
 * Caso de uso: Generar jugada de la IA
 *
 * Encapsula la lógica para que la IA elija una jugada
 */
class GenerarJugadaIA {

    /**
     * Ejecuta la generación de una jugada aleatoria
     *
     * @return Jugada generada por la IA
     */
    operator fun invoke(): Jugada {
        return Jugada.random()
    }
}