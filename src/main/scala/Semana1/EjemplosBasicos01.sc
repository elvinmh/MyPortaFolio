//import eoi.de.examples.EjemplosBasicos01.suma
import scala.Console.BLACK
import scala.Console.GREEN
import scala.Console.RED
import scala.Console.WHITE
import scala.Console.YELLOW

val mensaje = "Hola mundo"
// val para una variable imutable

var mensajeMutable = "Hola mundo"
mensajeMutable = "Hola mundo 2"
println(mensajeMutable)
// var para una variable mutable, se recomienda utilizar val


// Ejemplo de una función que suma dos números:

def suma(a: Int, b: Int): Int = a + b
/* Lo anterior es lo mismo que:
 def suma(a: Int, b: Int): Int = return (a + b),
 pero, no se usa el return
 */

/* Tambien se puede dejar sin impletar, es decir
colocar lo signos de ???, esto suele utilizarse para estructurar el codigo,
 */
// def sumaV2(a: Int, b: Int): Int = ???

val resultado1 = suma(2, 3)
println(s"[suma] El resultado de la suma es $resultado1")
//Donde s, se utiliza para concatenar, ponemos la variable mas el signo $
/*Si queremos hacer una funcion a la variable se hace de la siguinete manera,
se observa como se ponen dentro de la llava
 */
println(s"[suma] El resultado de la suma es ${resultado1.toLong}")

/* En el siguiente ejemplo como es multilinea se colocan dentro
de llave, aunque hay un cambio en escala 3, que nos permite trabjar
al estilo de python.
 */

def sumaConImpresion(a: Int, b: Int): Int = {
  val resultado = suma(a, b)
  println(s"La suma de $a y $b es $resultado")
  resultado
/*
 Si comentamos resultado es decir en vez de resultado al final
 le ponemos //resultado, nos dara un error, porque hay un error de tipo
 porque println devuelve Unit, es decir vacio, no devuelve nada y le estamos
 dicente que la funcion devuelve un entero
 */
}
//Estilo python:

/*def sumaConImpresion1(a: Int, b: Int): Int:
  val resultadoA = suma(a, b)
  println(s"La suma de $a y $b es $resultadoA")
  resultadoA
  */

def sumaConValorPorDefecto(a: Int, b: Int = 0): Int = a + b

// Especificamos el tipo de la variable para
val resultado3: Int = sumaConValorPorDefecto(5)
println(s"[sumaConValorPorDefecto] El resultado de la suma es $resultado3")

// Ejemplo de una función que suma una lista de números
def sumaLista(lista: List[Int]): Int = lista.sum
val resultado4 = sumaLista(List(1, 2, 3, 4, 5))
println(s"[sumaLista] El resultado de la suma es $resultado4")

// Función que no devuelve nada
def imprimirMensaje(mensaje: String): Unit = println(mensaje)
imprimirMensaje("Hola mundo")

// Imprimir mensaje con colores usando IF
def imprimirMensajeConColorIf(mensaje: String, color: String): Unit = {
  val colorSeleccionado = if (color == "rojo") RED else BLACK
  println(s"$colorSeleccionado$mensaje\u001b[0m")
}
/* \u001b[0m"), es utilizado como caracter especial, para imprimir en color rojo
imprimirMensajeConColorIf("Hola mundo en rojo", "rojo")
*/
imprimirMensajeConColorIf("Hola mundo en rojo", "rojo")

def imprimirMensajeConColorIfElse(mensaje: String, color: String): Unit = {
  val colorSeleccionado =
    if (color == "rojo") RED else if (color == "verde") GREEN else BLACK
  println(s"$colorSeleccionado$mensaje\u001b[0m")
  println()
}
imprimirMensajeConColorIfElse("Hola mundo en verde", "verde")
imprimirMensajeConColorIfElse("Hola mundo en azul", "azul")

// Imprimir mensaje con colores
def imprimirMensajeConColor(mensaje: String, color: String): Unit = {

  val colores =
    Map("rojo" -> RED, "verde" -> GREEN, "amarillo" -> YELLOW, "azul" -> WHITE)
  val colorSeleccionado = colores.getOrElse(color, BLACK) // aquí estamos haciendo colors que es la variable anterior más un get, pero le agregamos el else, porque si no puede fallar si no encuentra el color.
  println(s"$colorSeleccionado$mensaje\u001b[0m")

}
/* Si ponemos el cursor en una variable y luego le damos a
alt intro, ponemos añadir el tipo a la variable automaticamnete, luego que
seleccionamos la opcion add type......
 */
var color = "rojo"
imprimirMensajeConColor(s"Hola mundo en $color", color)
color = "azul clarito"
imprimirMensajeConColor(s"Hola mundo en $color", color)

// Imprimir mensaje con colores usando pattern matching
def imprimirMensajeConColorPatternMatching(mensaje: String, color: String): Unit = {

  val colorSeleccionado = color match {
    case "rojo" => RED // =>, significa devuelve
    case "verde" => GREEN
    case "amarillo" => YELLOW
    case "azul" => WHITE
    case _ => BLACK /* "_" vienen siendo como * que implica todo*/
  }
  println(s"$colorSeleccionado$mensaje\u001b[0m")
}

// TODO: Acabar esta funcion
def funcionSinImplementar(): Unit = ???
// funcionSinImplementar()

/* Si imprimimos la funcionSinImpletar, es decir le quitamos //, nos arroja un error
esto es porque la función no está definida, cuando estamos haciendo esto
se recomienda colocar un comentario como se ve arriba de la def
 */





