package com.example.projectv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val btnHabitos = findViewById<Button>(R.id.btn_Hb)
        val btnTarea = findViewById<Button>(R.id.btn_TA)

        btnHabitos.setOnClickListener { abrirActividad(categoriasHabitos::class.java) }
        btnTarea.setOnClickListener { abrirActividad(categoriasTarea::class.java) }


    }

    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }
}