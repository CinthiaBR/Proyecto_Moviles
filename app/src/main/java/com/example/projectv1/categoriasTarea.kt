package com.example.projectv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView

class categoriasTarea : AppCompatActivity() {

    companion object{
        var CategoriaTarea = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_categorias_tarea)
        val btnCancelar = findViewById<Button>(R.id.btncancelarCategoria)
        btnCancelar .setOnClickListener { abrirActividad(NuevaTarea::class.java) }
        val cat1 = findViewById<TextView>(R.id.txtDejarHabito)
        cat1 .setOnClickListener{
            CategoriaTarea = cat1.text.toString()
            abrirActividad(NuevaTarea::class.java)}
        val cat2 = findViewById<TextView>(R.id.Meditacion)
        cat2 .setOnClickListener{
            CategoriaTarea = cat2.text.toString()
            abrirActividad(NuevaTarea::class.java)}
        val cat3 = findViewById<TextView>(R.id.Estudio)
        cat3 .setOnClickListener{
            CategoriaTarea = cat3.text.toString()
            abrirActividad(NuevaTarea::class.java)}
        val cat4 = findViewById<TextView>(R.id.Deportes)
        cat4 .setOnClickListener{
            CategoriaTarea = cat4.text.toString()
            abrirActividad(NuevaTarea::class.java)}
        val cat5 = findViewById<TextView>(R.id.Entretenimiento)
        cat5 .setOnClickListener{
            CategoriaTarea = cat5.text.toString()
            abrirActividad(NuevaTarea::class.java)}
        val cat6 = findViewById<TextView>(R.id.Social)
        cat6 .setOnClickListener{
            CategoriaTarea = cat6.text.toString()
            abrirActividad(NuevaTarea::class.java)}
        val cat7 = findViewById<TextView>(R.id.Salud)
        cat7 .setOnClickListener{
            CategoriaTarea = cat7.text.toString()
            abrirActividad(NuevaTarea::class.java)}
        val cat8 = findViewById<TextView>(R.id.Nutricion)
        cat8 .setOnClickListener{
            CategoriaTarea = cat8.text.toString()
            abrirActividad(NuevaTarea::class.java)}
        val cat9 = findViewById<TextView>(R.id.Hogar)
        cat9 .setOnClickListener{
            CategoriaTarea = cat9.text.toString()
            abrirActividad(NuevaTarea::class.java)}
        val cat10 = findViewById<TextView>(R.id.Trabajo)
        cat10 .setOnClickListener{
            CategoriaTarea = cat10.text.toString()
            abrirActividad(NuevaTarea::class.java)}
        val cat11 = findViewById<TextView>(R.id.AireLibre)
        cat11 .setOnClickListener{
            CategoriaTarea = cat11.text.toString()
            abrirActividad(NuevaTarea::class.java)}
        val cat12 = findViewById<TextView>(R.id.Otros)
        cat12 .setOnClickListener{
            CategoriaTarea = cat12.text.toString()
            abrirActividad(NuevaTarea::class.java)}
    }
    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }
}