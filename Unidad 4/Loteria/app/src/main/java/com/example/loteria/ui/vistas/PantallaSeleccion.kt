package com.example.loteria.ui.vistas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.loteria.ui.viewmodel.LoteriaViewModel

@Composable
fun PantallaSeleccion(
    viewModel: LoteriaViewModel,
    onContinuar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (fila in 0..2) {
            Row {
                for (col in 1..3) {
                    val num = fila * 3 + col
                    Button(
                        onClick = {
                            viewModel.elegirNumero(num)
                            onContinuar()
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .size(80.dp)
                    ) {
                        Text(num.toString())
                    }
                }
            }
        }
    }
}