package com.example.pesoideal.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pesoideal.ui.viewmodel.PesoViewModel

@Composable
fun PantallaSexo (
    viewModel: PesoViewModel,
    onContinuar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Ingresa tus datos", fontSize = 26.sp)

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = viewModel.nombre.value,
            onValueChange = {viewModel.actualizarNombre(it)},
            label = {Text("Nombre")}
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = if (viewModel.peso.value == 0f) "" else viewModel.peso.value.toString(),
            onValueChange = {
                val p = it.toFloatOrNull() ?: 0f
                viewModel.actualizarPeso(p)
            },
            label = { Text("Peso (kg)")}
        )

        Spacer(modifier = Modifier.height(25.dp))

        Row {
            Button(
                onClick = {
                    viewModel.actualizarSexo("Hombre")
                    onContinuar()
                }
            ) {
                Text("Hombre")
            }

            Button(
                onClick = {
                    viewModel.actualizarSexo("Mujer")
                    onContinuar()
                }
            ) {
                Text("Mujer")
            }
        }
    }
}