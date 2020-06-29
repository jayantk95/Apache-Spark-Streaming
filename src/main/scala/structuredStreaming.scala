import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.{StringType, StructField, StructType, TimestampType}

object structuredStreaming extends App{			//App is a trait which is utilized to rapidly change objects into feasible programs
//Here, the object structuredStreaming inherits the main method of App and executes following code
	val spark = SparkSession.builder().appName("Readfile").master("local[*]").getOrCreate()
	spark.sparkContext.setLogLevel("ERROR")
	
	//nullable is set to true to get output even if any value is null
	val schema = StructType(List(
		StructField("IP",StringType,true),
		StructField("Time",StringType,true),
		StructField("URL",StringType,true),
		StructField("Status",StringType,true))
		)
	val StreamDF = spark.readStream.option("delimiter",",").schema(schema).csv("/home/hduser/Streaming/Datasets")
	
	StreamDF.createOrReplaceTempView("SDF")
	val outDF = spark.sql(sqlText = " Select IP,Time,status from SDF where URL = 'GET /details.php?id=44 HTTP/1.1'")
	outDF.writeStream.format("console").outputMode("append").start().awaitTermination()			
}
