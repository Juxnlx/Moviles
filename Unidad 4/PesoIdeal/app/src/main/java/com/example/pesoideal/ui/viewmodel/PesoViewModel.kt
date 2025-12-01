package com.example.pesoideal.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PesoViewModel : ViewModel() {

    var nombre = mutableStateOf("")
        private set

    var peso = mutableStateOf(0f)
        private set

    var sexo = mutableStateOf("")
        private set

    var altura = mutableStateOf(0)
        private set

    fun actualizarNombre(n: String) {
        nombre.value = n
    }

    fun actualizarPeso(p: Float) {
        peso.value = p
    }

    fun actualizarSexo(s: String) {
        sexo.value = s
    }

    fun actualizarAltura(a: Int) {
        if (a in 150..220) altura.value = a
    }

    fun calcularIMC() : Float {
        val h = altura.value.toFloat() / 100f
        val coef = if (sexo.value == "Hombre") 1f else 0.95f
        return if (h > 0f) peso.value / (h * h * coef) else 0f
    }

    fun categoriaIMC(): String {
        val imc = calcularIMC()
        return when {
            imc < 18.5f -> "Bajo peso"
            imc in 18.5f..24.9f -> "Peso nromal"
            imc in 25f..29.9f -> "Sobrepeso"
            else -> "Obesidad"
        }
    }

    fun reiniciar() {
        nombre.value = ""
        peso.value = 0f
        sexo.value = ""
        altura.value = 0
    }
}