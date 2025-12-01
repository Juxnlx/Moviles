package com.example.gastoscompartidos.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gastoscompartidos.ui.screens.pantallaNumeros
import com.example.gastoscompartidos.ui.screens.pantallaNombres
import com.example.gastoscompartidos.ui.screens.pantallaReparto
import com.example.gastoscompartidos.ui.viewmodel.GastosViewModel

class NavGraph {

    @Composable
    fun AppNavigation(viewModel: GastosViewModel) {

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "pantallaNumeros"
        ) {

            composable("pantallaNumeros") {
                pantallaNumeros(
                    viewModel = viewModel,
                    onContinuar = {
                        navController.navigate("pantallaNombres")
                    }
                )
            }

            composable("pantallaNombres") {
                pantallaNombres(
                    viewModel = viewModel,
                    onContinuar = {
                        navController.navigate("pantallaReparto")
                    }
                )
            }

            composable("pantallaReparto") {
                pantallaReparto(
                    viewModel = viewModel,
                    onVolver = {
                        navController.popBackStack(
                            route = "pantallaNumeros",
                            inclusive = false
                        )
                    }
                )
            }
        }
    }
}
