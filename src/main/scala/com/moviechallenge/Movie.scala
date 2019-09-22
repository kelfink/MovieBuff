package com.moviechallenge

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{DataFrame, SparkSession, Row}
//import org.apache.spark.sql.types._

import org.apache.spark.sql.SQLContext

class Movie {

  def find(title:String):String = {
    val spark = SparkSession
      .builder()
      .appName("Spark Movie Finder")
      .config("spark.master", "local")
      .getOrCreate()
    import spark.implicits._

    //val sc = spark.sparkContext
   /* val spark: SparkSession = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.some.config.option", "some-value")
      .getOrCreate()
*/

    val df: DataFrame = spark.read.format("org.apache.spark.csv")
        .option("header", true)
        .option("inferSchema", true)
        .csv("data/the-movies-dataset/movies_metadata.csv")

      //df.filter($"age"===10)
      val movies =  df.filter($"title".like("%" + title + "%"))
      movies.show()
      val foundtitle = movies.first().getAs[String]("title")
      //val selectedData: Unit = df.filter("trim(title) = 'Plan 9 From Outer Space'").show()
      return foundtitle

  }
}
