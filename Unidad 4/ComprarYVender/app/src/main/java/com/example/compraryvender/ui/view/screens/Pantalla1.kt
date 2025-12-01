package com.example.compraryvender.ui.view.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compraryvender.ui.viewmodel.CompraViewModel

@Composable
fun PantallaElegirProducto(
    viewModel: CompraViewModel,
    onComprar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Selecciona un producto",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(viewModel.productos) { producto ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            viewModel.seleccionarProducto(producto)
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = producto.nombre)
                }
            }
        }

        viewModel.productoSeleccionado?.let { seleccionado ->
            Spacer(modifier = Modifier.height(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Producto: ${seleccionado.nombre}")
                Text("Precio: ${viewModel.precioCompra} créditos")

                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = onComprar) {
                    Text("Comprar")
                }
            }
        }

        if (viewModel.mensajeError.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = viewModel.mensajeError,
                color = MaterialTheme.colorScheme.error
            )
        }
    }
}