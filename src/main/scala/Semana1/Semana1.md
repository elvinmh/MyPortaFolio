## Semana 1: Fundamentos de Scala

### Instalación y Configuración del Entorno
- Instalación de Scala con Coursier
- Instalación de IntelliJ IDEA
- Introducción a SBT
- Configuración de IntelliJ

### Introducción a la Programación con Scala
- Sintaxis básica
- Tipos de datos
- Estructuras de control

### Funciones en Scala
- Funciones anónimas
- Currying
- High Order Functions (HOF)

### Manejo de `Option`, `TypeAlias` y `package object`
- Uso de `Option` para evitar valores nulos
- Definición de alias de tipos
- Uso de `package object`

#### `package object`
`package object` en Scala permite definir funciones, variables y valores a nivel de paquete, lo que facilita su reutilización sin necesidad de instanciación.

**Ejemplo:**
```scala
package object utils {
  def saludo(nombre: String): String = s"Hola, $nombre!"
  val pi: Double = 3.14159
}

import utils._
println(saludo("Scala")) // Hola, Scala!
println(pi) // 3.14159
```

### Operaciones con Colecciones en Scala
Scala proporciona una API poderosa para trabajar con colecciones, lo que permite escribir código conciso y expresivo. Algunas de las funciones más utilizadas incluyen `map`, `flatMap`, `filter`, `fold`, `reduce` y `groupBy`.

#### `map`
Aplica una función a cada elemento de la colección y devuelve una nueva colección con los resultados.
```scala
val numbers = List(1, 2, 3, 4, 5)
val squaredNumbers = numbers.map(n => n * n)
println(squaredNumbers) // List(1, 4, 9, 16, 25)
```

#### `flatMap`
Similar a `map`, pero aplana los resultados cuando la función aplicada devuelve una colección.
```scala
val words = List("hello", "world")
val chars = words.flatMap(word => word.toList)
println(chars) // List(h, e, l, l, o, w, o, r, l, d)
```

#### `filter`
Filtra los elementos de una colección en función de una condición.
```scala
val evenNumbers = numbers.filter(_ % 2 == 0)
println(evenNumbers) // List(2, 4)
```

#### `fold`
Reduce la colección a un solo valor utilizando una operación binaria.
```scala
val sum = numbers.fold(0)(_ + _)
println(sum) // 15
```

#### `reduce`
Similar a `fold`, pero no requiere un valor inicial.
```scala
val maxNumber = numbers.reduce((a, b) => if (a > b) a else b)
println(maxNumber) // 5
```

#### `groupBy`
Agrupa los elementos de la colección según una clave dada por una función.
```scala
val people = List("Alice", "Bob", "Charlie", "Anna")
val groupedByFirstLetter = people.groupBy(_.head)
println(groupedByFirstLetter)
// Map(A -> List(Alice, Anna), B -> List(Bob), C -> List(Charlie))
```

### Manejo de Errores en Scala
- Uso de `Try`, `Success` y `Failure`
- Manejo de excepciones con `Either` y `Future`

### Traits en Scala
- Definición y uso de traits
- Composición de comportamiento
