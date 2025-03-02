package composicion

import org.scalatest.funsuite.AnyFunSuite

class EjemploAndThen03Test extends AnyFunSuite {

  // Definimos tres funciones simples
  val addOne: Int => Int = (x: Int) => x + 1
  val double: Int => Int = (x: Int) => x * 2
  val subtractOne: Int => Int = (x: Int) => x - 1

  // La composición usando `andThen` permite una fácil lectura y comprensión
  val compute: Int => Int = addOne andThen double andThen subtractOne

  test("compute function computes correctly") {
    assert(compute(5) == 11)
    assert(compute(6) == 13)
    assert(compute(7) == 15)
    assert(compute(0) == 1)
    assert(compute(-1) == -1)

  }

}


class EjemploAndThenAvanzado03Test extends AnyFunSuite {

  // Función que incrementa en 1
  val incrementar: Int => Int = (x: Int) => x + 1
  test("Incrementar funciona correctamente") {
    assert(incrementar(5) == 6)
    assert(incrementar(0) == 1)
    assert(incrementar(-1) == 0)
    // Tests en los valores extremos
    //assert(incrementar(Integer.MAX_VALUE) == ???)
    // assert(incrementar(Integer.MIN_VALUE) == ???)
  }

  // Función que multiplica por 2
  val multiplicarPorDos: Int => Int = (x: Int) => x * 2
  test("Multiplicar por 2 funciona correctamente") {
    // ..
    assert(multiplicarPorDos(5) == 10)
    assert(multiplicarPorDos(0) == 0)
    assert(multiplicarPorDos(-1) == -2)
    // Tests en los valores extremos
    //assert(multiplicarPorDos(Integer.MAX_VALUE) == ???)
    // assert(multiplicarPorDos(Integer.MIN_VALUE) == ???)

  }

  // Función que resta 1
  val decrementar: Int => Int = (x: Int) => x - 1

  // Secuencia de operaciones que se van a aplicar
  val operaciones: Seq[Int => Int] = Seq(incrementar, multiplicarPorDos, decrementar)

  // Función que compone una lista de funciones utilizando `andThen`
  // De esta manera puedes reutilizar tanto la función como los tests (esto es a modo de súper mejora)
  def componerOperaciones(ops: Seq[Int => Int]): Int => Int = ops.reduce(_ andThen _)

  // Composición completa de la función usando `componerOperaciones`
  val calcular: Int => Int = componerOperaciones(operaciones)

  // Pruebas para validar que la función `calcular` funciona correctamente
  test("La función calcular realiza los cálculos correctamente") {
    assert(calcular(5) == 11)  // (5 + 1) * 2 - 1 = 11
    assert(calcular(6) == 13) // (6 + 1) * 2 - 1 = 13
    assert(calcular(7) == 15) // (7 + 1) * 2 - 1 = 15
    assert(calcular(0) == 1)  // (0 + 1) * 2 - 1 = 1
    assert(calcular(-1) == -1) // (-1 + 1) * 2 - 1 = -1
  }
}
