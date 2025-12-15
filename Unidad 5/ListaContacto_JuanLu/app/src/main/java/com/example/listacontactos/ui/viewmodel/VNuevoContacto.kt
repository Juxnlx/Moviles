package com.example.listacontactos.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listacontactos.R
import com.example.listacontactos.domain.entities.Contacto

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NuevoContactoScreen(
    onNavigateBack: () -> Unit,
    onGuardarContacto: (Contacto) -> Unit,
    modifier: Modifier = Modifier
) {
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var imagenSeleccionada by remember { mutableIntStateOf(R.drawable.imagen1) }
    var mostrarDialogoImagen by remember { mutableStateOf(false) }

    val imagenesDisponibles = listOf(
        R.drawable.imagen1,
        R.drawable.burranco
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Nuevo Contacto") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) {
                        Icon(Icons.Default.ArrowBack, "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Previsualización de imagen seleccionada
            Card(
                modifier = Modifier
                    .size(120.dp)
                    .clickable { mostrarDialogoImagen = true },
                shape = RoundedCornerShape(60.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = imagenSeleccionada),
                        contentDescription = "Imagen seleccionada",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextButton(onClick = { mostrarDialogoImagen = true }) {
                Text("Cambiar imagen")
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Campo Nombre
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo Apellidos
            OutlinedTextField(
                value = apellidos,
                onValueChange = { apellidos = it },
                label = { Text("Apellidos") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo Teléfono
            OutlinedTextField(
                value = telefono,
                onValueChange = { telefono = it },
                label = { Text("Teléfono") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Botón Guardar
            Button(
                onClick = {
                    if (nombre.isNotBlank() && apellidos.isNotBlank() && telefono.isNotBlank()) {
                        val nuevoContacto = Contacto(
                            name = nombre,
                            apellidos = apellidos,
                            phoneNumber = telefono,
                            imagenId = imagenSeleccionada
                        )
                        onGuardarContacto(nuevoContacto)
                        onNavigateBack()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                enabled = nombre.isNotBlank() && apellidos.isNotBlank() && telefono.isNotBlank()
            ) {
                Text("Guardar Contacto", fontSize = 16.sp)
            }
        }
    }

    // Diálogo para seleccionar imagen
    if (mostrarDialogoImagen) {
        AlertDialog(
            onDismissRequest = { mostrarDialogoImagen = false },
            title = { Text("Seleccionar Imagen") },
            text = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    imagenesDisponibles.forEach { imagenId ->
                        Card(
                            modifier = Modifier
                                .size(100.dp)
                                .clickable {
                                    imagenSeleccionada = imagenId
                                    mostrarDialogoImagen = false
                                }
                                .border(
                                    width = if (imagenId == imagenSeleccionada) 3.dp else 0.dp,
                                    color = if (imagenId == imagenSeleccionada) MaterialTheme.colorScheme.primary else Color.Transparent,
                                    shape = RoundedCornerShape(8.dp)
                                ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Image(
                                painter = painterResource(id = imagenId),
                                contentDescription = "Opción de imagen",
                                modifier = Modifier.fillMaxSize()
                            )
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { mostrarDialogoImagen = false }) {
                    Text("Cerrar")
                }
            }
        )
    }
}