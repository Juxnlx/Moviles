package com.example.compraryvender.ui.view.screens

import android.R
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
import androidx.compose.ui.unit.dp
import com.example.compraryvender.ui.viewmodel.CompraViewModel

@Composable
fun PantallaComprar(
    viewModel: CompraViewModel,
    onConfirmar: () -> Unit,
    onCancelar: () -> Unit
) {

    val producto = viewModel.productoSeleccionado
    val precio = viewModel.precioCompra

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Producto: ${producto?.nombre ?: "Error"}")
        Text(text = "Precio de compra: $precio créditos")

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            if (viewModel.comprarProducto()) {
                onConfirmar()
            }
        }) {
            Text("Confirmar compra")
        }

        Button(onClick = onCancelar) {
            Text("Cancelar")
        }

        if (viewModel.mensajeError.isNotEmpty()) {
            Text(
                text = viewModel.mensajeError,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}