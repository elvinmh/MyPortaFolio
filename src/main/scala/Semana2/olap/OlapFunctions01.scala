package Semana2.olap

object  OlapFunctions01 extends App {

  import org.apache.spark.sql.SparkSession
  import org.apache.spark.sql.expressions.Window
  import org.apache.spark.sql.functions._

  val spark = SparkSession.builder
    .appName("Spark SQL OLAP functions")
    .config("spark.master", "local")
    .getOrCreate()

  spark.sparkContext.setLogLevel("ERROR")

  import spark.implicits._

  val data = Seq(
    ("A", 19),
    ("A", 2),
    ("A", 19),
    ("A", 10),
    ("A", 20),
    ("B", 6),
    ("B", 5),
    ("B", 10),
    ("C", 7),
    ("C", 8),
    ("C", 1)
  )

  val df = data.toDF("key", "value")

  val windowSpec = Window.partitionBy("key").orderBy("value")

  println("WindowSpec: lag, lead, rank, dense_rank, percent_rank, ntile, cume_dist, row_number ")

  println("lag: returns the value of the column in the previous row")
  val df2 = df.withColumn("lag", lag("value", 1).over(windowSpec))
  df2.show()
  println("lead: returns the value of the column in the next row")
  val df3 = df.withColumn("lead", lead("value", 1).over(windowSpec))
  df3.show()
  println("rank: returns the rank of the current row")
  // rank devuelve el rango de la fila actual, esto es, si hay empate, devuelve el mismo rango para las filas con el mismo valor
  val df4 = df.withColumn("rank", rank().over(windowSpec))
  df4.show()
  println("dense_rank: returns the dense rank of the current row")
  // dense_rank devuelve el rango denso de la fila actual, esto es, si hay empate, devuelve el mismo rango para las filas con el mismo valor, pero no salta valores
  val df5 = df.withColumn("dense_rank", dense_rank().over(windowSpec))
  df5.show()

  println("percent_rank: returns the percentage rank of the current row")
  // percent_rank devuelve el rango porcentual de la fila actual, esto es, si hay empate, devuelve el mismo rango para las filas con el mismo valor
  val df6 = df.withColumn("percent_rank", percent_rank().over(windowSpec))
  df6.show()
  println("ntile: returns the ntile group of the current row")
  // ntile devuelve el grupo ntile de la fila actual
  val df7 = df.withColumn("ntile", ntile(2).over(windowSpec))
  df7.show()
  println("cume_dist: returns the cumulative distribution of the current row")
  val df8 = df.withColumn("cume_dist", cume_dist().over(windowSpec))
  df8.show()
  println("row_number: returns the row number of the current row")
  val df9 = df.withColumn("row_number", row_number().over(windowSpec))

  df9.show()

  spark.stop()

}
