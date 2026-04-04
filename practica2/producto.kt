/*
Descripción: Clase Producto con precio y descuento, incluyendo validaciones y cálculo del precio final.
Autor: Cinthia
Fecha creación: 04/04/2026
Fecha última modificación: 04/04/2026
*/

class Producto {
    private var precio: Double = 0.0
    private var descuento: Double = 0.0

    fun setPrecio(valor: Double) {
        if (valor >= 0) {
            precio = valor
        } else {
            println("Precio inválido")
        }
    }

    fun getPrecio(): Double = precio

    fun setDescuento(valor: Double) {
        if (valor in 0.0..100.0) {
            descuento = valor
        } else {
            println("Descuento inválido")
        }
    }

    fun getDescuento(): Double = descuento

    fun calcularPrecioFinal(): Double {
        return precio - (precio * (descuento / 100))
    }
}

fun main() {
    val producto = Producto()

    producto.setPrecio(100.0)
    producto.setDescuento(20.0)

    println("Precio original: ${producto.getPrecio()}")
    println("Descuento: ${producto.getDescuento()}%")
    println("Precio final: ${producto.calcularPrecioFinal()}")
}
