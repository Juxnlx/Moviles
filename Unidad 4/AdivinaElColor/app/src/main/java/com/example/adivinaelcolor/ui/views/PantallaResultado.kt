package com.example.adivinaelcolor.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adivinaelcolor.ui.viewmodel.ColorViewModel

@Composable
fun PantallaResultado(
    viewModel: ColorViewModel,
    onJugarDeNuevo: () -> Unit,
    onReiniciar: () -> Unit,
    onFin: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(viewModel.mensaje.value, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        if (viewModel.intentos.value > 0) {
            Button(onClick = onJugarDeNuevo) {
                Text("Jugar de nuevo")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = onReiniciar) {
                Text("Reiniciar")
            }
        } else {
            onFin()
        }

        Text("Puntos: ${viewModel.puntos.value}  Intentos: ${viewModel.intentos.value}")
    }
}