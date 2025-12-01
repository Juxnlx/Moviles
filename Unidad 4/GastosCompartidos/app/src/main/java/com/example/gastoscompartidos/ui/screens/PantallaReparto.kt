package com.example.gastoscompartidos.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gastoscompartidos.ui.viewmodel.GastosViewModel

@Composable
fun pantallaReparto(
    viewModel: GastosViewModel,
    onVolver: () -> Unit
)
{
    val total = viewModel.total.value
    val numAmigos = viewModel.numAmigos.value
    val nombres = viewModel.nombres
    val cantidadCadaUno = viewModel.cantidadPorPersona()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

      Text(
          "Resumen de gastos",
          style = MaterialTheme.typography.titleLarge
      )

      Spacer(modifier = Modifier.height(16.dp))

      Text ("Total: $total $")
      Text("Número de amigos: $numAmigos")
      Text("Cantidad por persona: ${"%.3f".format(cantidadCadaUno)}")

      Spacer(modifier = Modifier.height(24.dp))

      Text(
          "Reparto:",
          style = MaterialTheme.typography.titleMedium
      )

      Spacer(modifier = Modifier.height(8.dp))

      nombres.forEach { nombre ->
          Text(". $nombre --> ${"%.2f".format(cantidadCadaUno)} $")
      }

        Button(
            onClick = {
                viewModel.reiniciar()
                onVolver()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}