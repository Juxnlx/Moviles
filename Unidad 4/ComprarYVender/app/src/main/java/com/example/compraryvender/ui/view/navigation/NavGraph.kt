package com.example.compraryvender.ui.view.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compraryvender.ui.view.screens.PantallaComprar
import com.example.compraryvender.ui.view.screens.PantallaElegirProducto
import com.example.compraryvender.ui.view.screens.PantallaVender
import com.example.compraryvender.ui.viewmodel.CompraViewModel

@Composable
fun AppNavigation(viewModel: CompraViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "pantallaElegir"
    ) {

        // Pantalla 1 – Elegir producto
        composable("pantallaElegir") {
            PantallaElegirProducto(
                viewModel = viewModel,
                onComprar = {
                    navController.navigate("pantallaComprar")
                }
            )
        }

        // Pantalla 2 – Comprar producto
        composable("pantallaComprar") {
            PantallaComprar(
                viewModel = viewModel,
                onConfirmar = {
                    navController.navigate("pantallaVender")
                },
                onCancelar = {
                    navController.popBackStack() // vuelve a pantallaElegir
                }
            )
        }

        // Pantalla 3 – Vender productos
        composable("pantallaVender") {
            PantallaVender(
                viewModel = viewModel,
                onVolver = {
                    navController.popBackStack("pantallaElegir", inclusive = false)
                }
            )
        }
    }
}