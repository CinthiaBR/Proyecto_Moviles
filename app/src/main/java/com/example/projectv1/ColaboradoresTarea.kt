package com.example.projectv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class ColaboradoresTarea : AppCompatActivity() {

    companion object{
        var Colaboradores = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_colaboradores_tarea)

        val edOtros = findViewById<EditText>(R.id.et_otros)

        val ch1 = findViewById<CheckBox>(R.id.ch1)
        val ch2 = findViewById<CheckBox>(R.id.ch2)
        val ch3 = findViewById<CheckBox>(R.id.ch3)
        val ch4 = findViewById<CheckBox>(R.id.ch4)
        val ch5 = findViewById<CheckBox>(R.id.ch5)
        val ch6 = findViewById<CheckBox>(R.id.ch6)

        var chA = ""
        var chB = ""
        var chC = ""
        var chD = ""
        var chE = ""
        var chF = ""

        val btnCancelar = findViewById<Button>(R.id.btnConfColaboradores)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmarcolaboradores)

        btnCancelar.setOnClickListener {
            Colaboradores = "Sin Colaboradores"
            abrirActividad(NuevaTarea::class.java)}

        btnConfirmar.setOnClickListener {
            if(ch1.isChecked){
                chA = "Mamá\n"
            }
            if(ch2.isChecked){
                chB = "Papá\n"
            }
            if(ch3.isChecked){
                 chC = "Hijos\n"
            }
            if(ch4.isChecked){
                 chD = "Tío\n"
            }
            if(ch5.isChecked){
                 chE = "Primo\n"
            }
            if(ch6.isChecked){
                 chF = edOtros.text.toString()
            }
            Colaboradores = chA+chB+chC+chD+chE+chF
            abrirActividad(NuevaTarea::class.java) }

    }
    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }
}