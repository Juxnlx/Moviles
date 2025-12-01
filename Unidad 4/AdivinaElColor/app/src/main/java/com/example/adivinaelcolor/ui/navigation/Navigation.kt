package com.example.adivinaelcolor.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.adivinaelcolor.ui.viewmodel.ColorViewModel
import com.example.adivinaelcolor.ui.views.PantallaElegirColor
import com.example.adivinaelcolor.ui.views.PantallaFin
import com.example.adivinaelcolor.ui.views.PantallaResultado

@Composable
fun AppNavigation(viewModel: ColorViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "pantallaElegir") {

        composable("pantallaElegir") {
            PantallaElegirColor(viewModel) {
                navController.navigate("pantallaResultado")
            }
        }

        composable("pantallaResultado") {
            PantallaResultado(
                viewModel,
                onJugarDeNuevo = { navController.navigate("pantallaElegir") },
                onReiniciar = {
                    viewModel.reiniciar()
                    navController.navigate("pantallaElegir") {
                        popUpTo("pantallaElegir") { inclusive = true }
                    }
                },
                onFin = { navController.navigate("pantallaFin") }
            )
        }

        composable("pantallaFin") {
            PantallaFin(
                viewModel,
                onReiniciar = {
                    viewModel.reiniciar()
                    navController.navigate("pantallaElegir") {
                        popUpTo("pantallaElegir") { inclusive = true }
                    }
                }
            )
        }
    }
}
