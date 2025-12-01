package com.example.ejercicio1.screens_B1

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MiPrimeraUI(modifier: Modifier = Modifier) {

    // Declaración del ESTADO
    var texto by remember {
        mutableStateOf("¡Hola, desconocido!")
    }

    Column(modifier = modifier) {
        Text(text = texto)

        Button(
            onClick = {
                texto = "¡Has presionado el botón!"
            }
        ) {
            Text("Presionar")
        }
    }
}