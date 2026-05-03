/*
Descripción: Data class para representar un contacto.
Autor: Cinthia
Fecha creación: 03/05/2026
Fecha última modificación: 03/05/2026
*/

package com.example.practica6

data class Contacto(
    val nombre: String,
    val telefono: String,
    val favorito: Boolean = false
)
