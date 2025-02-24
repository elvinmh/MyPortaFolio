## Portfolio: **Scala / PySpark**

Este portafolio representa mi aprendizaje y trabajo con **Scala** y **PySpark**, las herramientas que estoy estudiando en el módulo "Scala/PySpark". 

---

## Estructura del Proyecto
El portafolio esta contiene coceptos básicos y calves que salen del temario impartido:

- `spark.sql`: Contiene ejemplos relacionados con Spark SQL y funciones personalizadas.
- `colecciones`: Contiene ejemplos relacionados con colecciones en Scala.
- `composicion`: Contiene ejemplos que demuestran la composición de funciones.
- `errores`: Contiene ejemplos que demuestran el manejo de errores.
- `patrones`: Contiene ejemplos que demuestran patrones de programación funcional.
  - `applicative`: Contiene ejemplos que demuestran el patrón Aplicativo (Applicative).
  - `functors`: Contiene ejemplos que demuestran el patrón Funtor (Functor).
  - `monads`: Contiene ejemplos que demuestran el patrón Mónada (Monad).
  - `monoids`: Contiene ejemplos que demuestran el patrón Monoide (Monoid).
  - `semigroups`: Contiene ejemplos que demuestran el patrón Semigrupo (Semigroup).
  - `traversables`: Contiene ejemplos que demuestran el patrón Traversable.
  - `validated`: Contiene ejemplos que demuestran el patrón Validated.
  - `writer`: Contiene ejemplos que demuestran el patrón Writer.
  - `reader`: Contiene ejemplos que demuestran el patrón Reader.
  - `state`: Contiene ejemplos que demuestran el patrón State.
  - `free`: Contiene ejemplos que demuestran el patrón Free.
  - `coproduct`: Contiene ejemplos que demuestran el patrón Coproduct.

---

## Tecnologías

- **Scala**: Lenguaje funcional y orientado a objetos.
- **PySpark**: API de Python para Apache Spark.
- **Apache Spark**: Framework de procesamiento distribuido.
- **Cats**: Librería funcional en Scala.
- **IntelliJ IDEA**: IDE para desarrollo en Scala.
- **Jupyter Notebooks**: Entorno interactivo para PySpark.

---

## Dependencias
El proyecto utiliza las siguientes herramientas y versiones:

- SBT: 1.10.7
- Scala: 2.13.16
- Apache Spark: 3.5.4
- Cats Core: 2.10.0
- Python: >=3.8 (para PySpark)


## Comandos de Ejecución
Para compilar y ejecutar los proyectos:

### Scala:
```bash
sbt run
```

### PySpark:
```bash
spark-submit script.py
```

### Testing
Los tests están ubicados en el directorio `src/test/scala` (Scala). Puedes ejecutarlos con:
```bash
sbt test
```

---

## Añadir las siguientes Java Opts en la configuración de ejecución de la aplicación en IntelliJ IDEA 
Para que Spark funciones en Java +17, es necesario añadir las siguientes opciones de Java en la configuración de ejecución de la aplicación en IntelliJ IDEA:

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

