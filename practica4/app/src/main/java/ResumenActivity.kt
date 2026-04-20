/*
Descripción: Muestra resumen del perfil y confirma datos.
Autor: Cinthia
Fecha creación: 19/04/2026
Fecha última modificación: 19/04/2026
*/

package com.example.practica4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ResumenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen)

        val txtResumen = findViewById<TextView>(R.id.txtResumen)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        val usuario = intent.getSerializableExtra("usuario") as Usuario

        txtResumen.text = """
            Nombre: ${usuario.nombre}
            Edad: ${usuario.edad}
            Ciudad: ${usuario.ciudad}
            Correo: ${usuario.correo}
        """.trimIndent()

        btnConfirmar.setOnClickListener {
            setResult(Activity.RESULT_OK, Intent())
            finish()
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }
}
