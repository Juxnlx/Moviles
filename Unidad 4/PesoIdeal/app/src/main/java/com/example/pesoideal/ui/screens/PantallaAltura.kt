package com.example.pesoideal.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pesoideal.ui.viewmodel.PesoViewModel

@Composable
fun PantallaAltura (
    viewModel: PesoViewModel,
    onContinuar: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Selecciona tu altura", fontSize = 26.sp)

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            modifier = Modifier
                .height(200.dp)
        ) {
            items ( (150..220).toList()) { altura ->
                Text(
                    "$altura cm",
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            viewModel.actualizarAltura(altura)
                            onContinuar()
                        }
                        .padding(10.dp)
                )
            }
        }
    }
}