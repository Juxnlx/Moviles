package com.example.compraryvender.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.compraryvender.ui.theme.ComprarYVenderTheme
import com.example.compraryvender.ui.viewmodel.CompraViewModel
import com.example.compraryvender.domain.usecases.CalcularPrecioCompra
import com.example.compraryvender.domain.usecases.CalcularPrecioVenta
import com.example.compraryvender.ui.view.navigation.AppNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Creamos los casos de uso
        val calcularPrecioCompra = CalcularPrecioCompra()
        val calcularPrecioVenta = CalcularPrecioVenta()

        // Creamos el ViewModel
        val viewModel = CompraViewModel(calcularPrecioCompra, calcularPrecioVenta)

        setContent {
            ComprarYVenderTheme {
                AppNavigation(viewModel)
            }
        }
    }
}