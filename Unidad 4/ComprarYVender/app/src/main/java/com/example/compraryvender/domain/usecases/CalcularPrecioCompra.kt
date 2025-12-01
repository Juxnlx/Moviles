package com.example.compraryvender.domain.usecases

import kotlin.random.Random

class CalcularPrecioCompra {

    fun PrecioCompra(precioBase: Int): Int {
        val variacion = Random.nextFloat() * 0.4f - 0.2f
        val precioFinal = precioBase * (1 + variacion)
        return  precioFinal.toInt().coerceAtLeast(1)
    }
}