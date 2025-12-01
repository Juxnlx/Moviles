package com.example.ejercicio1_jetpackc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio1_jetpackc.ui.theme.Ejercicio1_JetpackCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio1_JetpackCTheme {

                Saludo(
                    texto = "Android",
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(all = 18.dp)
                )

            }
        }
    }
}

@Composable
fun Saludo(texto: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $texto!",
            modifier = modifier.padding(all = 18.dp)
        )
        Text(
            text = "Hello Mundo!",
            modifier = modifier.padding(all = 18.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SaludoPreview() {
    Ejercicio1_JetpackCTheme {
        Saludo("Android")
    }
}