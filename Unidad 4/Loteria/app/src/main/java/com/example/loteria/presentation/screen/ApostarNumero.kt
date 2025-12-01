package com.example.loteria.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaApuesta(
    saldoActual: Int,
    numeroElegido: Int,
    onApostar: (Int) -> Unit
) {

    // Guardamos lo que escribe el usuario en el campo de apuesta.
    // Se inicia vacío.
    var cantidadApuesta by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize() // ocupa toda la pantalla
            .padding(24.dp),
        verticalArrangement = Arrangement.Center, // centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally // centra horizontalmente
    ) {

        // Saldo actual del jugador.
        Text(
            text = "Saldo actual: $saldoActual créditos",
            fontSize = 20.sp
        )

        Spacer(Modifier.height(16.dp))

        // Muestra el número que el usuario eligió en la pantalla anterior.
        Text(
            text = "Número elegido: $numeroElegido",
            fontSize = 22.sp
        )

        Spacer(Modifier.height(24.dp))

        // Campo de texto para que el usuario escriba la cantidad a apostar.
        OutlinedTextField(
            value = cantidadApuesta,
            onValueChange = { cantidadApuesta = it },
            label = { Text("Cantidad a apostar") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(0.6f)
        )

        Spacer(Modifier.height(24.dp))

        // Botón para confirmar la apuesta.
        Button(
            onClick = {
                // Convertimos el texto a número entero.
                val apuestaInt = cantidadApuesta.toIntOrNull() ?: 0

                // Solo permitimos apostar entre 1 y el saldo actual.
                if (apuestaInt in 1..saldoActual) {
                    onApostar(apuestaInt)
                }
            }
        ) {
            Text("Apostar")
        }
    }
}

