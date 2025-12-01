package com.example.pesoideal.ui.screens

import android.R.attr.text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pesoideal.ui.viewmodel.PesoViewModel

@Composable
fun PantallaResultado(
    viewModel: PesoViewModel,
    onVolverInicio: () -> Unit
) {
    val imc = viewModel.calcularIMC()
    val resultado = viewModel.categoriaIMC()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
        text = "Resultado de ${viewModel.nombre.value}",
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text("Sexo: ${viewModel.sexo.value}")
        Text("Peso: ${viewModel.peso.value} kg")
        Text("Altura: ${viewModel.altura.value} cm")

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "IMC: ${String.format("%.2f", imc)}",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text (
            text = "Estado: $resultado",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = when (resultado) {
                "Bajo peso" -> MaterialTheme.colorScheme.error
                "Peso normal" -> MaterialTheme.colorScheme.primary
                "Sobrepeso" -> MaterialTheme.colorScheme.tertiary
                "Obesidad" -> MaterialTheme.colorScheme.error
                else -> MaterialTheme.colorScheme.onBackground
            }
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = {
            viewModel.reiniciar()
            onVolverInicio()
        }) {
            Text("Volver al inicio")
        }
    }
}