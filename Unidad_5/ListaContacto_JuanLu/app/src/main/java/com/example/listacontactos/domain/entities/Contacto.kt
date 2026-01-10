package com.example.listacontactos.domain.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacto_entity")
data class Contacto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val apellidos: String,
    val phoneNumber: String,
    val imagenId: Int // ID del recurso drawable (R.drawable.imagen1, etc.)
)
