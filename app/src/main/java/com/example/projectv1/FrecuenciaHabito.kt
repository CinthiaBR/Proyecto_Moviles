package com.example.projectv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton

class FrecuenciaHabito : AppCompatActivity() {

    companion object{
        var Frecuencia = " "
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frecuencia_habito)
        val btnAnterior= findViewById<Button>(R.id.id_anterior)
        btnAnterior .setOnClickListener { abrirActividad(categoriasHabitos::class.java) }

        val r1=findViewById<RadioButton>(R.id.rdo_btn_todosLosDias)
        val r2=findViewById<RadioButton>(R.id.btnAlgunasVecesMes)
        val r3=findViewById<RadioButton>(R.id.btnAlgunasVecesMes)


        val btnSiguiente= findViewById<Button>(R.id.btn_siguiente2)
        btnSiguiente .setOnClickListener {
            if (r1.isChecked){
                Frecuencia="Todos lod dias"}
            if (r2.isChecked){
                Frecuencia="Algunos Días"}
            if (r3.isChecked){
                Frecuencia="Algunas veces"}

            abrirActividad(DefinirHabito::class.java) }
    }
    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }
}