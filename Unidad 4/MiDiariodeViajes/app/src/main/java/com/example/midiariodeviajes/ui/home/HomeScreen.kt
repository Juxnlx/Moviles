package com.example.midiariodeviajes.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.midiariodeviajes.data.model.Destino
import com.example.midiariodeviajes.data.model.listaDestinos

@Composable
fun HomeScreen(
    onNavigateToDetail: (destinationId: Int) -> Unit
) {
    val destinos = listaDestinos

    Scaffold(
        topBar = { TopAppBar(title = { Text("Mi Diario de Viajes") }) }

    ) { paddingValues ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ) {
            items(destinos) { destino ->
                DestinationCard(
                    destino = destino,
                    onClick = { onNavigateToDetail(destino.id) }
                )
            }
        }
    }
}

@Composable
fun DestinationCard(destino: Destino, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = destino.name,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = destino.country,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
