package com.example.ejercicio1.screens_B1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
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
fun AlternadorDeTema(modifier: Modifier = Modifier) {

    // Controla el estado del switch y el tema.
    var modoOscuroActivo by remember {
        mutableStateOf(false) // Inicialmente en modo claro (false)
    }

    val colorFondo = if (modoOscuroActivo) Color.Black else Color.White
    val colorTexto = if (modoOscuroActivo) Color.White else Color.Black

    // Columna principal que ocupa toda la pantalla y aplica el color de fondo.
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(colorFondo),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = if (modoOscuroActivo) "MODO OSCURO" else "MODO CLARO",
            color = colorTexto
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 20.dp)
        ) {
            Text("Activar Modo Oscuro", color = colorTexto)
            Spacer(modifier = Modifier.width(16.dp))

            Switch(
                checked = modoOscuroActivo,
                // Cambia el estado al alternar el switch
                onCheckedChange = {
                    modoOscuroActivo = it // 'it' es el nuevo valor (true/false)
                }
            )
        }
    }
}
