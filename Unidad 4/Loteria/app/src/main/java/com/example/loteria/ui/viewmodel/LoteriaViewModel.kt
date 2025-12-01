package com.example.loteria.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class LoteriaViewModel: ViewModel() {
    var saldo = mutableStateOf(10)
        private set

    var numeroElegido = mutableStateOf(0)
        private set

    var apuesta = mutableStateOf(0)
        private set

    var numeroGanador = mutableStateOf(0)
        private set

    fun elegirNumero(num: Int) {
        numeroElegido.value = num
    }

    fun hacerApuesta(cantidad: Int) {
        apuesta.value = cantidad
    }

    fun sortear() {
        val ganador = Random.nextInt(1,10)

        if (numeroGanador.value == ganador) {
            saldo.value += apuesta.value * 2
        } else {
            saldo.value -= apuesta.value
        }
    }

    fun reiniciarApuesta() {
        numeroElegido.value = 0
        apuesta.value = 0
        numeroGanador.value = 0
    }

    fun reiniciarTodo() {
        saldo.value = 10
        reiniciarApuesta()
    }
}
