
type TrainId = Int
type TrainName = String

type PassengerName = String
type PassengerAge = Int
type ListOfPassengerInfo = List[(PassengerName, PassengerAge)] // Usamos un alias de tipo para una lista de tuplas de String e Int

//Lo siguinete es lo mismo, pero con el TyperAlias es más legible

val listOfPassengerInfo1: List[(String, Int)] = List(("Alice", 25), ("Bob", 30), ("Charlie", 35))
val listOfPassengerInfo2: ListOfPassengerInfo = List(("Alice", 25), ("Bob", 30), ("Charlie", 35))

// Definimos un alias de tipo para una función que toma un entero y devuelve un entero
// Esto es equivalente a: type def intToInt(Int): Int = ???
type IntToInt = Int => Int

// Definimos tres funciones simples
val addOne: IntToInt = (x: Int) => x + 1
val double: IntToInt = (x: Int) => x * 2
val subtractOne: IntToInt = (x: Int) => x - 1

// La composición usando `andThen` permite una fácil lectura y comprensión
val compute: IntToInt = addOne andThen double andThen subtractOne



println(s"listOfPassengerInfo1: $listOfPassengerInfo1") // Salida: List((Alice,25), (Bob,30), (Charlie,35)
println(s"listOfPassengerInfo2: $listOfPassengerInfo2") // Salida: List((Alice,25), (Bob,30), (Charlie,35)


println(compute(5)) // Salida: 11
println(compute(6)) // Salida: 13
println(compute(7)) // Salida: 15
println(compute(0)) // Salida:  1
println(compute(-1)) // Salida: -1
