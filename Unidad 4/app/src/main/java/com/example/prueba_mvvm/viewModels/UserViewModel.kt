package com.example.prueba_mvvm.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import com.example.prueba_mvvm.dal.model.User
import com.example.prueba_mvvm.dal.model.UserRepository

class UserViewModel : ViewModel() {
    private val _repo = UserRepository
    private val _users = MutableLiveData<List<User>>(emptyList())
    val users: State<List<User>> = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        _users.value = _repo.getUsers()
    }
    fun insertUser(user:User){
        _repo.insert(user)
        loadUsers()
    }
}
