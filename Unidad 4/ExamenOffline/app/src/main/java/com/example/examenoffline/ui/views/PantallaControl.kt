package com.example.examenoffline.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examenoffline.ui.viewmodel.EcoHogarViewModel

@Composable
fun PantallaControl(
    viewModel: EcoHogarViewModel,
    onVolver: () -> Unit
) {

    val dispositivo = viewModel.dispositivoSeleccionado

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
            Text("Actualizar Estado Dispositivo", style = MaterialTheme.typography.titleLarge)
            Spacer(modifier = Modifier.height(25.dp))

            Text("Nombre Dispositivo: ${dispositivo?.nombre}")
            Spacer(modifier = Modifier.height(16.dp))
            Text("Tipo Dispositivo: ${dispositivo?.tipo}")
            Spacer(modifier = Modifier.height(16.dp))

            Switch(checked = false, onCheckedChange = { viewModel.actualizarEstado() })

            Button(
                onClick = {
                    onVolver()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver")
            }
    }
}