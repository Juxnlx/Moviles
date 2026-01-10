package com.example.listacontactos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.listacontactos.ui.presentation.ContactsScreen
import com.example.listacontactos.ui.presentation.NuevoContactoScreen
import com.example.listacontactos.ui.theme.ListaContactosTheme
import com.example.listacontactos.ui.viewmodel.ContactosViewModel
import com.example.prueba.data.database.ContactosDatabase

class MainActivity : ComponentActivity() {

    companion object {
        lateinit var database: ContactosDatabase
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar la base de datos
        database = Room.databaseBuilder(
            applicationContext,
            ContactosDatabase::class.java,
            "contactos-db"
        ).build()

        enableEdgeToEdge()
        setContent {
            ListaContactosTheme {
                ContactosApp()
            }
        }
    }
}

@Composable
fun ContactosApp() {
    val navController = rememberNavController()
    val viewModel = ContactosViewModel(MainActivity.database.contactosDao())
    val contactos by viewModel.contactos.collectAsState()

    val modifier: Modifier = Modifier.padding(top = 24.dp)

    NavHost(
        navController = navController,
        startDestination = "VListaContactos"
    ) {
        composable("VListaContactos") {
            ContactsScreen(
                contactos = contactos,
                onNuevoContactoClick = {
                    navController.navigate("VNuevoContacto")
                },
                modifier = modifier
            )
        }

        composable("VNuevoContacto") {
            NuevoContactoScreen(
                onNavigateBack = {
                    navController.popBackStack()
                },
                onGuardarContacto = { nuevoContacto ->
                    viewModel.agregarContacto(nuevoContacto)
                },
                modifier = modifier
            )
        }
    }
}