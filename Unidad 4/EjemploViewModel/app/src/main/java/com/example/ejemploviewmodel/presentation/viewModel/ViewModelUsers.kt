package com.example.ejemploviewmodel.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejemploviewmodel.data.UserRepository
import com.example.ejemploviewmodel.domain.entities.User

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
