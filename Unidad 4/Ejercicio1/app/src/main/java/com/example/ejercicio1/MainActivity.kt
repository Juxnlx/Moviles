package com.example.ejercicio1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val usuarioCorrecto = "JuanLu"
    private val contraseñaCorrecta = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botAcceder.setOnClickListener {
            val nombre = binding.textUsuario.text.toString()
            val contraseña = binding.editTextText2.text.toString()

            if (nombre == usuarioCorrecto && contraseña == contraseñaCorrecta) {
                // Si es correcto, abrimos la nueva pantalla
                val intent = Intent(this, WelcomeActivity::class.java)

                //Enviamos el nombre del usuario
                intent.putExtra("nombreUsuario", nombre)

                //Inciamos la nueva pantalla.
                startActivity(intent)
                finish()
            } else {
                // Si es incorrecto, mostramos un mensaje
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("ciclo","Estoy en main onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ciclo","Estoy en main onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ciclo","Estoy en main onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ciclo","Estoy en main onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ciclo","Estoy en main onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ciclo","Estoy en main onDestroy")
    }
}