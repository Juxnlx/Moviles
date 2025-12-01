package com.example.listacontactos.ui.presentation

import android.provider.ContactsContract
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listacontactos.R
import com.example.listacontactos.data.repositories.Repositorio
import com.example.listacontactos.domain.entities.Contacto

fun obtenerIniciales(name: String): String {
    return name.filter {it.isUpperCase()}
}

@Composable
fun ContactoIniciales(contacto: Contacto, onClick: () -> Unit) {

    val imagenGenero = when (contacto.genero) {
        "M" -> R.drawable.masculino
        "F" -> R.drawable.femenino
        else -> R.drawable.ic_launcher_foreground
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = imagenGenero),
            contentDescription = "Foto contacto",
            modifier = Modifier
                .height(100.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Text(
            text = obtenerIniciales(contacto.name),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactoDetalle(contacto: Contacto, onClick: () -> Unit) {

    val imagenGenero = when (contacto.genero) {
        "M" -> R.drawable.masculino
        "F" -> R.drawable.femenino
        else -> R.drawable.ic_launcher_foreground
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Image(
            painter = painterResource(id = imagenGenero),
            contentDescription = "Foto contacto",
            modifier = Modifier
                .height(100.dp)
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            Text(
                text = contacto.name,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = contacto.phoneNumber,
                fontSize = 20.sp
            )
        }
    }
}
@Composable
fun ContactRow(contacto: Contacto) {
    var mostrarDetalle by remember { mutableStateOf(false) }

    if (mostrarDetalle) {
        ContactoDetalle(contacto = contacto) {
            mostrarDetalle = false
        }
    } else {
        ContactoIniciales(contacto = contacto) {
            mostrarDetalle = true
        }
    }
}

@Composable
fun ContactsScreen(modifier: Modifier = Modifier) {
    val lista = Repositorio.getAllContacts()

    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        androidx.compose.foundation.lazy.LazyColumn(
            modifier = Modifier.padding(innerPadding)
        ) {
            items(lista) { itemContacto ->
                ContactRow(contacto = itemContacto)
            }
        }
    }
}