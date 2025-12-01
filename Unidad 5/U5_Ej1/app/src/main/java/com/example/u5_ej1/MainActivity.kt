package com.example.u5_ej1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.room.Room
import com.example.u5_ej1.Data.Database.TasksDatabase
import com.example.u5_ej1.ui.screens.ListaTareasApp

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var database: TasksDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        database = Room.databaseBuilder(
            this,
            TasksDatabase::class.java,
            "task-db"
        ).build()
        setContent {
            ListaTareasApp()
        }
    }
}



