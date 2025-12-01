package com.example.ejemploviewmodel.data

import com.example.ejemploviewmodel.domain.entities.User

object UserRepository {
    private val users = mutableListOf<User>(User(1,"Ana"), User(2, "Juan"))

    fun getUsers(): List<User> {
        return users.toList();
    }

    fun insertUser(user: User){
        users.add(user)

    }


}