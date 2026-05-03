/*
Descripción: Muestra la lista de contactos con opciones de favorito y eliminación.
Autor: Cinthia
Fecha creación: 03/05/2026
Fecha última modificación: 03/05/2026
*/

package com.example.practica6.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.practica6.Contacto

@Composable
fun ListaScreen(navController: NavController) {

    var contactos by remember {
        mutableStateOf(
            listOf(
                Contacto("Juan", "999111222"),
                Contacto("Ana", "988777666"),
                Contacto("Luis", "977666555")
            )
        )
    }

    val listaOrdenada = contactos.sortedByDescending { it.favorito }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("formulario") }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) { padding ->

        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.padding(10.dp)
        ) {
            items(listaOrdenada) { contacto ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {
                            Text(contacto.nombre)
                            Text(contacto.telefono)
                        }

                        Row {

                            IconButton(
                                onClick = {
                                    contactos = contactos.map {
                                        if (it == contacto)
                                            it.copy(favorito = !it.favorito)
                                        else it
                                    }
                                }
                            ) {
                                Icon(
                                    if (contacto.favorito)
                                        Icons.Default.Star
                                    else
                                        Icons.Default.StarBorder,
                                    contentDescription = "Favorito"
                                )
                            }

                            IconButton(
                                onClick = {
                                    contactos = contactos.filter { it != contacto }
                                }
                            ) {
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = "Eliminar"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
