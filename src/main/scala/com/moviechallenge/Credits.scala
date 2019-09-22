package com.moviechallenge

import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame, SparkSession}
//import org.apache.spark.sql.types._

class Credits(movieId:String) {

  private val spark = SparkSession
    .builder()
    .appName("Spark Case Finder")
    .config("spark.master", "local")
    .getOrCreate()
  import spark.implicits._

  val df: DataFrame = spark.read.format("org.apache.spark.csv")
    .option("header", true)
    .option("inferSchema", true)
    .option("escape", "\"")
    .csv("data/the-movies-dataset/credits.csv")

  df.show(1)
  private val firstRow = df.first()
  private val credits =  df.filter($"id".===(movieId))

  def getCast():String = {
      val cast = credits.first().getAs[String]("cast")
      return cast
  }

  def getCastByGender(gender: Int): Unit = {
    getCast()
  }
}
