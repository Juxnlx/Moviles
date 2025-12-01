package com.example.loteria.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaResultado(
    saldoActual: Int,
    numeroElegido: Int,
    cantidadApuesta: Int,
    onJugarDeNuevo: (Int) -> Unit,
    onSalir: () -> Unit
) {
    // Generamos el número ganador, solo una vez.
    val numeroGanador = remember { (1..9).random() }

    // Calculamos el saldo final según si ganó o perdió.
    val saldoFinal = remember(numeroGanador) {
        if (numeroGanador == numeroElegido) saldoActual + cantidadApuesta * 2
        else saldoActual - cantidadApuesta
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Número ganador: $numeroGanador",
            fontSize = 32.sp
        )

        Spacer(Modifier.height(24.dp))

        Text(
            text = if (numeroGanador == numeroElegido) "¡Has ganado!" else "Has perdido",
            fontSize = 24.sp
        )

        Spacer(Modifier.height(16.dp))

        Text(
            text = "Saldo actual: $saldoFinal créditos",
            fontSize = 20.sp
        )

        Spacer(Modifier.height(32.dp))

        // Botón para jugar de nuevo manteniendo el saldo
        Button(
            onClick = { onJugarDeNuevo(saldoFinal) },
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Jugar de nuevo")
        }

        Spacer(Modifier.height(16.dp))

        // Botón para salir y reiniciar saldo
        Button(
            onClick = { onSalir() },
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Salir")
        }
    }
}
