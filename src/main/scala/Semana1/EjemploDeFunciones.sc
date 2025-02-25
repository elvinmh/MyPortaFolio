//import eoi.de.examples.EjemplosDeFunciones.{operacion, sumaAnonima, sumaParcial}
// Las funciones se conocen como elemento de primer orden

/* Las funciones no lambdas son aquellas que definimos con def,
la que no están definidades con def, se concen como funcion lambdas

También la diferencia entre el val y def encontramos es que los val siempre se
van a ejecutar
 */

val a: Int = 4
// Ejemplos avanzados de funciones
// Funciones anónimas (Lambda)
val sumaAnonima: (Int, Int) => Int = (a: Int, b: Int) => a + b
val resultado1: Int = sumaAnonima(2, 3)
println(s"[sumaAnonima] El resultado de la suma es $resultado1")
println()

def myFuncion1(a: Int, b: Int): Int = a + b

// HOF: definicion de alto nivel
def myFuncion2(a: Int, b: Int, function: (Int, Int) => Int): Int = function(a * b, b)

val resultado = myFuncion2(2, 3, myFuncion1) // 9: (2*3) + 3

println(s"[myFuncion2] El resultado de la suma es $resultado")

def operacion(a: Int, b: Int, f: (Int, Int) => Int): Int = f(a, b)

val resultado2 = operacion(2, 3, sumaAnonima)
println(s"[operacion] El resultado de la operación es $resultado2")
println()

// Funciones de orden superior (Higher Order Functions o HOF)
// Función que devuelve otra función
def multiplicarPor(n: Int): Int => Int = (a: Int) => a * n

val multiplicarPor5 = multiplicarPor(5)
val resultado3 = multiplicarPor5(3)
println(s"[multiplicarPor5] El resultado de la multiplicación es $resultado3")
println()

def sumaParcial(a: Int)(b: Int): Int = a + b

val sumaParcialCon2 = sumaParcial(2) _
val resultado4 = sumaParcialCon2(3)
println(s"[sumaParcialCon2] El resultado de la suma es $resultado4")
println()