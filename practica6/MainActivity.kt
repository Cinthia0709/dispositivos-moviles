/*
Descripción: Configura la navegación entre pantallas usando NavHost.
Autor: Cinthia
Fecha creación: 03/05/2026
Fecha última modificación: 03/05/2026
*/

package com.example.practica6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.navigation.compose.*
import com.example.practica6.screens.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "lista"
    ) {

        composable("lista") {
            ListaScreen(navController)
        }

        composable("formulario") {
            FormularioScreen(navController)
        }
    }
}
