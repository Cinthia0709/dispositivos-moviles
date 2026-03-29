/*
Descripción: Realizamos un juego donde el usuario debe adivinar un número aleatorio entre 1 y 30 en 5 intentos.
Autor: Cinthia
Fecha creación: 29/03/2026
Fecha última modificación: 29/03/2026
*/

fun generarNumero(): Int {
    return (1..30).random()
}

fun jugar() {
    val numeroSecreto = generarNumero()
    var intentos = 5
    var adivinado = false

    while (intentos > 0 && !adivinado) {
        println("Adivina el número (1-30). Intentos restantes: $intentos")
        val intento = readln().toInt()

        if (intento == numeroSecreto) {
            println("🎉 ¡Felicidades! Adivinaste el número")
            adivinado = true
        } else if (intento < numeroSecreto) {
            println("El número es mayor")
        } else {
            println("El número es menor")
        }

        intentos--
    }

    if (!adivinado) {
        println("💀 Game Over. El número era: $numeroSecreto")
    }
}

fun main() {
    jugar()
}
