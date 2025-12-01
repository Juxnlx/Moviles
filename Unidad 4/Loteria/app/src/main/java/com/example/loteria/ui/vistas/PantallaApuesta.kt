package com.example.loteria.ui.vistas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loteria.ui.viewmodel.LoteriaViewModel

@Composable
fun PantallaApuesta(
    viewModel: LoteriaViewModel,
    onApostar: () -> Unit
) {
    var apuestaInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Saldo: ${viewModel.saldo.value}", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Número elegido: ${viewModel.numeroElegido.value}", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = apuestaInput,
            onValueChange = {apuestaInput = it},
            label = { Text("Cantidad a apostar") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val cantidad = apuestaInput.toIntOrNull() ?: 0
                if (cantidad in 1..viewModel.saldo.value) {
                    viewModel.hacerApuesta(cantidad)
                    viewModel.sortear()
                    onApostar()
                }
            }
        ) {
            Text("Apostar")
        }
    }
}