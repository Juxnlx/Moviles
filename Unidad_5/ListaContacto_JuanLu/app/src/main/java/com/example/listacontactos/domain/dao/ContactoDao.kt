package com.example.listacontactos.domain.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.listacontactos.domain.entities.Contacto
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactoDao {
    @Query("SELECT * FROM contacto_entity ORDER BY name ASC")
    fun getAllContactos(): Flow<List<Contacto>>

    @Insert
    suspend fun addContacto(contacto: Contacto): Long

    @Query("SELECT * FROM contacto_entity WHERE id = :id")
    suspend fun getContactoById(id: Int): Contacto?

    @Update
    suspend fun updateContacto(contacto: Contacto): Int

    @Delete
    suspend fun deleteContacto(contacto: Contacto): Int
}