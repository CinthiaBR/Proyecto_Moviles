package com.example.projectv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textViewRegistrarse = findViewById<TextView>(R.id.txt_registrarse)
        val textViewUsuario = findViewById<EditText>(R.id.edit_correo_usuario)
        val textViewClave =findViewById<EditText>(R.id.edit_contraseña)
        val progreso:ProgressBar = findViewById<ProgressBar>(R.id.progressBar1)
        textViewRegistrarse.setOnClickListener { abrirActividad(RegistrarUsuario::class.java) }
        val btnRegistrar = findViewById<TextView>(R.id.txt_registrarse)
        val btnIngresarUsuario = findViewById<Button>(R.id.btn_ingresar_usuario)

        btnRegistrar.setOnClickListener { abrirActividad(RegistrarUsuario::class.java) }
        btnIngresarUsuario.setOnClickListener {

        }


    }

    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }
    fun userLogin(){

    }
}