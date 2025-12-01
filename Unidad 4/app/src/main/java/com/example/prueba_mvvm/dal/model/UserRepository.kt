package com.example.prueba_mvvm.dal.model

object UserRepository {
    val lista = mutableListOf<User>(
        User(id = 1, name = "Ana"),
        User(id = 2, name = "Juan"),
        User(id = 3, name = "Amparo"),
        User(id = 4, name = "Carlos"),
    )

    fun getUsers(): List<User> {
        return lista.toList()
    }

    fun insert(name:String){
        val id= lista.size+1
        val user=User(id, name)
        lista.add(user)
    }
}