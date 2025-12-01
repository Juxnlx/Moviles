package com.example.loteria.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.loteria.ui.viewmodel.LoteriaViewModel
import com.example.loteria.ui.vistas.PantallaApuesta
import com.example.loteria.ui.vistas.PantallaResultado
import com.example.loteria.ui.vistas.PantallaSeleccion

@Composable
fun LoteriaNavGraph(viewModel: LoteriaViewModel) {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "pantalla1") {
        composable("pantalla1") {
            PantallaSeleccion(viewModel) {
                navController.navigate("pantalla2")
            }
        }
        composable("pantalla2") {
            PantallaApuesta(viewModel) {
                navController.navigate("pantalla3")
            }
        }
        composable("pantalla3") {
            PantallaResultado(
                viewModel,
                onJugarDeNuevo = { navController.navigate("pantalla1") },
                onSalir = { navController.navigate("pantalla1") }
            )
        }
    }
}
