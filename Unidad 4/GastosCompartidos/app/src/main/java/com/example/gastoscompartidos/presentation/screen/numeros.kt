package com.example.gastoscompartidos.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun solicitarDatos() {

    var totalGasto by remember { mutableStateOf(value = "") }
    var numAmigos by remember {mutableStateOf(value = "")}

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){

        Text(
            text = "Ingrese el total: ",
            fontSize = 24.sp
        )

        OutlinedTextField(
            value = totalGasto,
            onValueChange = {totalGasto = it},
            label = {Text(text="Cantidad a apostar") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(fraction = 0.6f)
        )

        Spacer(Modifier.height(height = 24.dp))
    }
}
