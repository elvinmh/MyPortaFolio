package Semana2

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.catalog.Catalog

import scala.Console.{BOLD, RESET}

object SparkSQLIntro01 extends App {

  import org.apache.spark.sql.SparkSession

  // Crear un SparkSession - Variable de Session
  // SparkSession es el punto de entrada a Spark SQL
  implicit val spark: SparkSession = SparkSession.builder() //Siempre creala como una variable implicidad
    // Nombre de la aplicación tal y como aparecerá en la Spark UI
    .appName("SparkSQLIntro01")
    // Dirección del cluster o "local" para ejecución en local
    // [*] indica que se usarán todos los cores disponibles
    // [2] indica que se usarán 2 cores // usar minimo 2 cores
    .master("local[*]")
    // Crear la SparkSession
    .getOrCreate()

  // Operaciones sobre la sesión de Spark:
  // - setLogLevel: Establece el nivel de log de Spark
  spark.sparkContext.setLogLevel("WARN")

  // - version: Devuelve la versión de Spark
  println(s"Spark version: ${spark.version}")

  // Abrir el Spark UI en el navegador: http://localhost:4040
  //Thread.sleep(30000)  // para que se quede dormida 30 segundo

  // - conf: Devuelve la configuración de Spark
  println(s"Spark conf: ${spark.conf}")
  // Imprimir todas las configuraciones
  // - getAll: Devuelve todas las configuraciones de Spark en forma de Map
  // - foreach: Itera sobre cada configuración
  spark.conf.getAll.foreach(println)
  // Como es un Map, se puede acceder a las configuraciones por clave:
  println(s"Spark conf spark.app.name: ${spark.conf.get("spark.app.name")}")
  // O imprimir todas las configuraciones con su nombre y valor
  spark.conf.getAll.foreach {
    case (k, v) =>
    //println(s"$k: $v")
  }
  println()

  // Para lograr el alineamiento, puedes utilizar la función `padTo` de Scala
  // para hacer que las claves tengan todas la misma longitud.
  // padTo retira o agrega caracteres al final de la cadena hasta alcanzar la longitud especificada
  val maxKeyLength = spark.conf.getAll.map(_._1.length).max + 1
  spark.conf.getAll.foreach {
    case (k, v) =>
      println(s"${k.padTo(maxKeyLength, ' ')} : $v") // La función padTo es muy util, porque muestra como lo mostraría, le damos la linea mas larga y luego no lo muestra tabulado
  }
  println()


  // - sparkContext: Devuelve el SparkContext
  // Esto es necesario para trabajar con RDDs
  // implicit val sqlContext: SQLContext = spark.sqlContext // Deprecated
  println(s"Spark context: ${spark.sparkContext}")
  println()

  // - catalog: Devuelve el catálogo de Spark
  // El catálogo de Spark contiene información sobre las tablas y bases de datos (Diccionario de datos)
  spark.catalog.listDatabases().show(truncate = false)

  // - sql: Ejecuta una consulta SQL
  // Crear un DataFrame a partir de un archivo CSV
  val df: DataFrame = spark.read
    .option("inferSchema", "true")
    .json("src/main/resources/sample_data/employees.json")

  df.printSchema() // También se podría hacer df printSchema y es lo mismo
  df.show(truncate = false)

  df.select("salary").show(truncate = false) // truncate, para que no corte la dirección

//System.exit(0)


  // - sql: Ejecuta una consulta SQL, pero para eso tenemos que registrar la tabla
  // Crear una vista temporal a partir de un DataFrame
  // Existen varios tipos de vistas temporales:
  // - createOrReplaceTempView: Crea una tabla temporal o la reemplaza si ya existe, esta tabla nadie más la puede ver.
  // - createTempView: Crea una vista temporal (si ya existe, lanza una excepción)
  // - createGlobalTempView: Crea una vista temporal global (disponible para todas las sesiones)

  df.createOrReplaceTempView("employees")
  spark.catalog.listDatabases().show(truncate = false)
  spark.catalog.listTables().show(truncate = false)
  print(s"La BD actual es: ${spark.catalog.currentDatabase}")

  //System.exit(0)
  //
  if (!spark.catalog.databaseExists("ejemplo1")) {   // ! = no
    spark.sql("CREATE DATABASE ejemplo1")
  }
  spark.catalog.setCurrentDatabase("ejemplo1")
  println(s"La BD actual es: ${spark.catalog.currentDatabase}")
  println()

  //System.exit(0)
  //
  println(BOLD + "Mostrar las tablas de la BD actual:" + RESET)
  val catalog: Catalog = spark.catalog  // La asiganmos a una variable para mas comodidad
  catalog.listTables().collect().foreach { table =>
    println(table)
    println(s" -- Tabla: ${table.name}")
    catalog.listColumns(table.name).collect().foreach( column =>
        println("    - " + column)
    )
  }
 // System.exit(0)
  // Y finalmente borramos la base de datos creada
  spark.sql("DROP DATABASE ejemplo1 CASCADE")
  //Thread.sleep(600000)
  // - stop: Detiene la sesión de Spark para liberar recursos
  spark.stop()

  // - O: Significa que todo ha ido bien y se puede cerrar la aplicación
  // - Cualquier otro valor significa que ha habido un error
  System.exit(0)
}
 //Antes de borrar la base de Datos podemos encontrarla en la carpeta que se genera spark-warehouse