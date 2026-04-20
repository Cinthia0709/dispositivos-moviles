/*
Descripción: Se hace la pantalla principal para registrar perfil.
Autor: Cinthia
Fecha creación: 19/04/2026
Fecha última modificación: 19/04/2026
*/

package com.example.practica4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class FormularioActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtEdad: EditText
    private lateinit var edtCiudad: EditText
    private lateinit var edtCorreo: EditText
    private lateinit var btnContinuar: Button

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(
                    this,
                    "Perfil guardado correctamente",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        edtNombre = findViewById(R.id.edtNombre)
        edtEdad = findViewById(R.id.edtEdad)
        edtCiudad = findViewById(R.id.edtCiudad)
        edtCorreo = findViewById(R.id.edtCorreo)
        btnContinuar = findViewById(R.id.btnContinuar)

        if (savedInstanceState != null) {
            edtNombre.setText(savedInstanceState.getString("nombre"))
            edtEdad.setText(savedInstanceState.getString("edad"))
            edtCiudad.setText(savedInstanceState.getString("ciudad"))
            edtCorreo.setText(savedInstanceState.getString("correo"))
        }

        btnContinuar.setOnClickListener {

            val usuario = Usuario(
                edtNombre.text.toString(),
                edtEdad.text.toString(),
                edtCiudad.text.toString(),
                edtCorreo.text.toString()
            )

            val intent = Intent(this, ResumenActivity::class.java)
            intent.putExtra("usuario", usuario)

            launcher.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString("nombre", edtNombre.text.toString())
        outState.putString("edad", edtEdad.text.toString())
        outState.putString("ciudad", edtCiudad.text.toString())
        outState.putString("correo", edtCorreo.text.toString())
    }
}
