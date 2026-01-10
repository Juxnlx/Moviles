package com.example.piedrapapeltijera.ui.view.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.piedrapapeltijera.domain.entities.EstadoJuego

/**
 * Pantalla 3: Resultado final
 *
 * Muestra el ganador de la partida y opciones para volver a jugar o salir
 */
@Composable
fun Pantalla3(
    estadoJuego: EstadoJuego,
    onVolverAJugar: () -> Unit,
    onSalir: () -> Unit
) {
    val ganador = estadoJuego.obtenerGanador()
    val esVictoriaJugador = ganador == estadoJuego.nombreJugador
    val esEmpate = ganador == "Empate"

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
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Título del juego
            Text(
                text = "¡PIEDRA, PAPEL TIJERAS!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Card principal con el resultado
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                )
            ) {
                Column(
                    modifier = Modifier.padding(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Icono - usando solo iconos básicos garantizados
                    val iconoActual = when {
                        esVictoriaJugador -> Icons.Default.Star // Victoria: estrella ⭐
                        esEmpate -> Icons.Default.Info // Empate: info ℹ️
                        else -> Icons.Default.Close // Derrota: X ❌
                    }

                    val colorIcono = when {
                        esVictoriaJugador -> Color(0xFFFFD700) // Dorado
                        esEmpate -> Color(0xFFFFA726) // Naranja
                        else -> Color(0xFFE53935) // Rojo
                    }

                    Icon(
                        imageVector = iconoActual,
                        contentDescription = null,
                        modifier = Modifier.size(80.dp),
                        tint = colorIcono
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Texto del resultado
                    Text(
                        text = when {
                            esVictoriaJugador -> "¡VICTORIA!"
                            esEmpate -> "¡EMPATE!"
                            else -> "¡DERROTA!"
                        },
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Black,
                        color = when {
                            esVictoriaJugador -> Color(0xFF4CAF50)
                            esEmpate -> Color(0xFFFFA726)
                            else -> Color(0xFFE53935)
                        },
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Nombre del ganador
                    Text(
                        text = when {
                            esEmpate -> "¡Ha sido un empate reñido!"
                            else -> "¡${ganador?.uppercase()} HA GANADO LA PARTIDA!"
                        },
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1976D2),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Marcador final
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFFF5F5F5)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Resultado Final",
                                fontSize = 16.sp,
                                color = Color.Gray
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "${estadoJuego.nombreJugador}: ${estadoJuego.puntosJugador} - ${estadoJuego.nombreIA}: ${estadoJuego.puntosIA}",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF1976D2),
                                textAlign = TextAlign.Center
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    // Botones
                    Button(
                        onClick = onVolverAJugar,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF4CAF50)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "VOLVER A JUGAR",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    OutlinedButton(
                        onClick = onSalir,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = Color(0xFFE53935)
                        ),
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "SALIR",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}