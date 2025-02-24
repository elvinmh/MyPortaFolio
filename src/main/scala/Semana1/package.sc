import java.time.Instant

type PassengerName = String
type PassengerAge = Int
type PassengerInfo = (PassengerName, PassengerAge)

// Create a domain model representing trains, schedules, and stations
// Create a case class for a Train
// La case class se utiliza para definir una estructura de datos
case class Train(name: String, capacity: Int, schedule: Schedule, location: Option[GPS] = None)

// Create a case class for a Schedule
// Instant: Representa un instante en el tiempo. Se puede pensar en él como un punto en el tiempo.
case class Schedule(departureTime: Instant, arrivalTime: Instant)

// Create a case class for a TrainSchedule
case class TrainSchedule(schedule: Schedule, stations: List[Station])

// Create a case class for a Station
type ListaOpcionalPasajeros = Option[List[PassengerInfo]]

case class Station(name: String, gpsLocation: GPS, passengers: ListaOpcionalPasajeros = None)

// Usando AnyVal para crear un tipo de dato nuevo
// AnyVal es un trait que se utiliza para crear tipos de datos nuevos en Scala.
// Los tipos de datos creados con AnyVal son más eficientes que los tipos de datos creados con case class.
// A veces se les llama "value classes" porque representan un único valor.
case class TrainId(value: Int) extends AnyVal

case class TrainName(value: String) extends AnyVal

case class TrainCapacity(value: Int) extends AnyVal

// El hecho de que es case class, no hace que nos de automaticamente un implementacion del metodo toString
case class TrainV2(id: TrainId, name: TrainName, capacity: TrainCapacity, schedule: Schedule, location: Option[GPS] = None) {
  override def toString: String = s"TrainV2($id, $name, $capacity, $schedule, $location)" //se utiliza el override, para sobreescribir, ya que en este caso las case class tienen la funcion que queremos sobreescribir

  override def equals(obj: Any): Boolean = obj match {  //Al igula que con el toString,la funcion equals se implementa automaticamente
    case TrainV2(id2, name2, capacity2, schedule2, location2) =>
      (id == id2) && //&& es como and, que se debe cumplir con lo anterior
        (name == name2) &&
        (capacity == capacity2) &&
        (schedule == schedule2)
    // Omitimos la localización porque no es un campo obligatorio: (location == location2)
    case _ => false
  }
}

// objeto tipo Builder
case class TrainBuilder(id: Option[TrainId] = None,
                        name: Option[TrainName] = None,
                        capacity: Option[TrainCapacity] = None,
                        schedule: Option[Schedule] = None,
                        location: Option[GPS] = None
                       ) {

  def withId(id: TrainId): TrainBuilder = this.copy(id = Some(id))

  def withName(name: TrainName): TrainBuilder = this.copy(name = Some(name))

  def withCapacity(capacity: TrainCapacity): TrainBuilder = this.copy(capacity = Some(capacity))

  def withSchedule(schedule: Schedule): TrainBuilder = this.copy(schedule = Some(schedule))

  def withLocation(location: GPS): TrainBuilder = this.copy(location = Some(location))

  def build(): Option[TrainV2] = (id, name, capacity, schedule) match {
    case (Some(i), Some(n), Some(c), Some(s)) => Some(TrainV2(i, n, c, s, location))
    case _ => None // return None if any of the main fields is missing.
  }
}

object TrainBuilder {
  // Ponemos el new para que lo diferencia del objeto TrainBuilder
  def apply(): TrainBuilder = new TrainBuilder()
}

