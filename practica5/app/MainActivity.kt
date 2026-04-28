/*
Descripción: Formulario mejorado con Jetpack Compose usando validaciones y componentes interactivos.
Autor: Cinthia
Fecha creación: 27/04/2026
Fecha última modificación: 27/04/2026
*/

package com.example.practica5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    FormularioApp()
                }
            }
        }
    }
}

@Composable
fun FormularioApp() {

    var nombre by remember { mutableStateOf("") }
    var edad by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }

    var genero by remember { mutableStateOf("Masculino") }

    var terminos by remember { mutableStateOf(false) }
    var activo by remember { mutableStateOf(false) }

    var nivel by remember { mutableStateOf(5f) }

    var resultado by remember { mutableStateOf("") }

    val nombreError = nombre.isBlank()
    val edadError = edad.isBlank() || edad.any { !it.isDigit() }
    val correoError = correo.isBlank() || !correo.contains("@")
    val terminosError = !terminos

    val formularioValido =
        !nombreError &&
        !edadError &&
        !correoError &&
        !terminosError

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        Text(
            text = "Registro de Usuario",
            fontSize = 24.sp
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Caracteres: ${nombre.length}",
            fontSize = 12.sp
        )

        if (nombreError) {
            Text("Nombre obligatorio", color = Color.Red)
        }

        OutlinedTextField(
            value = edad,
            onValueChange = { edad = it },
            label = { Text("Edad") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier.fillMaxWidth()
        )

        if (edadError) {
            Text("Edad válida solo números", color = Color.Red)
        }

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth()
        )

        if (correoError) {
            Text("Correo inválido", color = Color.Red)
        }

        Text("Género")

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = genero == "Masculino",
                onClick = { genero = "Masculino" }
            )
            Text("Masculino")

            Spacer(modifier = Modifier.width(10.dp))

            RadioButton(
                selected = genero == "Femenino",
                onClick = { genero = "Femenino" }
            )
            Text("Femenino")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = terminos,
                onCheckedChange = { terminos = it }
            )
            Text("Aceptar términos")
        }

        if (terminosError) {
            Text("Debe aceptar términos", color = Color.Red)
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Activo")
            Spacer(modifier = Modifier.width(10.dp))

            Switch(
                checked = activo,
                onCheckedChange = { activo = it }
            )
        }

        Text("Nivel: ${nivel.toInt()}")

        Slider(
            value = nivel,
            onValueChange = { nivel = it },
            valueRange = 0f..10f
        )

        Button(
            onClick = {
                resultado =
                    "Usuario $nombre, $edad años, $genero, " +
                    if (activo) "activo" else "inactivo" +
                    ", nivel ${nivel.toInt()}"
            },
            enabled = formularioValido,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
        }

        OutlinedButton(
            onClick = {
                nombre = ""
                edad = ""
                correo = ""
                genero = "Masculino"
                terminos = false
                activo = false
                nivel = 5f
                resultado = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Limpiar")
        }

        if (resultado.isNotEmpty()) {
            Text(
                text = resultado,
                color = if (formularioValido) Color(0xFF2E7D32) else Color.Black,
                fontSize = 18.sp
            )
        }
    }
}
