/*
Descripción: Uso de clase abstracta Shape con subclases Cuadrado, Rectángulo y Círculo.
Autor: Cinthia
Fecha creación: 04/04/2026
Fecha última modificación: 04/04/2026
*/

abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

class Cuadrado() : Shape() {
    private var lado: Double = 0.0

    constructor(lado: Double) : this() {
        this.lado = lado
    }

    override fun calcularArea() = lado * lado
    override fun calcularPerimetro() = 4 * lado
}

class Rectangulo() : Shape() {
    private var base: Double = 0.0
    private var altura: Double = 0.0

    constructor(base: Double, altura: Double) : this() {
        this.base = base
        this.altura = altura
    }

    override fun calcularArea() = base * altura
    override fun calcularPerimetro() = 2 * (base + altura)
}

class Circulo() : Shape() {
    private var radio: Double = 0.0

    constructor(radio: Double) : this() {
        this.radio = radio
    }

    override fun calcularArea() = Math.PI * radio * radio
    override fun calcularPerimetro() = 2 * Math.PI * radio
}

fun main() {
    val cuadrado = Cuadrado(4.0)
    val rectangulo = Rectangulo(5.0, 3.0)
    val circulo = Circulo(2.5)

    println("Cuadrado:")
    cuadrado.imprimirResultados()

    println("\nRectángulo:")
    rectangulo.imprimirResultados()

    println("\nCírculo:")
    circulo.imprimirResultados()
}
