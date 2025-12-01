package com.example.compraryvender.ui.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compraryvender.ui.viewmodel.CompraViewModel

@Composable
fun PantallaVender(
    viewModel: CompraViewModel,
    onVolver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Saldo actual: ${viewModel.saldo} créditos",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Inventario:",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(10.dp))

        // Lista NO scrollable
        viewModel.inventario.forEach { productoComprado ->

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {

                    Text("Producto: ${productoComprado.producto.nombre}")
                    Text("Precio venta: ${productoComprado.precioVenta} créditos")

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            viewModel.venderProducto(productoComprado)
                            onVolver()
                        }
                    ) {
                        Text("Vender")
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botón volver sin vender nada
        Button(onClick = onVolver) {
            Text("Volver")
        }
    }
}
