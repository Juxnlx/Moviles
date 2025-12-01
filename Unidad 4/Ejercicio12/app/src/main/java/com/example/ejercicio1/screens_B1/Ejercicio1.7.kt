package com.example.ejercicio1.screens_B1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CambiadorTamañoTexto(modifier: Modifier = Modifier) {
    var tamanioActual by remember {
        mutableStateOf(20.dp)
    }

    val cambio = 2.dp
    val tamanioMax = 40.dp
    val tamanioMin = 10.dp

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Texto ajustable",
            fontSize = tamanioActual.value.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.SpaceAround
        ) {

            // Botón disminuir tamaño
            Button(
                onClick = {
                    if (tamanioActual > tamanioMin) {
                        tamanioActual -= cambio
                    }
                },
                // Deshabilita el botón si ya está en el tamaño mínimo
                enabled = tamanioActual > tamanioMin
            ) {
                Text("Disminuir tamaño")
            }

            // Botón aumentar tamaño
            Button(
                onClick = {
                    if (tamanioActual < tamanioMax) {
                        tamanioActual += cambio
                    }
                },
                // Deshabilita el botón si ya está en el tamaño mínimo
                enabled = tamanioActual < tamanioMax
            ) {
                Text("Aumentar tamaño")
            }
        }
    }
}