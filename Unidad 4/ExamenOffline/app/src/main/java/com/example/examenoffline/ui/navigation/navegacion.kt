package com.example.examenoffline.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.examenoffline.ui.viewmodel.EcoHogarViewModel
import com.example.examenoffline.ui.views.PantallaControl
import com.example.examenoffline.ui.views.PantallaNuevo
import com.example.examenoffline.ui.views.PantallaPrincipal

@Composable
fun AppNavigation(viewModel: EcoHogarViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "pantallaPrincipal"
    ) {

        composable("pantallaPrincipal") {
            PantallaPrincipal(
                viewModel = viewModel,
                onNuevo = {
                    navController.navigate("pantallaNuevo")
                },
                onModificar = {
                    navController.navigate("pantallaControl")
                }
            )
        }

        composable("pantallaNuevo") {
            PantallaNuevo(
                viewModel = viewModel,
                onGuardar = {
                    navController.navigate("pantallaPrincipal")
                },
                onCancelar = {
                    navController.navigate("pantallaPrincipal")
                }
            )
        }

        composable("pantallaControl") {
            PantallaControl(
                viewModel = viewModel,
                onVolver = {
                    navController.navigate("pantallaPrincipal")
                }
            )
        }
    }
}