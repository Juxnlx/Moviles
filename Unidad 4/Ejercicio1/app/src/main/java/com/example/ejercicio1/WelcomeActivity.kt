package com.example.ejercicio1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.ejercicio1.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nombre = intent.getStringExtra("nombreUsuario")
        binding.textWelcome.text = "¡Bienvenid@, $nombre!"

        binding.button5.setOnClickListener {
            val textoInfo = binding.editTextText.text.toString().trim()
            abrirGoogle(textoInfo)
        }

        binding.button7.setOnClickListener {
            val textoInfo = binding.editTextText.text.toString().trim()
            abrirTelefono(textoInfo)
        }

        binding.button6.setOnClickListener {
            val textoInfo = binding.editTextText.text.toString().trim()
            enviarSMS(textoInfo)
        }

        binding.button8.setOnClickListener {
            val textoInfo = binding.editTextText.text.toString().trim()
            compartirTexto(textoInfo)
        }
    }

    private fun abrirGoogle(query: String) {
        if (query.isNotEmpty()) {
            val url = "https://www.google.com/search?q=$query"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = url.toUri()
            startActivity(intent)
        } else {
            Toast.makeText(this, "Escribe algo para buscar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun abrirTelefono(numero: String) {
        if (numero.isNotEmpty()) {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = "tel:$numero".toUri()
            startActivity(intent)
        } else {
            Toast.makeText(this, "Escribe un número para llamar", Toast.LENGTH_SHORT).show()
        }
    }

    private fun enviarSMS(numero: String) {
        if (numero.isNotEmpty()) {
            val smsIntent = Intent(Intent.ACTION_VIEW)
            smsIntent.data = Uri.parse("smsto:$numero")
            smsIntent.putExtra("sms_body", "Hola desde mi app")
            startActivity(smsIntent)
        } else {
            Toast.makeText(this, "Escribe un número para enviar SMS", Toast.LENGTH_SHORT).show()
        }
    }

    private fun compartirTexto(texto: String) {
        if (texto.isNotEmpty()) {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, texto)
            startActivity(Intent.createChooser(shareIntent, "Compartir con..."))
        } else {
            Toast.makeText(this, "Escribe algo para compartir", Toast.LENGTH_SHORT).show()
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
