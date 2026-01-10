package com.example.piedrapapeltijera.domain.usecases

/**
 * Caso de uso: Validar nombre del jugador
 *
 * Encapsula las reglas de validación del nombre
 */
class ValidarNombreJugador {

    /**
     * Ejecuta la validación del nombre
     *
     * @param nombre Nombre a validar
     * @return true si el nombre es válido, false en caso contrario
     */
    operator fun invoke(nombre: String): Boolean {
        return nombre.isNotBlank() && nombre.trim().length >= 2
    }
}