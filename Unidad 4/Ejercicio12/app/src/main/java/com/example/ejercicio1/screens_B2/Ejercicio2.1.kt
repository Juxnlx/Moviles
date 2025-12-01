package com.example.ejercicio1.screens_B2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejercicio1.ui.theme.Ejercicio1Theme
val listaFrutas = listOf("Manzana", "Pera", "Naranja", "Banana", "Uva")
@Composable
fun ListaDeFrutas(modifier: Modifier = Modifier) {

    LazyColumn(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {

        items(listaFrutas) { frutaActual ->

            FilaFruta(nombre = frutaActual)

            Divider(Modifier.padding(vertical = 8.dp))
        }
    }
}

@Composable
fun FilaFruta(nombre: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {

        Image(
            imageVector = Icons.Default.Star,
            contentDescription = "Ícono de fruta",
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Nombre de la fruta
        Text(text = nombre)
    }
}
