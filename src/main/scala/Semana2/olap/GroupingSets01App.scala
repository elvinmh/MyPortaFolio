package Semana2.olap

import Semana2.SparkSessionWrapper
import org.apache.spark.sql.{DataFrame, SparkSession, functions}

object GroupingSets01App extends App with SparkSessionWrapper {

  spark.sparkContext.setLogLevel("ERROR")

  // Desactivamos AQE
  spark.conf.set("spark.sql.adaptive.enabled", "false")
  // Desactivamos el broadcast join
  spark.conf.set("spark.sql.autoBroadcastJoinThreshold", "-1") // Con el -1, estamos forzando que Spark no utilice el broadcast

  import spark.implicits._

  val data = Seq(
    ("Banana", "Fruit", 1000, 1),
    ("Carrot", "Vegetable", 1000, 1),
    ("Bean", "Vegetable", 2000, 2),
    ("Orange", "Fruit", 2000, 2),
    ("Banana", "Fruit", 4000, 3),
    ("Carrot", "Vegetable", 4000, 3),
    ("Bean", "Vegetable", 3000, 0),
    ("Orange", "Fruit", 3000, 0)
  )


  val df = data.toDF("Name", "Category", "Sales", "Quantity")

  df.createOrReplaceTempView("sales_data")

  val result = spark.sql("SELECT Name, Category, sum(Sales) FROM sales_data GROUP BY Name, Category GROUPING SETS((Name, Category))")

  // Idem. pero con el método groupingSets
  // Usamos rollup para obtener el mismo resultado que con grouping sets
  val resultDf = df.groupBy("Name", "Category").agg(functions.sum("Sales")).rollup("Name", "Category").count()


  result.explain(true)
  resultDf.explain(true)

  resultDf.show(false)
  result.show(false)
}

// Meto las funciones en un objeto para poder reutilizarlas y testearlas
object GroupingSets01V2 {
  // Utility methods
  def configureSpark(spark: SparkSession): Unit = {
    spark.conf.set("spark.sql.adaptive.enabled", "false") // Disable AQE
    spark.conf.set("spark.sql.autoBroadcastJoinThreshold", "-1") // Disable broadcast join
  }

  def createDataFrame(data: Seq[(String, String, Int, Int)])(implicit spark: SparkSession): DataFrame = {
    import spark.implicits._
    val df = data.toDF("Name", "Category", "Sales", "Quantity")
    df
  }

  def performSqlQuery(df: DataFrame)(implicit spark: SparkSession): DataFrame = {
    df.createOrReplaceTempView("sales_data")
    spark.sql(
      """
        |SELECT Name, Category, SUM(Sales)
        |FROM sales_data
        |GROUP BY Name, Category GROUPING SETS((Name, Category))
      """.stripMargin)
  }

  def performDataFrameOperations(df: DataFrame): DataFrame = {
    df.groupBy("Name", "Category")
      .agg(functions.sum("Sales"))
      .rollup("Name", "Category")
      .count()
  }
}

object GroupingSets01V2App extends App with SparkSessionWrapper {

  import GroupingSets01V2._

  spark.sparkContext.setLogLevel("ERROR")

  // Prepare data
  val data = Seq(
    ("Banana", "Fruit", 1000, 1),
    ("Carrot", "Vegetable", 1000, 1),
    ("Bean", "Vegetable", 2000, 2),
    ("Orange", "Fruit", 2000, 2),
    ("Banana", "Fruit", 4000, 3),
    ("Carrot", "Vegetable", 4000, 3),
    ("Bean", "Vegetable", 3000, 0),
    ("Orange", "Fruit", 3000, 0)
  )
  val df = createDataFrame(data)

  // Perform operations
  val sqlResult = performSqlQuery(df)
  val dfResult = performDataFrameOperations(df)

  // Show results
  sqlResult.explain(true)
  dfResult.explain(true)
  sqlResult.show(false)
  dfResult.show(false)


}
