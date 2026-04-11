/*
Descripción: Aplicación que muestra una imagen y al hacer clic muestra un mensaje Toast.
Autor: Cinthia
Fecha creación: 11/04/2026
Fecha última modificación: 11/04/2026
*/

package com.example.practica3

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imagen = findViewById<ImageView>(R.id.miImagen)

        imagen.setOnClickListener {
            Toast.makeText(this, "¡Hiciste clic yeiii!", Toast.LENGTH_SHORT).show()
        }
    }
}
