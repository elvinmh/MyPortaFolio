## Portfolio: **Scala / PySpark**

Este portafolio representa mi aprendizaje y trabajo con **Scala** y **PySpark**, incluyendo conceptos fundamentales, buenas prácticas y ejemplos aplicados.

---

## Estructura del Proyecto
El portafolio está organizado en diferentes categorías que cubren conceptos clave del desarrollo en Scala y PySpark:

### **Scala**
- `spark.sql`: Contiene ejemplos relacionados con Spark SQL y funciones personalizadas.
- `colecciones`: Contiene ejemplos relacionados con colecciones en Scala.
- `composicion`: Contiene ejemplos sobre la composición de funciones.

### **PySpark**
- `rdds`: Ejemplos del uso del API RDD.
- `dataframes`: Uso de DataFrames y operaciones SQL.
- `datasets`: Uso de Datasets y encoders.
- `olap`: Operaciones avanzadas con OLAP (Window Functions, Grouping Sets, Rollup).
- `storage`: Encoding de datos con Avro, Parquet, ORC y Delta Lake.
- `cluster`: Configuración y despliegue de Spark en clústeres.
- `optimización`: Técnicas de particionamiento, bucketing y optimización de consultas.

---

## Tecnologías

- **Scala**: Lenguaje funcional y orientado a objetos.
- **PySpark**: API de Python para Apache Spark.
- **Apache Spark**: Framework de procesamiento distribuido.
- **Cats**: Librería funcional en Scala.
- **IntelliJ IDEA**: IDE para desarrollo en Scala.
- **Jupyter Notebooks**: Entorno interactivo para PySpark.
- **Docker**: Contenedorización de aplicaciones Spark.

---

## Instalación y Configuración

### **Dependencias**
El proyecto usa las siguientes versiones y herramientas:

- SBT: 1.10.7
- Scala: 2.13.16
- Apache Spark: 3.5.4
- Cats Core: 2.10.0
- Python: >=3.8 (para PySpark)
- Java: 17+

### **Comandos de Ejecución**
Para compilar y ejecutar los proyectos:

#### **Scala**:
```bash
sbt run
```

#### **PySpark**:
```bash
spark-submit script.py
```

#### **Testing**
Los tests están en `src/test/scala` y se pueden ejecutar con:
```bash
sbt test
```

---

## Configuración de Java para Spark en IntelliJ IDEA
Para que Spark funcione en Java 17+, es necesario añadir las siguientes opciones en la configuración de ejecución:

```
--add-opens=java.base/java.lang=ALL-UNNAMED
--add-opens=java.base/java.util=ALL-UNNAMED
--add-opens=java.base/java.io=ALL-UNNAMED
--add-opens=java.base/java.util.concurrent=ALL-UNNAMED
--add-opens=java.base/java.util.concurrent.atomic=ALL-UNNAMED
--add-opens=java.base/java.util.concurrent.locks=ALL-UNNAMED
--add-opens=java.base/java.util.regex=ALL-UNNAMED
--add-opens=java.base/java.util.stream=ALL-UNNAMED
--add-opens=java.base/java.util.function=ALL-UNNAMED
--add-opens=java.base/java.util.jar=ALL-UNNAMED
--add-opens=java.base/java.util.zip=ALL-UNNAMED
--add-opens=java.base/java.util.spi=ALL-UNNAMED
--add-opens=java.base/java.lang.invoke=ALL-UNNAMED
--add-opens=java.base/java.lang.reflect=ALL-UNNAMED
--add-opens=java.base/java.net=ALL-UNNAMED
--add-opens=java.base/java.nio=ALL-UNNAMED
--add-opens=java.base/sun.nio.ch=ALL-UNNAMED
--add-opens=java.base/sun.nio.cs=ALL-UNNAMED
--add-opens=java.base/sun.security.action=ALL-UNNAMED
--add-opens=java.base/sun.util.calendar=ALL-UNNAMED
--add-opens=java.security.jgss/sun.security.krb5=ALL-UNNAMED
```

---

## Recursos Adicionales

### **Scala**
- [Programming in Scala](https://www.artima.com/shop/programming_in_scala)
- [Scala Documentation](https://docs.scala-lang.org/)
- [Functional Programming in Scala](https://www.manning.com/books/functional-programming-in-scala)
- [Scala Exercises](https://www.scala-exercises.org/)

### **PySpark**
- [Databricks PySpark Guide](https://www.databricks.com/spark/pyspark)
- [Apache Spark Documentation](https://spark.apache.org/docs/latest/)
- [PySpark SQL Guide](https://spark.apache.org/docs/latest/sql-programming-guide.html)
- [PySpark API Reference](https://spark.apache.org/docs/latest/api/python/index.html)

### **Apache Spark y Big Data**
- [Learning Spark, 2nd Edition](https://www.oreilly.com/library/view/learning-spark-2nd/9781492050032/)
- [High Performance Spark](https://www.oreilly.com/library/view/high-performance-spark/9781491943205/)
- [Big Data Analysis with Spark](https://link.springer.com/book/10.1007/978-1-4842-7163-5)

Este portafolio seguirá evolucionando con más ejemplos y optimizaciones conforme avance en mi aprendizaje. 🚀

