package com.example.piedrapapeltijera.data.repositories

import com.example.piedrapapeltijera.domain.entities.EstadoJuego
import com.example.piedrapapeltijera.domain.entities.Jugada
import com.example.piedrapapeltijera.domain.entities.ResultadoRonda
import com.example.piedrapapeltijera.domain.usecases.CalcularResultadoRonda
import com.example.piedrapapeltijera.domain.usecases.GenerarJugadaIA
import com.example.piedrapapeltijera.domain.usecases.ValidarNombreJugador

/**
 * Repositorio del juego
 *
 * Centraliza el acceso a los casos de uso y coordina la lógica de negocio
 */
class GameRepository {

    // Casos de uso
    private val calcularResultadoRonda = CalcularResultadoRonda()
    private val generarJugadaIA = GenerarJugadaIA()
    private val validarNombreJugador = ValidarNombreJugador()

    /**
     * Valida si un nombre de jugador es válido
     */
    fun esNombreValido(nombre: String): Boolean {
        return validarNombreJugador(nombre)
    }

    /**
     * Genera una jugada para la IA
     */
    fun obtenerJugadaIA(): Jugada {
        return generarJugadaIA()
    }

    /**
     * Calcula el resultado de una ronda
     */
    fun calcularResultado(jugadaJugador: Jugada, jugadaIA: Jugada): ResultadoRonda {
        return calcularResultadoRonda(jugadaJugador, jugadaIA)
    }

    /**
     * Procesa una ronda completa y devuelve el nuevo estado
     */
    fun procesarRonda(
        estadoActual: EstadoJuego,
        jugadaJugador: Jugada
    ): EstadoJuego {
        // Si el juego ya terminó, no procesar
        if (estadoActual.juegoTerminado) return estadoActual

        // Generar jugada de la IA
        val jugadaIA = obtenerJugadaIA()

        // Calcular resultado
        val resultado = calcularResultado(jugadaJugador, jugadaIA)

        // Actualizar puntuaciones
        val nuevosPuntosJugador = estadoActual.puntosJugador +
                if (resultado == ResultadoRonda.VICTORIA) 1 else 0
        val nuevosPuntosIA = estadoActual.puntosIA +
                if (resultado == ResultadoRonda.DERROTA) 1 else 0

        // Incrementar ronda
        val nuevaRonda = estadoActual.rondaActual + 1

        // Verificar si terminó el juego
        val terminado = nuevaRonda >= estadoActual.rondasMaximas

        // Retornar nuevo estado
        return estadoActual.copy(
            jugadaJugador = jugadaJugador,
            jugadaIA = jugadaIA,
            resultadoRonda = resultado,
            puntosJugador = nuevosPuntosJugador,
            puntosIA = nuevosPuntosIA,
            rondaActual = nuevaRonda,
            juegoTerminado = terminado
        )
    }
}