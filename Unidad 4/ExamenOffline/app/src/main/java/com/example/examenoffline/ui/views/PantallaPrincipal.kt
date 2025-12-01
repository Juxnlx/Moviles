package com.example.examenoffline.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.examenoffline.ui.viewmodel.EcoHogarViewModel

@Composable
fun PantallaPrincipal(
    viewModel: EcoHogarViewModel,
    onModificar: () -> Unit,
    onNuevo: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Juan Luis", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(viewModel.dispositivos) { dispositivo ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .clickable {
                            viewModel.seleccionarDispositivo(dispositivo)
                            onModificar()
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                        Text(text = dispositivo.nombre)
                        Spacer(modifier = Modifier.size(20.dp))
                        Text(text = dispositivo.tipo)
                        Spacer(modifier = Modifier.size(20.dp))
                        Switch(checked = true, onCheckedChange = { dispositivo.estado })
                        Spacer(modifier = Modifier.size(20.dp))
                }
            }
        }

        Button(
            onClick = {
                onNuevo()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Añadir nuevo dispositivo")
        }
    }
}