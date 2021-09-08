package com.example.projectv1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class RegistrarUsuario : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    val etNombre = findViewById<EditText>(R.id.etNombre)
    val edi_nombreUsuario = findViewById<EditText>(R.id.edi_nombreUsuario)
    val txtFecha =  findViewById<EditText>(R.id.txtFecha)
    val editTextTextPassword = findViewById<EditText>(R.id.editTextTextPassword)
    val editTextTextPassword2 = findViewById<EditText>(R.id.editTextTextPassword2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)
        mAuth = FirebaseAuth.getInstance();
        val botonRegistrarUsuario = findViewById<Button>(R.id.btn_registrar_usuario)
        val botonCancelarRegistroUsuario = findViewById<Button>(R.id.btn_cancelar_registroUsuario)


    }
    fun registrarUsuario(){
        val etNombre = etNombre.getText().toString().trim()
        val edi_nombreUsuario = edi_nombreUsuario.getText().toString().trim()
        val txtFecha = txtFecha.getText().toString().trim()
        val editTextTextPassword = editTextTextPassword.getText().toString().trim()
        val editTextTextPassword2 = editTextTextPassword2.getText().toString().trim()
        if (etNombre.isEmpty()){
            //etNombre.setError("El nombre es necesario")
        }
        if (edi_nombreUsuario.isEmpty()){
            //etNombre.setError("El nombre es necesario")
        }
        if (txtFecha.isEmpty()){
            //etNombre.setError("El nombre es necesario")
        }
        if (editTextTextPassword.isEmpty()){
            //etNombre.setError("El nombre es necesario")
        }
        if (editTextTextPassword2.isEmpty()){
            //etNombre.setError("El nombre es necesario")
        }


    }
}