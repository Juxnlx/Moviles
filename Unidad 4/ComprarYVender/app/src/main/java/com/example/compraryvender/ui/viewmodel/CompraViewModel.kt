package com.example.compraryvender.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.compraryvender.domain.entities.Producto
import com.example.compraryvender.domain.entities.ProductoComprado
import com.example.compraryvender.domain.usecases.CalcularPrecioCompra
import com.example.compraryvender.domain.usecases.CalcularPrecioVenta

class CompraViewModel (
    private val calcularPrecioCompra: CalcularPrecioCompra,
    private val calcularPrecioVenta: CalcularPrecioVenta,
) : ViewModel() {

    var saldo by mutableStateOf(10)

    val productos = listOf(
        Producto("Mando"),
        Producto("Ratón"),
        Producto("Teclado"),
        Producto("Auriculares"),
        Producto("Libro"),
        Producto("Sudadera"),
    )

    var productoSeleccionado by mutableStateOf<Producto?>(null)
        private set

    var precioCompra by mutableStateOf(0)
        private set

    val inventario = mutableStateListOf<ProductoComprado>()

    var mensajeError by mutableStateOf("")
        private set

    fun seleccionarProducto(producto: Producto) {
        productoSeleccionado = producto
        precioCompra = calcularPrecioCompra.PrecioCompra(producto.precioBase)
        mensajeError = ""
    }

    fun comprarProducto(): Boolean {
        val prod = productoSeleccionado ?: return false // No hay producto seleccionado

        if (saldo < precioCompra) {
            mensajeError = "Saldo insuficiente"
            return false
        }

        val precioVenta = calcularPrecioVenta.PrecioVenta(precioCompra)

        val comprado = ProductoComprado(
            producto = prod,
            precioCompra = precioCompra,
            precioVenta = precioVenta
        )

        inventario.add(comprado)
        saldo -= precioCompra

        productoSeleccionado = null
        precioCompra = 0
        mensajeError = ""

        return true
    }

    fun venderProducto(prod: ProductoComprado): Int {
        if (!inventario.contains(prod)) return 0

        saldo += prod.precioVenta
        inventario.remove(prod)

        return  prod.precioVenta
    }

    fun reiniciar() {
        saldo = 10
        productoSeleccionado = null
        precioCompra = 0
        inventario.clear()
        mensajeError = ""
    }
}