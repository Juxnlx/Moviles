package com.example.gastoscompartidos.ui.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

/**
 * Esta clase se encarga de:
 * - Guardar número de amigos, total, lista de nombres.
 * - Expone funciones para actualizar esos valores
 * - Calcula cuánto paga cada persona.
 */
class GastosViewModel: ViewModel() {

    // Números de amigos.
    var numAmigos = mutableStateOf(0)
        private set

    // Total a pagar
    var total = mutableStateOf(0f)
        private set

    //Lista de nombres
    val nombres = mutableStateListOf<String>()

    /**
     * Actualiza el número de amigos y reinicia la lista de nombres
     * para que tenga exactamente n entradas vacias.
     */
    fun actualizarNumAmigos(n: Int) {
        if (n < 0) return
        numAmigos.value = n
        nombres.clear()
        repeat(n) { nombres.add("") }
    }

    /**
     * Actualiza el total (pasamos a float)
     */
    fun actualizarTotal(valor: Float) {
        if (valor < 0f) return
        total.value = valor
    }

    /**
     * Actualiza el nombre en la posición index.
     * Comprueba límites para evitar crash.
     */
    fun actualizarNombre(index: Int, valor: String) {
        if (index < 0 || index >= nombres.size) return
        nombres[index] = valor
    }

    /**
     * Calcula cuánto paga cada persona (0 si no hay ningun amigo)
     */
    fun cantidadPorPersona(): Float {
        val n = numAmigos.value
        return if (n > 0) total.value / n else 0f
    }

    /**
     * Reinicia todo al estado inicial
     */
    fun reiniciar() {
        numAmigos.value = 0
        total.value = 0f
        nombres.clear()
    }
}