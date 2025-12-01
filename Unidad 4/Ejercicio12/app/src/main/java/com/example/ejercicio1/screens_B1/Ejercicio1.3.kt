package com.example.ejercicio1.screens_B1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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

val frases = listOf(
    "Sigue adelante",
    "Nunca te rindas",
    "El código es poesía",
    "Aprende algo nuevo hoy"
)

@Composable
fun FrasesAleatorias (modifier: Modifier = Modifier) {
    // Se inicializa con una frase aleatoria.
    var fraseActual by remember {
        mutableStateOf(frases.random())
    }

    Column (
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = fraseActual,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = {
                fraseActual = frases.random()
            }
        ) {
            Text("Nueva frase")
        }
    }
}