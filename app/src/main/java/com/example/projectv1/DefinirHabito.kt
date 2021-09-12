package com.example.projectv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText

class DefinirHabito : AppCompatActivity() {

    companion object{
        var NombreHab =""
        var DescHab =""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar()?.hide();
        setContentView(R.layout.activity_definir_habito)
        val nombreH = findViewById<EditText>(R.id.etDefinirHabito)
        val descripcionH = findViewById<EditText>(R.id.etDescripcionHabito)

        val btnAnterior= findViewById<Button>(R.id.btn_cancelarCuando)
        btnAnterior .setOnClickListener { abrirActividad(categoriasHabitos::class.java) }
        val btnSiguiente= findViewById<Button>(R.id.btn_confirmarCuando)
        btnSiguiente .setOnClickListener {
            NombreHab = nombreH.text.toString()
            DescHab = descripcionH.text.toString()
            abrirActividad(CuandoQuieresHacerlo::class.java) }
    }

    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }
}