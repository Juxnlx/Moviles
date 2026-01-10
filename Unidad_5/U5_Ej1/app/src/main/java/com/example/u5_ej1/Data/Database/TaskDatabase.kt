package com.example.u5_ej1.Data.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.u5_ej1.Data.Dao.TaskDao
import com.example.u5_ej1.domain.entities.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
