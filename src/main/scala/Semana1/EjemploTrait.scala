package Semana1

object EjemploTrait extends App {

  trait Desplazable {
    def mover(x: Int, y: Int): Unit /* podemos observar que no se esta implementando, si se estuviera implementado tendria:
     def mover(x: Int, y: Int): Unit = x cosa, en este caso estamos obligando a la diferente clase que mezclen utilicen este tarin, tendra ellos que
     implemetar la def mover*/
  }
  class Punto(var x: Int, var y: Int) extends Desplazable { //se utiliza extends y solo se puede utilizar una vez
    def mover(nuevaX: Int, nuevaY: Int): Unit = {
      this.x = nuevaX
      this.y = nuevaY
    }
    override def toString: String = s"($x, $y)"
  }
  val punto = new Punto(0, 0)
  println(punto.toString)
  punto.mover(1, 1)
  println(punto.toString)
}


/* Un trait es un tipo de objeto, que es similiar a una interfaz en JAVA, nos permite compartir campos, datos, metodos y funciones
entre diferente clase, tambien permite herencia multiple
 */