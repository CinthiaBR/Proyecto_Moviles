package com.example.projectv1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView

class categoriasHabitos : AppCompatActivity() {

    companion object{
        var Categoria = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_categorias_habitos)

        val cat1 = findViewById<TextView>(R.id.txtDejarHabito)
        cat1 .setOnClickListener{
            Categoria = cat1.text.toString()
            abrirActividad(FrecuenciaHabito::class.java)}
        val cat2 = findViewById<TextView>(R.id.Meditacion)
        cat2 .setOnClickListener{
            Categoria = cat2.text.toString()
            abrirActividad(FrecuenciaHabito::class.java)}
        val cat3 = findViewById<TextView>(R.id.Estudio)
        cat3 .setOnClickListener{
            Categoria = cat3.text.toString()
            abrirActividad(FrecuenciaHabito::class.java)}
        val cat4 = findViewById<TextView>(R.id.Deportes)
        cat4 .setOnClickListener{
            Categoria = cat4.text.toString()
            abrirActividad(FrecuenciaHabito::class.java)}
        val cat5 = findViewById<TextView>(R.id.Entretenimiento)
        cat5 .setOnClickListener{
            Categoria = cat5.text.toString()
            abrirActividad(FrecuenciaHabito::class.java)}
        val cat6 = findViewById<TextView>(R.id.Social)
        cat6 .setOnClickListener{
            Categoria = cat6.text.toString()
            abrirActividad(FrecuenciaHabito::class.java)}
        val cat7 = findViewById<TextView>(R.id.Salud)
        cat7 .setOnClickListener{
            Categoria = cat7.text.toString()
            abrirActividad(FrecuenciaHabito::class.java)}
        val cat8 = findViewById<TextView>(R.id.Nutricion)
        cat8 .setOnClickListener{
            Categoria = cat8.text.toString()
            abrirActividad(FrecuenciaHabito::class.java)}
        val cat9 = findViewById<TextView>(R.id.Hogar)
        cat9 .setOnClickListener{
            Categoria = cat9.text.toString()
            abrirActividad(FrecuenciaHabito::class.java)}
        val cat10 = findViewById<TextView>(R.id.Trabajo)
        cat10 .setOnClickListener{
            Categoria = cat10.text.toString()
            abrirActividad(FrecuenciaHabito::class.java)}
        val cat11 = findViewById<TextView>(R.id.AireLibre)
        cat11 .setOnClickListener{
            Categoria = cat11.text.toString()
            abrirActividad(FrecuenciaHabito::class.java)}
        val cat12 = findViewById<TextView>(R.id.Otros)
        cat12 .setOnClickListener{
            Categoria = cat12.text.toString()
            abrirActividad(FrecuenciaHabito::class.java)}

        val btnCancelar = findViewById<Button>(R.id.btncancelarCategoria)
        btnCancelar.setOnClickListener {
            abrirActividad(Inicio::class.java)
        }
    }
    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }
}