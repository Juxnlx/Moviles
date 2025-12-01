package com.example.ejercicio1.screens_B1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

// 1. Define una clase de datos simple para almacenar las citas
data class Cita(val texto: String, val autor: String, val colorFondo: Color)

// 2. Lista de citas predefinidas
val citasFamosas = listOf(
    Cita("La vida es lo que pasa mientras estás ocupado haciendo otros planes.", "John Lennon", Color(0xFFC8E6C9)), // Verde claro
    Cita("Solo hay una forma de evitar las críticas: no hagas nada, no digas nada y no seas nada.", "Aristóteles", Color(0xFFE1BEE7)), // Morado claro
    Cita("Sé el cambio que quieres ver en el mundo.", "Mahatma Gandhi", Color(0xFFFFCCBC)), // Naranja claro
    Cita("El éxito es ir de fracaso en fracaso sin perder el entusiasmo.", "Winston Churchill", Color(0xFFFFF9C4)) // Amarillo claro
)

@Composable
fun GeneradorDeCitas(modifier: Modifier = Modifier) {

    // Se inicializa con una cita aleatoria seleccionada solo una vez.
    var citaActual by remember {
        mutableStateOf(citasFamosas.random())
    }

    // El color del fondo será el de la cita actual
    val colorFondo = citaActual.colorFondo

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorFondo)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Card(
            modifier = Modifier
                .padding(16.dp),
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Cita
                Text(
                    text = "\"${citaActual.texto}\"",
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                // Autor
                Text(
                    text = "- ${citaActual.autor}",
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Botón para cambiar la cita manualmente.
        Button(
            onClick = {
                citaActual = citasFamosas.random()
            }
        ) {
            Text("Cambiar Cita")
        }
    }
}