/*
Descripción: Sistema de gestión de biblioteca con materiales, usuarios y préstamos.
Autor: Cinthia
Fecha creación: 04/04/2026
Fecha última modificación: 04/04/2026
*/

abstract class Material(
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int
) {
    abstract fun mostrarDetalles()
}

class Libro(
    titulo: String,
    autor: String,
    anio: Int,
    val genero: String,
    val paginas: Int
) : Material(titulo, autor, anio) {

    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $paginas")
    }
}

class Revista(
    titulo: String,
    autor: String,
    anio: Int,
    val issn: String,
    val volumen: Int,
    val numero: Int,
    val editorial: String
) : Material(titulo, autor, anio) {

    override fun mostrarDetalles() {
        println("Revista: $titulo, ISSN: $issn, Vol: $volumen, Nº: $numero, Editorial: $editorial")
    }
}

data class Usuario(
    val nombre: String,
    val apellido: String,
    val edad: Int
)

interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestar(usuario: Usuario, material: Material)
    fun devolver(usuario: Usuario, material: Material)
    fun mostrarDisponibles()
    fun mostrarPrestados(usuario: Usuario)
}

class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val prestamos = mutableMapOf<Usuario, MutableList<Material>>()

    override fun registrarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    override fun registrarUsuario(usuario: Usuario) {
        prestamos[usuario] = mutableListOf()
    }

    override fun prestar(usuario: Usuario, material: Material) {
        if (material in materialesDisponibles) {
            materialesDisponibles.remove(material)
            prestamos[usuario]?.add(material)
            println("Préstamo realizado")
        } else {
            println("Material no disponible")
        }
    }

    override fun devolver(usuario: Usuario, material: Material) {
        if (prestamos[usuario]?.contains(material) == true) {
            prestamos[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("Devolución realizada")
        }
    }

    override fun mostrarDisponibles() {
        println("Materiales disponibles:")
        materialesDisponibles.forEach { it.mostrarDetalles() }
    }

    override fun mostrarPrestados(usuario: Usuario) {
        println("Materiales prestados a ${usuario.nombre}:")
        prestamos[usuario]?.forEach { it.mostrarDetalles() }
    }
}

fun main() {
    val biblioteca = Biblioteca()

    val libro = Libro("Kotlin Básico", "Autor X", 2023, "Programación", 200)
    val revista = Revista("Tech Today", "Editor Y", 2024, "1234-5678", 1, 10, "TechPress")

    val usuario = Usuario("Cinthia", "Perez", 20)

    biblioteca.registrarMaterial(libro)
    biblioteca.registrarMaterial(revista)
    biblioteca.registrarUsuario(usuario)

    biblioteca.mostrarDisponibles()

    biblioteca.prestar(usuario, libro)
    biblioteca.mostrarPrestados(usuario)

    biblioteca.devolver(usuario, libro)
    biblioteca.mostrarDisponibles()
}
