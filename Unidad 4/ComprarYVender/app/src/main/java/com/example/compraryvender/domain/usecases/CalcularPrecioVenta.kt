package com.example.compraryvender.domain.usecases

import kotlin.random.Random

class CalcularPrecioVenta {

    fun PrecioVenta(precioCompra: Int): Int {
        val variacion = Random.nextFloat() * 0.2f - 0.1f
        val precioFinal = precioCompra * (1 + variacion)
        return precioFinal.toInt().coerceAtLeast(1)
    }
}