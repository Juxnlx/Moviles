package com.example.piedrapapeltijera.ui.view.navigation

import androidx.compose.runtime.*
import com.example.piedrapapeltijera.ui.view.screens.Pantalla1
import com.example.piedrapapeltijera.ui.view.screens.Pantalla2
import com.example.piedrapapeltijera.ui.view.screens.Pantalla3
import com.example.piedrapapeltijera.ui.viewmodel.GameViewModel

/**
 * Rutas de navegación de la aplicación
 */
enum class Pantalla {
    BIENVENIDA,
    JUEGO,
    RESULTADO
}

/**
 * Grafo de navegación principal
 *
 * Controla qué pantalla se muestra en cada momento
 */
@Composable
fun NavGraph(viewModel: GameViewModel) {
    // Observar el estado del juego
    val estadoJuego by viewModel.estadoJuego

    // Variable de control de navegación
    var pantallaActual by remember { mutableStateOf(Pantalla.BIENVENIDA) }

    // Navegación automática cuando el juego termina
    LaunchedEffect(estadoJuego.juegoTerminado) {
        if (estadoJuego.juegoTerminado) {
            pantallaActual = Pantalla.RESULTADO
        }
    }

    // Mostrar la pantalla correspondiente
    when (pantallaActual) {
        Pantalla.BIENVENIDA -> {
            Pantalla1(
                onIniciarJuego = { nombreJugador ->
                    viewModel.iniciarJuego(nombreJugador, rondasMaximas = 3)
                    pantallaActual = Pantalla.JUEGO
                }
            )
        }

        Pantalla.JUEGO -> {
            Pantalla2(
                estadoJuego = estadoJuego,
                onJugadaSeleccionada = { jugada ->
                    viewModel.jugarRonda(jugada)
                }
            )
        }

        Pantalla.RESULTADO -> {
            Pantalla3(
                estadoJuego = estadoJuego,
                onVolverAJugar = {
                    viewModel.reiniciarPartida()
                    pantallaActual = Pantalla.JUEGO
                },
                onSalir = {
                    viewModel.nuevoJuego()
                    pantallaActual = Pantalla.BIENVENIDA
                }
            )
        }
    }
}