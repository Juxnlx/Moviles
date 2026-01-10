package com.example.listacontactos.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listacontactos.domain.entities.Contacto

@Composable
fun ContactRow(contacto: Contacto, modifier: Modifier = Modifier) {
    var mostrarDetalles by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable { mostrarDetalles = !mostrarDetalles }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Imagen del contacto
            Image(
                painter = painterResource(id = contacto.imagenId),
                contentDescription = "Foto de ${contacto.name}",
                modifier = Modifier
                    .size(70.dp)
                    .padding(end = 16.dp)
            )

            Column(modifier = Modifier.weight(1f)) {
                // Inicial del nombre
                Text(
                    text = contacto.name.firstOrNull()?.uppercase() ?: "",
                    fontSize = 30.sp,
                    color = Color.Black
                )

                // Mostrar detalles si está expandido
                if (mostrarDetalles) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "${contacto.name} ${contacto.apellidos}",
                        fontSize = 20.sp,
                        color = Color.Black
                    )
                    Text(
                        text = contacto.phoneNumber,
                        fontSize = 18.sp,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactsScreen(
    contactos: List<Contacto>,
    onNuevoContactoClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Contactos") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onNuevoContactoClick,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar contacto")
            }
        }
    ) { paddingValues ->
        if (contactos.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No hay contactos.\nPulsa + para agregar uno.",
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                items(contactos) { contacto ->
                    ContactRow(contacto = contacto)
                }
            }
        }
    }
}