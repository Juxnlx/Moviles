package com.example.piedrapapeltijera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.piedrapapeltijera.ui.theme.AppTheme
import com.example.piedrapapeltijera.ui.view.navigation.NavGraph
import com.example.piedrapapeltijera.ui.viewmodel.GameViewModel

/**
 * MainActivity principal
 *
 * Punto de entrada de la aplicación.
 * Configura el tema y el grafo de navegación
 */
class MainActivity : ComponentActivity() {

    // ViewModel de la actividad
    private val gameViewModel: GameViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Grafo de navegación con el ViewModel compartido
                    NavGraph(viewModel = gameViewModel)
                }
            }
        }
    }
}