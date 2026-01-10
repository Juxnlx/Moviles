package com.example.piedrapapeltijera.ui.view.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.piedrapapeltijera.domain.entities.EstadoJuego
import com.example.piedrapapeltijera.domain.entities.Jugada
import com.example.piedrapapeltijera.domain.entities.ResultadoRonda
import com.example.piedrapapeltijera.ui.models.toUI

/**
 * Pantalla 2: Juego principal
 *
 * Muestra la interfaz del juego con tres secciones:
 * - Superior: IA
 * - Central: Marcador y resultado
 * - Inferior: Jugador
 */
@Composable
fun Pantalla2(
    estadoJuego: EstadoJuego,
    onJugadaSeleccionada: (Jugada) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF1976D2),
                        Color(0xFF1565C0)
                    )
                )
            )
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            // Sección superior - IA
            SeccionIA(
                nombreIA = estadoJuego.nombreIA,
                jugadaIA = estadoJuego.jugadaIA,
                modifier = Modifier.weight(1f)
            )

            // Sección central - Resultado
            SeccionResultado(
                estadoJuego = estadoJuego,
                modifier = Modifier.weight(1f)
            )

            // Sección inferior - Jugador
            SeccionJugador(
                nombreJugador = estadoJuego.nombreJugador,
                jugadaJugador = estadoJuego.jugadaJugador,
                onJugadaSeleccionada = onJugadaSeleccionada,
                juegoTerminado = estadoJuego.juegoTerminado,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

/**
 * Sección de la IA
 */
@Composable
fun SeccionIA(
    nombreIA: String,
    jugadaIA: Jugada?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFE53935).copy(alpha = 0.9f)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = nombreIA,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Jugada.entries.forEach { jugada ->
                    IconoJugada(
                        jugada = jugada,
                        seleccionada = jugadaIA == jugada,
                        tint = Color.White,
                        habilitada = false
                    )
                }
            }
        }
    }
}

/**
 * Sección central con resultado y marcador
 */
@Composable
fun SeccionResultado(
    estadoJuego: EstadoJuego,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Marcador
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = estadoJuego.obtenerTextoRonda(),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1976D2)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = estadoJuego.obtenerMarcador(),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1976D2)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Resultado de la ronda
        AnimatedVisibility(
            visible = estadoJuego.resultadoRonda != null,
            enter = scaleIn() + fadeIn(),
            exit = scaleOut() + fadeOut()
        ) {
            estadoJuego.resultadoRonda?.let { resultado ->
                CardResultado(resultado = resultado)
            }
        }
    }
}

/**
 * Card que muestra el resultado de la ronda
 */
@Composable
fun CardResultado(resultado: ResultadoRonda) {
    val (texto, color) = when (resultado) {
        ResultadoRonda.VICTORIA -> "¡Has ganado!" to Color(0xFF4CAF50)
        ResultadoRonda.DERROTA -> "¡Has perdido!" to Color(0xFFE53935)
        ResultadoRonda.EMPATE -> "¡Empate!" to Color(0xFFFFA726)
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(
            text = texto,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
        )
    }
}

/**
 * Sección del jugador
 */
@Composable
fun SeccionJugador(
    nombreJugador: String,
    jugadaJugador: Jugada?,
    onJugadaSeleccionada: (Jugada) -> Unit,
    juegoTerminado: Boolean,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF4CAF50).copy(alpha = 0.9f)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Jugador: $nombreJugador",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Jugada.entries.forEach { jugada ->
                    BotonJugada(
                        jugada = jugada,
                        seleccionada = jugadaJugador == jugada,
                        onClick = { onJugadaSeleccionada(jugada) },
                        habilitada = !juegoTerminado
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Botón Random
            IconButton(
                onClick = { onJugadaSeleccionada(Jugada.random()) },
                enabled = !juegoTerminado,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = if (juegoTerminado) 0.3f else 0.8f))
            ) {
                Icon(
                    imageVector = Icons.Default.Casino,
                    contentDescription = "Random",
                    tint = Color(0xFF4CAF50),
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
}

/**
 * Botón de jugada para el jugador
 */
@Composable
fun BotonJugada(
    jugada: Jugada,
    seleccionada: Boolean,
    onClick: () -> Unit,
    habilitada: Boolean
) {
    val jugadaUI = jugada.toUI()
    val scale by animateFloatAsState(
        targetValue = if (seleccionada) 1.2f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "scale"
    )

    IconButton(
        onClick = onClick,
        enabled = habilitada,
        modifier = Modifier
            .size(72.dp)
            .scale(scale)
            .clip(CircleShape)
            .background(
                if (seleccionada) Color.White
                else Color.White.copy(alpha = if (habilitada) 0.8f else 0.3f)
            )
    ) {
        Icon(
            imageVector = jugadaUI.icono,
            contentDescription = jugadaUI.nombre,
            tint = Color(0xFF4CAF50),
            modifier = Modifier.size(40.dp)
        )
    }
}

/**
 * Icono de jugada (para mostrar, no interactivo)
 */
@Composable
fun IconoJugada(
    jugada: Jugada,
    seleccionada: Boolean,
    tint: Color,
    habilitada: Boolean
) {
    val jugadaUI = jugada.toUI()
    val scale by animateFloatAsState(
        targetValue = if (seleccionada) 1.3f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "scale"
    )

    Box(
        modifier = Modifier
            .size(72.dp)
            .scale(scale)
            .clip(CircleShape)
            .background(
                if (seleccionada) Color.White.copy(alpha = 0.9f)
                else Color.White.copy(alpha = 0.3f)
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = jugadaUI.icono,
            contentDescription = jugadaUI.nombre,
            tint = if (seleccionada) Color(0xFFE53935) else tint.copy(alpha = 0.5f),
            modifier = Modifier.size(40.dp)
        )
    }
}