package com.example.loteria.ui.vistas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loteria.ui.viewmodel.LoteriaViewModel

@Composable
fun PantallaResultado(
    viewModel: LoteriaViewModel,
    onJugarDeNuevo: () -> Unit,
    onSalir: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Número ganador: ${viewModel.numeroGanador.value}", fontSize = 36.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text("Saldo: ${viewModel.saldo.value}", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(32.dp))

        Button( onClick = {
            viewModel.reiniciarApuesta()
            onJugarDeNuevo()
        }) {
            Text("Jugar de nuevo")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button( onClick = {
            viewModel.reiniciarTodo()
            onSalir()
        }) {
            Text("Salir")
        }

    }
}