import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._ //{IntegerType, StringType, StructType}
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.functions.udf

import org.apache.commons.codec.digest.MurmurHash3
//import org.apache.spark.sql.expressions.UserDefinedFunction

object SimpleApp {

  def MurmurHash3_128x64(Str: String): Option[Long] = {
    Option(Str).map((x: String) => MurmurHash3.hash128x64(x.getBytes())(1))
  }

  val hash64L = udf[Option[Long], String](MurmurHash3_128x64)

  def main(args: Array[String]) {
    val spark = SparkSession.builder.appName("Simple Application").getOrCreate()

    val schema = List(StructField("String", StringType, true))

    val data = Seq(
      Row("Test 1"),
      Row("Test 2"),
      Row("Test 3"),
      Row(null)
    )

    val stringDF = spark.createDataFrame(
      spark.sparkContext.parallelize(data),
      StructType(schema)
    )
    val actualDf = stringDF.withColumn("is_hash", hash64L(col("String")))
    actualDf.show()
    spark.stop()
  }
}
