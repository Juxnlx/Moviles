package com.example.pesoideal.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pesoideal.ui.screens.PantallaAltura
import com.example.pesoideal.ui.screens.PantallaResultado
import com.example.pesoideal.ui.screens.PantallaSexo
import com.example.pesoideal.ui.viewmodel.PesoViewModel

@Composable
fun AppNavigation(viewModel: PesoViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "pantallaSexo"
    ) {

        composable("pantallaSexo") {
            PantallaSexo(
                viewModel = viewModel,
                onContinuar = {
                    navController.navigate("pantallaAltura")
                }
            )
        }

        composable("pantallaAltura") {
            PantallaAltura(
                viewModel = viewModel,
                 onContinuar = {
                    navController.navigate("pantallaResultado")
                }
            )
        }

        composable("pantallaResultado") {
            PantallaResultado(
                viewModel = viewModel,
                onVolverInicio = {
                    navController.navigate("pantallaSexo"){
                        popUpTo("pantallaSexo") { inclusive = true }
                    }
                }
            )
        }
    }

}