/*
Descripción: Este es un juego de Piedra, Papel o Tijera contra una computadora.
Autor: Cinthia
Fecha creación: 28/03/2026
Fecha última modificación: 28/03/2026
*/

fun obtenerEleccionComputadora(): String {
    val opciones = listOf("piedra", "papel", "tijera")
    return opciones.random()
}

fun determinarGanador(usuario: String, computadora: String): String {
    return if (usuario == computadora) {
        "Empate"
    } else if (
        (usuario == "piedra" && computadora == "tijera") ||
        (usuario == "papel" && computadora == "piedra") ||
        (usuario == "tijera" && computadora == "papel")
    ) {
        "Ganaste"
    } else {
        "Perdiste"
    }
}

fun main() {
    println("Elige: piedra, papel o tijera")
    val usuario = readln().lowercase()

    val computadora = obtenerEleccionComputadora()

    println("Computadora eligió: $computadora")

    val resultado = determinarGanador(usuario, computadora)

    println("Resultado: $resultado")
}
