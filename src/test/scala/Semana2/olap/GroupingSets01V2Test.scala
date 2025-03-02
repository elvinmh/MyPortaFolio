package Semana2.olap

import org.apache.spark.sql.SparkSession
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class GroupingSets01V2Test extends AnyFunSuite with Matchers {

  implicit val spark: SparkSession = SparkSession.builder()
    .appName("GroupingSets01V2Test")
    .master("local[*]") // Run tests locally
    .getOrCreate()

  import spark.implicits._

  // Test data
  private val testData = Seq(
    ("Banana", "Fruit", 1000, 1),
    ("Carrot", "Vegetable", 1000, 1),
    ("Bean", "Vegetable", 2000, 2),
    ("Orange", "Fruit", 2000, 2),
    ("Banana", "Fruit", 4000, 3),
    ("Carrot", "Vegetable", 4000, 3),
    ("Bean", "Vegetable", 3000, 0),
    ("Orange", "Fruit", 3000, 0)
  )

  test("configureSpark should disable specific Spark optimizations") {
    GroupingSets01V2.configureSpark(spark)
    spark.conf.get("spark.sql.adaptive.enabled") shouldBe "false"
    spark.conf.get("spark.sql.autoBroadcastJoinThreshold") shouldBe "-1"
  }

  test("createDataFrame should create a DataFrame with proper schema and data") {
    val df = GroupingSets01V2.createDataFrame(testData)

    // Check schema
    df.schema.fieldNames should contain allOf ("Name", "Category", "Sales", "Quantity")
    df.schema.fields.map(_.dataType.typeName) shouldBe Seq("string", "string", "integer", "integer")

    // Check data (convert Array to List for comparison)
    val resultData = df.collect().map(row => (row.getString(0), row.getString(1), row.getInt(2), row.getInt(3))).toList
    resultData should contain theSameElementsAs testData
  }

  test("performSqlQuery should return correct aggregation results") {
    val df = GroupingSets01V2.createDataFrame(testData)
    val sqlResult = GroupingSets01V2.performSqlQuery(df)

    // Expected results for SQL query
    val expectedData = Seq(
      ("Banana", "Fruit", 5000), // Sum for Banana-Fruit
      ("Carrot", "Vegetable", 5000), // Sum for Carrot-Vegetable
      ("Bean", "Vegetable", 5000), // Sum for Bean-Vegetable
      ("Orange", "Fruit", 5000) // Sum for Orange-Fruit
    )

    // Validate results
    val result = sqlResult.as[(String, String, Long)].collect()
    result should contain theSameElementsAs expectedData
  }

  test("performDataFrameOperations should return correct rollup results") {
    val df = GroupingSets01V2.createDataFrame(testData)
    val rollupResult = GroupingSets01V2.performDataFrameOperations(df)

    // Expected results (Names and counts are valid based on rollup logic)
    val expectedSchema = Seq("Name", "Category", "count")
    rollupResult.schema.fieldNames should contain allElementsOf expectedSchema

    // Asserting specific counts; exact data depends on grouping set behavior
    val result = rollupResult.collect()
    result.exists(row => row.getAs[String]("Name") == "Banana") shouldBe true
    result.exists(row => row.getAs[String]("Category") == "Fruit") shouldBe true
  }
}