/*
Descripción: Este es un programa que evalúa el nivel de rendimiento de un empleado
y calcula el dinero que recibirá según su puntuación.
Autor: Cinthia
Fecha creación: 27/03/2026
Fecha última modificación: 27/03/2026
*/

fun obtenerNivel(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación inválida"
    }
}

fun calcularDinero(salario: Double, puntuacion: Int): Double {
    return salario * (puntuacion / 10.0)
}

fun main() {
    println("Ingrese su salario mensual:")
    val salario = readln().toDouble()

    println("Ingrese su puntuación (0 a 10):")
    val puntuacion = readln().toInt()

    val nivel = obtenerNivel(puntuacion)
    val dinero = calcularDinero(salario, puntuacion)

    println("Nivel de Rendimiento: $nivel")
    println("Cantidad de Dinero Recibido: $${dinero}")
}
