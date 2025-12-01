package com.example.loteria.presentation.screen


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaSeleccion(onNumberSelected: (Int) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row {
            NumeroButton(1, onNumberSelected)
            NumeroButton(2, onNumberSelected)
            NumeroButton(3, onNumberSelected)
        }

        Row {
            NumeroButton(4, onNumberSelected)
            NumeroButton(5, onNumberSelected)
            NumeroButton(6, onNumberSelected)
        }

        Row {
            NumeroButton(7, onNumberSelected)
            NumeroButton(8, onNumberSelected)
            NumeroButton(9, onNumberSelected)
        }
    }
}

@Composable
fun NumeroButton(num: Int, onClick: (Int) -> Unit) {
    Button(
        onClick = { onClick(num) },
        modifier = Modifier.padding(8.dp)
    ) {
        Text(num.toString())
    }
}

