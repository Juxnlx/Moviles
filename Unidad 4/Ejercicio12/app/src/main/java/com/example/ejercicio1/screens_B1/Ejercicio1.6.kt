package com.example.ejercicio1.screens_B1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ContadorConLimitesYReinicio(modifier: Modifier = Modifier) {
    var contador by remember { mutableStateOf(0) }

    val maximo = 10
    val minimo = 0

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (contador == maximo) {
            Text(
                text = "¡Máximo alcanzado!",
                color = Color.Red,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        Text(
            text = "$contador"
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.5f),
            // Separa los botones
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            // Botón restar
            Button(
                onClick = {
                    if (contador > minimo) {
                        contador--
                    }
                },
                enabled = contador > minimo
            ) {
                Text("–")
            }


            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
                    if (contador < maximo) {
                        contador++
                    }
                },
                enabled = contador < maximo
            ) {
                Text("+")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                contador = 0
            },

            enabled = contador != 0
        ) {
            Text("Reiniciar")
        }
    }
}
