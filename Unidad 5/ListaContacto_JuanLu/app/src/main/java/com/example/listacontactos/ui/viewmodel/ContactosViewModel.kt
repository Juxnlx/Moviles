package com.example.listacontactos.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listacontactos.domain.entities.Contacto
import com.example.listacontactos.domain.dao.ContactoDao
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ContactosViewModel(private val contactoDao: ContactoDao) : ViewModel() {

    private val _contactos = MutableStateFlow<List<Contacto>>(emptyList())
    val contactos: StateFlow<List<Contacto>> = _contactos.asStateFlow()

    init {
        cargarContactos()
    }

    private fun cargarContactos() {
        viewModelScope.launch {
            contactoDao.getAllContactos().collect { listaContactos ->
                _contactos.value = listaContactos
            }
        }
    }

    fun agregarContacto(contacto: Contacto) {
        viewModelScope.launch {
            contactoDao.addContacto(contacto)
        }
    }

    fun eliminarContacto(contacto: Contacto) {
        viewModelScope.launch {
            contactoDao.deleteContacto(contacto)
        }
    }
}