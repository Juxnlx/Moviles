package com.example.examenoffline.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.examenoffline.domain.entities.Dispositivo

class EcoHogarViewModel {

    var nombre by mutableStateOf("")

    val dispositivos = mutableListOf<Dispositivo>(
        Dispositivo("Luz Baño", "Luz", false),
        Dispositivo("Luz Salon", "Luz", false),
        Dispositivo("Sensor Cocina", "Sensor", false),
        Dispositivo("Sensor Comedor", "Sensor", false),
        Dispositivo("Riego Jardin", "Riego", false),
        Dispositivo("Detentor Movimiento", "Otro", false),
    )

    var nuevoNombre = mutableStateOf("")


    var nuevoTipo = mutableStateOf("")
        private set

    var nuevoEstado = mutableStateOf(0)
        private set

    var dispositivoSeleccionado by mutableStateOf<Dispositivo?>(null)
        private set

    fun actualizarNombre(nombre: String) {
            nuevoNombre.value = nombre
    }

    fun actualizarTipo(tipo: String) {
        if (tipo == null) return
        nuevoTipo.value = tipo
    }

    fun actualizarEstado(): Boolean {
        val estado: Boolean

        if (nuevoEstado.value < 1) {
            nuevoEstado.value = 1
            estado = true
        } else {
            nuevoEstado.value = 0
            estado = false
        }
        return estado
    }

    fun seleccionarDispositivo(dispositivo: Dispositivo) {
        dispositivoSeleccionado = dispositivo
    }

    fun añadirDispositivos(nombre: String, tipo: String, estado: Boolean) {
        if (nombre == "" || tipo == "") return
        val numDispositivo = dispositivos.size
        val dispositivo = Dispositivo(
            nombre = nombre,
            tipo = tipo,
            estado = actualizarEstado()
        )
        dispositivos.add(dispositivo)
    }

    fun reiniciar() {
        nombre = ""
        dispositivos.clear()
    }
}
