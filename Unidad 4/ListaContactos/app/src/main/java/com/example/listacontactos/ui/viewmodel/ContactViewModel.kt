package com.example.listacontactos.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class ContactViewModel: ViewModel() {
    // Estado interno de la lista de contactos
    // MutableStateFlow permite emitir cambios que Compose puede observar.
    private val _contactos = MutableStateFlow<List<ContactEntity>>(emptyList())

    // Estado público solo de lectura
    val contactos: StateFlow<List<ContactEntity>> = _contactos

    // ---------------------------
    // Inicialización
    // ---------------------------
    init {
        cargarContactos() // Carga la lista de contactos al crear el ViewModel
    }

    // ---------------------------
    // Función privada para cargar contactos desde la base de datos
    // ---------------------------
    private fun cargarContactos() {
        // viewModelScope.launch lanza una coroutine que vive mientras el ViewModel exista
        viewModelScope.launch {
            // Se obtiene la lista de contactos desde la DB y se asigna al StateFlow
            _contactos.value = MainActivity.database.contactDao().getAllContacts()
        }
    }

    // ---------------------------
    // Función para agregar un nuevo contacto
    // ---------------------------
    fun agregarContacto(nombre: String, telefono: String) {
        val contacto = ContactEntity(name = nombre, phone = telefono)
        viewModelScope.launch {
            // Inserta el contacto en la base de datos
            MainActivity.database.contactDao().addContact(contacto)
            // Recarga la lista para actualizar la UI
            cargarContactos()
        }
    }

    // ---------------------------
    // Función para actualizar un contacto existente
    // ---------------------------
    fun actualizarContacto(contacto: ContactEntity) {
        viewModelScope.launch {
            // Actualiza el contacto en la DB
            MainActivity.database.contactDao().updateContact(contacto)
            // Recarga la lista para que la UI refleje los cambios
            cargarContactos()
        }
    }

    // ---------------------------
    // Función para eliminar un contacto
    // ---------------------------
    fun eliminarContacto(contacto: ContactEntity) {
        viewModelScope.launch {
            // Borra el contacto de la DB
            MainActivity.database.contactDao().deleteContact(contacto)
            // Recarga la lista para actualizar la UI
            cargarContactos()
        }
    }
}