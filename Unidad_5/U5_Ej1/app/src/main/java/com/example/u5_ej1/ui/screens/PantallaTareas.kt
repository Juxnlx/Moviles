package com.example.u5_ej1.ui.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.u5_ej1.MainActivity
import com.example.u5_ej1.domain.entities.TaskEntity
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun InputTarea(
    nuevaTarea: String,
    onTareaChange: (String) -> Unit,
    onAgregarTarea: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextField(
            value = nuevaTarea,
            onValueChange = onTareaChange,
            label = { Text("Nueva Tarea") },
            modifier = Modifier
                .weight(1f)
                .height(60.dp)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Button(
            onClick = onAgregarTarea,
            shape = CircleShape,
            modifier = Modifier.size(55.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text("+")
        }
    }
}

@Composable
fun ListaTareas(
    listaTareas: List<TaskEntity>,
    onCheckedChange: (Int, Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(1.dp, Color.Gray)
            .padding(12.dp)
    ) {
        Column {
            listaTareas.forEachIndexed { indice, tarea ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 6.dp)
                ) {
                    Checkbox(
                        checked = tarea.isDone,
                        onCheckedChange = { marcado ->
                            onCheckedChange(indice, marcado)
                        }
                    )
                    Text(tarea.name)
                }
            }
        }
    }
}

@Composable
fun ListaTareasApp() {
    var nuevaTarea by remember { mutableStateOf("") }
    val listaTareas = remember { mutableStateListOf<TaskEntity>() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        listaTareas.clear()
        listaTareas.addAll(MainActivity.database.taskDao().getAllTasks())
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        InputTarea(
            nuevaTarea = nuevaTarea,
            onTareaChange = { nuevaTarea = it },
            onAgregarTarea = {
                if (nuevaTarea.isNotBlank()) {
                    val tarea = TaskEntity(name = nuevaTarea, isDone = false)
                    listaTareas.add(tarea)
                    scope.launch {
                        MainActivity.database.taskDao().addTask(tarea)
                    }
                    nuevaTarea = ""
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        ListaTareas(
            listaTareas = listaTareas,
            onCheckedChange = { indice, marcado ->
                val tareaActual = listaTareas[indice]
                val tareaActualizada = tareaActual.copy(isDone = marcado)
                listaTareas[indice] = tareaActualizada
                scope.launch {
                    MainActivity.database.taskDao().updateTask(tareaActualizada)
                }
            }
        )
    }
}







