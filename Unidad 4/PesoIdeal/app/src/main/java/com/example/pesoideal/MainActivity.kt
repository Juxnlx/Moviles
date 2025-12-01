package com.example.pesoideal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pesoideal.ui.navigation.AppNavigation
import com.example.pesoideal.ui.theme.PesoIdealTheme
import com.example.pesoideal.ui.viewmodel.PesoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PesoIdealTheme {

                // Creamos una superficie para que el tema se aplique bien
                Surface(color = MaterialTheme.colorScheme.background) {

                    // Creamos el ViewModel
                    val viewModel: PesoViewModel = viewModel()

                    // Llamamos a la navegación principal
                    AppNavigation(viewModel)
                }
            }
        }
    }
}