package com.example.listacontactos.data.repositories

import com.example.listacontactos.domain.entities.ContactEntity

object Repositorio {
    val lista = listOf(
        ContactEntity(id = 2, name = "Laura Martínez", phoneNumber = "622334455", genero = "F"),
        ContactEntity(id = 3, name = "Carlos Pérez", phoneNumber = "678901234", genero = "M"),
        ContactEntity(id = 4, name = "Ana López", phoneNumber = "611223344", genero = "F"),
        ContactEntity(id = 5, name = "David Fernández", phoneNumber = "699887766", genero = "M"),
        ContactEntity(id = 6, name = "María Gómez", phoneNumber = "633445566", genero = "F"),
        ContactEntity(id = 7, name = "Sergio Ruiz", phoneNumber = "655778899", genero = "M"),
        ContactEntity(id = 8, name = "Lucía Hernández", phoneNumber = "612998877", genero = "F"),
        ContactEntity(id = 9, name = "Pablo Torres", phoneNumber = "677665544", genero = "M"),
        ContactEntity(id = 10, name = "Carmen Morales", phoneNumber = "634112233", genero = "F"),
        ContactEntity(id = 11, name = "Raúl Sánchez", phoneNumber = "699223344", genero = "M")
    )

    fun getAllContacts(): List<ContactEntity> {
        return lista
    }
}
