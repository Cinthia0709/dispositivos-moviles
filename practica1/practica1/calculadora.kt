/*
Descripción: Una calculadora con menú que tenga suma, resta, multiplicación, división.
Autor: Cinthia
Fecha creación: 29/03/2026
Fecha última modificación: 29/03/2026
*/

fun sumar(a: Double, b: Double) = a + b
fun restar(a: Double, b: Double) = a - b
fun multiplicar(a: Double, b: Double) = a * b
fun dividir(a: Double, b: Double): Double {
    return if (b != 0.0) a / b else {
        println("Error: División entre cero")
        0.0
    }
}

fun mostrarMenu() {
    println("==== Menú ====")
    println("1. Suma")
    println("2. Resta")
    println("3. Multiplicación")
    println("4. División")
    println("5. Salir")
}

fun main() {
    var opcion: Int

    do {
        mostrarMenu()
        println("Seleccione una opción:")
        opcion = readln().toInt()

        if (opcion in 1..4) {
            println("Ingrese primer número:")
            val a = readln().toDouble()

            println("Ingrese segundo número:")
            val b = readln().toDouble()

            val resultado = when (opcion) {
                1 -> sumar(a, b)
                2 -> restar(a, b)
                3 -> multiplicar(a, b)
                4 -> dividir(a, b)
                else -> 0.0
            }

            println("Resultado: $resultado")
        } else if (opcion != 5) {
            println("Opción inválida")
        }

    } while (opcion != 5)

    println("Programa finalizado")
}
