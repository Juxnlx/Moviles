package com.example.adivinaelcolor.ui.views

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.adivinaelcolor.ui.viewmodel.ColorViewModel

@Composable
fun PantallaElegirColor(
    viewModel: ColorViewModel,
    onContinuar: () -> Unit
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Elige un color", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        viewModel.colores.forEach { color ->
            Button(
                onClick = {
                    viewModel.elegirColor(color)
                    onContinuar()
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.6f)
            ) {
                Text(color)
            }
        }

        Text("Puntos: ${viewModel.puntos.value}  Intentos: ${viewModel.intentos.value}")
    }
}