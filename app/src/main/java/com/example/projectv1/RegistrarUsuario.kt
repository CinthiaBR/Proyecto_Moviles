package com.example.projectv1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


class RegistrarUsuario : AppCompatActivity() {
    private lateinit var Auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)
        Auth = FirebaseAuth.getInstance();
        val botonRegistrarUsuario = findViewById<Button>(R.id.btn_ingresarUsuario)
        botonRegistrarUsuario.setOnClickListener {
            registrarUsuario()

        }
        val botonCancelarRegistro = findViewById<Button>(R.id.btn_cancelar_registroUsuario)
        botonCancelarRegistro.setOnClickListener {

            abrirActividad(MainActivity::class.java)
        }

    }
    fun registrarUsuario() {
        var etNombre = findViewById<EditText>(R.id.etNombre)
        val emailUsuario = findViewById<EditText>(R.id.edi_correo)
        val txtFecha = findViewById<EditText>(R.id.txtFecha)
        val editTextTextPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val editTextTextPassword2 = findViewById<EditText>(R.id.editTextTextPassword2)
        val progressBar: ProgressBar = findViewById<ProgressBar>(R.id.pgb_registrar)
        val Nombre = etNombre.getText().toString().trim()
        val correoUsuario = emailUsuario.getText().toString().trim()
        val Fecha = txtFecha.getText().toString().trim()
        val Password = editTextTextPassword.getText().toString().trim()
        val Password2 = editTextTextPassword2.getText().toString().trim()
        if (Nombre.isEmpty()) {
            etNombre.setError("El nombre es necesario")
            etNombre.requestFocus()
            return
        }
        if (correoUsuario.isEmpty()) {
            emailUsuario.setError("El correo es necesario")
            emailUsuario.requestFocus()
            return
        }

        if (Fecha.isEmpty()) {
            txtFecha.setError("La fecha es necesaria")
            txtFecha.requestFocus()
            return
        }
        if (Password.isEmpty()) {
            editTextTextPassword.setError("La clave es necesaria")
            editTextTextPassword.requestFocus()
            return
        }
        if (Password2.isEmpty()) {
            editTextTextPassword.setError("Es necesario confirmar la clave")
            editTextTextPassword2.requestFocus()
            return
        }
        if (Password.length < 6) {
            editTextTextPassword.setError("La contraseña debe contener almenos 6 caracteres")
            editTextTextPassword.requestFocus()
            return

        }
        if (Password2 != Password) {
            editTextTextPassword2.setError("Las contraseñas no coinsiden")
            editTextTextPassword2.requestFocus()
            return
        }
        progressBar.setVisibility(View.VISIBLE)
        Auth.createUserWithEmailAndPassword(correoUsuario,Password)
            .addOnCompleteListener(this){task ->
                if (task.isSuccessful()){
                     val user =  User(Nombre, correoUsuario,Fecha, Password, Password2);
                    FirebaseAuth.getInstance().currentUser?.let {
                        FirebaseDatabase.getInstance().getReference("Users")
                            .child(it.uid)
                            . setValue(user).addOnCompleteListener{

                                if(task.isSuccessful()){
                                    Toast.makeText(this, "USUARIO REGISTRADO EXITOSAMENTE",Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.VISIBLE);
                                    //DIRIGIR A LA VENTANA LOGIN
                                    abrirActividad(MainActivity::class.java)

                                }else{
                                    Toast.makeText(this, "FALLO EL REGISTRO, INTENTALO NUEVAMENTE",Toast.LENGTH_LONG).show();
                                    progressBar.setVisibility(View.GONE);
                                }
                            }
                    }
                }else{
            Toast.makeText(this, "FALLO EL REGISTRO, INTENTALO NUEVAMENTE",Toast.LENGTH_LONG).show();
            progressBar.setVisibility(View.GONE);
        }

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



