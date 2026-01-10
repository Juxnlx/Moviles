package com.example.piedrapapeltijera.ui.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.piedrapapeltijera.data.repositories.GameRepository
import com.example.piedrapapeltijera.domain.entities.EstadoJuego
import com.example.piedrapapeltijera.domain.entities.Jugada

/**
 * ViewModel del juego Piedra-Papel-Tijeras
 *
 * Gestiona el estado de la UI y coordina las acciones del usuario
 * con la capa de dominio a través del repositorio
 */
class GameViewModel : ViewModel() {

    // Repositorio
    private val repository = GameRepository()

    // Estado privado mutable
    private val _estadoJuego = mutableStateOf(EstadoJuego())

    // Estado público de solo lectura
    val estadoJuego: State<EstadoJuego> get() = _estadoJuego

    /**
     * Inicia una nueva partida con el nombre del jugador
     *
     * @param nombreJugador Nombre del jugador
     * @param rondasMaximas Número de rondas a jugar (por defecto 3)
     */
    fun iniciarJuego(nombreJugador: String, rondasMaximas: Int = 3) {
        if (repository.esNombreValido(nombreJugador)) {
            _estadoJuego.value = EstadoJuego(
                nombreJugador = nombreJugador.trim(),
                rondasMaximas = rondasMaximas,
                rondaActual = 0
            )
        }
    }

    /**
     * Procesa una ronda del juego
     *
     * @param jugadaJugador Jugada elegida por el jugador
     */
    fun jugarRonda(jugadaJugador: Jugada) {
        val estadoActual = _estadoJuego.value

        // Usar el repositorio para procesar la ronda
        val nuevoEstado = repository.procesarRonda(estadoActual, jugadaJugador)

        // Actualizar el estado
        _estadoJuego.value = nuevoEstado
    }

    /**
     * Reinicia la partida manteniendo el mismo jugador
     */
    fun reiniciarPartida() {
        val estadoActual = _estadoJuego.value
        _estadoJuego.value = EstadoJuego(
            nombreJugador = estadoActual.nombreJugador,
            rondasMaximas = estadoActual.rondasMaximas
        )
    }

    /**
     * Reinicia completamente el juego (volver al inicio)
     */
    fun nuevoJuego() {
        _estadoJuego.value = EstadoJuego()
    }
}