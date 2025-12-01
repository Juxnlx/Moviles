package com.example.gastoscompartidos.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gastoscompartidos.ui.viewmodel.GastosViewModel

@Composable
fun pantallaNumeros(
    viewModel: GastosViewModel,
    onContinuar: () -> Unit )
{

    val numAmigos = viewModel.numAmigos.value
    val total = viewModel.total.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            value = numAmigos.toString(),
            onValueChange = {
                val n = it.toIntOrNull() ?: 0
                viewModel.actualizarNumAmigos(n)
            },
            label = { Text("Número de amigos")}
        )

        OutlinedTextField(
           value = total.toString(),
            onValueChange = {
                val t = it.toFloatOrNull() ?: 0f
                viewModel.actualizarTotal(t)
            },
            label = { Text("Total a pagar ($)")}
        )

        Button( onClick = onContinuar) {
            Text("Continuar")
        }
    }
}