package com.moviechallenge

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{DataFrame, SparkSession, Row}
import org.apache.spark.sql.functions._
//import org.apache.spark.sql.types._

import org.apache.spark.sql.SQLContext

class Movie(title:String) {

  val spark = SparkSession
    .builder()
    .appName("Spark Movie Finder")
    .config("spark.master", "local")
    .getOrCreate()
  import spark.implicits._

  val df: DataFrame = spark.read.format("org.apache.spark.csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("escape", "\"")
    .csv("data/the-movies-dataset/movies_metadata.csv")

  val trimmedDF = df.withColumn(
    "trimmed_title",
    trim(col("title"))
  )
  //val movies =  df.filter($"title".like("%" + title + "%"))
  val matched_movies =  trimmedDF.filter($"trimmed_title".===(title))
  matched_movies.show()

  def findId():String = {
      val foundTitle = matched_movies.first().getAs[String]("id")
      return foundTitle

  }
}
