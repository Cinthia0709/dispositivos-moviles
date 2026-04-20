/*
Descripción: Clase serializable para enviar datos del usuario.
Autor: Cinthia
Fecha creación: 19/04/2026
Fecha última modificación: 19/04/2026
*/

package com.example.practica4

import java.io.Serializable

data class Usuario(
    val nombre: String,
    val edad: String,
    val ciudad: String,
    val correo: String
) : Serializable
