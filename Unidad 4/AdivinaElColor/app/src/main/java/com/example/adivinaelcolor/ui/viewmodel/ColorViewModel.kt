/**
 * 💡 Idea de ejercicio: “Adivina el color”
 *
 * Objetivo:
 * El usuario tiene que adivinar un color que la app “elige” aleatoriamente. Tiene un saldo de intentos y puntos según acierta o falla.
 *
 * Pantallas
 *
 * Pantalla 1 (Elegir color)
 *
 * Muestra 6 botones de colores distintos.
 *
 * Usuario elige uno → pasa a Pantalla 2.
 *
 * Pantalla 2 (Resultado)
 *
 * La app genera un color aleatorio.
 *
 * Compara el elegido con el generado.
 *
 * Si acierta → suma 2 puntos, si falla → resta 1 intento.
 *
 * Muestra mensaje: “¡Correcto!” o “Fallaste, el color era X”.
 *
 * Botón “Jugar de nuevo” → vuelve a Pantalla 1 manteniendo puntos y intentos.
 *
 * Botón “Reiniciar” → vuelve a Pantalla 1 con puntos e intentos iniciales.
 *
 * Pantalla 3 (Fin)
 *
 * Si los intentos llegan a 0, muestra “Game Over” y un botón para reiniciar todo.
 *
 * Estados que necesitarías en el ViewModel
 */

package com.example.adivinaelcolor.ui.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ColorViewModel: ViewModel() {

    val colores = listOf("Rojo", "Azul", "Verde", "Amarillo", "Morado", "Naranja")

    val puntos = mutableStateOf(0)
    val intentos = mutableStateOf(10)
    val colorElegido = mutableStateOf<String?>(null)
    val colorGenerado = mutableStateOf<String?>(null)
    val mensaje = mutableStateOf("")

    fun elegirColor(color: String) {
        colorElegido.value = color
        sortearColor()
    }

    fun sortearColor() {
        val generado = colores.random()
        colorGenerado.value = generado

        if (colorElegido.value == generado) {
            puntos.value += 2
            mensaje.value = "¡Correcto! Era $generado"
        } else {
            intentos.value -= 1
            mensaje.value = "Fallaste, era $generado"
        }
    }

    fun reiniciar() {
        puntos.value = 0
        intentos.value = 3
        colorElegido.value = null
        colorGenerado.value = null
        mensaje.value = ""
    }
}