package com.example.examenoffline

// Librerias cargadas. NO BORRAR.
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.examenoffline.ui.navigation.AppNavigation
import com.example.examenoffline.ui.theme.ExamenOfflineTheme
import com.example.examenoffline.ui.viewmodel.EcoHogarViewModel

// Fin de las librerías cargadas. NO BORRAR.

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Creamos el ViewModel
        val viewModel = EcoHogarViewModel()

        setContent {
            ExamenOfflineTheme {
                AppNavigation(viewModel)
            }
        }
    }
}
