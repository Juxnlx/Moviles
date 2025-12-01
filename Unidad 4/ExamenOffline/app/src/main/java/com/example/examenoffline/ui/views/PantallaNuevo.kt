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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.examenoffline.ui.viewmodel.EcoHogarViewModel

@Composable
fun PantallaNuevo(
    viewModel: EcoHogarViewModel,
    onGuardar: () -> Unit,
    onCancelar: () -> Unit
) {
    val listaDispositivos = viewModel.dispositivos

    val nombre = viewModel.nuevoNombre.value
    val tipo = viewModel.nuevoTipo.value
    val estado = viewModel.nuevoEstado.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Nuevo Dispositivo", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(25.dp))

        OutlinedTextField(
            value = nombre.toString(),
            onValueChange = { nuevonombre ->
                viewModel.actualizarNombre(nombre)
            },
            label = { Text("Nombre dispositivo")},
                    modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = tipo.toString(),
            onValueChange = { nuevoTipo ->
                viewModel.actualizarTipo(tipo)
            },
            label = { Text("Tipo del dispositivo")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = estado.toString(),
            onValueChange = {
                viewModel.actualizarEstado()
            },
            label = { Text("Introduce 0 (APAGADO) | 1 (ENCENDIDO)")},
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        )

        Button(
            onClick = {
                viewModel.añadirDispositivos(nombre.toString(), tipo.toString(), false)
                onGuardar()
            }
        ) {
            Text("Guardar")
        }

        Button(
            onClick = {
                onCancelar()
            }
        ) {
            Text("Cancelar")
        }

    }
}