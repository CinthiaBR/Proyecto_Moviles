package com.example.projectv1

import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.util.*

class NuevaTarea : AppCompatActivity() {

    private lateinit var fechaTarea: EditText
    private lateinit var prioridad: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_tarea)

        val botonHoraTarea = findViewById<EditText>(R.id.btn_HoraRecordatorio)
        fechaTarea = findViewById(R.id.btn_fechaTarea)

        fechaTarea.setOnClickListener{ShowDatePickerDialog()}
        prioridad=findViewById(R.id.btn_PrioridadTarea)
        prioridad .setOnClickListener{withItems()}
        val NombreTarea=findViewById<EditText>(R.id.txtNombreTarea)

        botonHoraTarea. setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                botonHoraTarea.setText("${hour} : ${minute}")
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
        }

        val Categoria= findViewById<TextView>(R.id.txt_categoria)
        Categoria .setOnClickListener {
            abrirActividad(categoriasTarea::class.java)
        }
        val iconoCategoria= findViewById<ImageButton>(R.id.ib_categoria)
        iconoCategoria .setOnClickListener {
            abrirActividad(categoriasTarea::class.java)
        }
        val btnConfirmar = findViewById<Button>(R.id.btn_confirmarTarea)
        btnConfirmar .setOnClickListener {
            val categoriaTarea = categoriasTarea.CategoriaTarea
            println("$categoriaTarea")
            val nombreT = NombreTarea.text.toString()
            println("$nombreT")
            val fechaT = fechaTarea.text.toString()
            println("$fechaT")
            val horaTarea = botonHoraTarea.text.toString()
            println("$horaTarea")
            val PrioridadTarea = prioridad.text.toString()
            println("$PrioridadTarea")


            /*if (nombreT.isEmpty() ||fechaT.isEmpty() || horaTarea.isEmpty() || PrioridadTarea.isEmpty() ) {
                Toast.makeText(this, "Llene todos los datos", Toast.LENGTH_LONG).show()
            } else {

                // val estado = BaseDeDatos.TablaTarea!!.crearTareaFormulario(1,categoriaTarea, nombreT,fechaT,horaTarea, PrioridadTarea)

                val estado = BaseDeDatos.TablaTarea!!.crearTareaFormulario(3,categoriaTarea,nombreT, fechaT,
                    horaTarea, PrioridadTarea)


                if (estado != null) {
                    Log.i("añadir Tarea", "Datos: ${nombreT} --> ${fechaT} --> ${horaTarea}")

                } else {
                    Toast.makeText(this, "Datos no ingresados", Toast.LENGTH_LONG).show()

                }
            }*/
            abrirActividad(Inicio::class.java) }
    }
    fun abrirActividad(clase: Class<*>){
        val intentExplicito = Intent(
            this,
            clase
        )
        startActivity(intentExplicito)
    }
    fun ShowDatePickerDialog() {
        val datePicker = DatePickerFragment{ day, month, year -> OnDateSelected(day, month, year)}
        datePicker.show(supportFragmentManager, "datePcker")
    }

    fun OnDateSelected(day:Int, month:Int, year:Int){
        fechaTarea.setText("${day}/${month}/${year}")
    }

    fun withItems() {

        val items = arrayOf("Alta", "Normal", "Baja")
        val builder = AlertDialog.Builder(this)
        val Title = SpannableString("                     PRIORIDAD ")

        with(builder)
        {
            //setTitle("PRIORIDAD")
            Title.setSpan(
                ForegroundColorSpan(Color.parseColor("#00D9C4")),
                14,
                Title.length,
                Spannable.SPAN_EXCLUSIVE_INCLUSIVE

            )
            Title.setSpan(
                StyleSpan(Typeface.BOLD),
                8,
                Title.length,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )

            setTitle(Title)
            setItems(items) { dialog, which ->
                Toast.makeText(applicationContext, items[which] + " is clicked", Toast.LENGTH_SHORT).show()
                prioridad.setText("${items[which]}")
            }

            setNegativeButton("CANCELAR", null)
            show()
        }
    }
}