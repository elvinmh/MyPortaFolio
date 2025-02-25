# Semana 2: Introducción a PySpark

### Introducción y RDDs
- **Arquitectura de Spark:** Conceptos fundamentales de la arquitectura de Spark, incluyendo el Driver, los Executors y el Cluster Manager.
- **RDDs (Resilient Distributed Datasets):** Concepto de RDDs y cómo trabajar con ellos.
- **Transformaciones vs Acciones:** Diferencia clave entre transformaciones (lazy) y acciones (que devuelven datos al driver).
- **Funciones clave:** Uso de `map`, `flatMap`, `filter`, y `collect`.

**Ejemplo:**
```scala
val datos = sc.parallelize(List(1, 2, 3, 4, 5))
val datosDuplicados = datos.map(_ * 2)
val resultado = datosDuplicados.collect()
println(resultado.mkString(", ")) // 2, 4, 6, 8, 10
```

### Encoding de Datos
- **Apache Avro:** Formato compacto y eficiente de serialización de datos.
- **Parquet:** Formato columnar para almacenamiento optimizado.
- **ORC:** Utilizado en entornos cloud, similar a Parquet pero más eficiente en algunos casos.
- **Delta Lake:** Mejora de Parquet con capacidades transaccionales y almacenamiento estructurado.

**Ejemplo:**
```scala
val df = spark.read.json("ruta/datos.json")
df.write.format("avro").save("ruta/datos.avro")
val avroDF = spark.read.format("avro").load("ruta/datos.avro")
avroDF.show()
```

### DataFrames y Spark SQL
- **Creación de Spark Session:** Uso de `SparkSession.builder()`.
- **DataFrames API:** Operaciones básicas sobre DataFrames.
- **Bucketizado y Particionamiento:** Métodos de optimización de consultas.
- **Operaciones OLAP:** Uso de `WINDOW`, `Grouping Sets` y `Rollup` para análisis avanzado de datos.

**Ejemplo:**
```scala
val windowSpec = Window.partitionBy("departamento").orderBy(desc("salario"))
val dfConRanking = datos.withColumn("rango", rank().over(windowSpec))
dfConRanking.show()
```

### Datasets y Encoders
- **Datasets:** Estructuras de datos avanzadas en Spark.
- **Encoders:** Cómo Spark maneja la serialización eficiente de datos en Datasets.
- **Dataset API y uso de Kryo:** Optimización de la serialización con Kryo.

**Ejemplo:**
```scala
case class Persona(nombre: String, edad: Int)
val personasDS = Seq(Persona("Juan", 30), Persona("Ana", 25)).toDS()
personasDS.show()
```

---

Este resumen incluye conceptos clave y ejemplos para facilitar el aprendizaje y comprensión de los temas abordados en la segunda semana.

