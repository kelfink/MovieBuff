package com.moviechallenge

import org.apache.spark.sql.{DataFrame, SparkSession}
import scala.collection.mutable.ListBuffer
import net.liftweb.json._

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

  /**
   * Simple get of the json object for the cast
   * @return
   */
  def getCast():String = {
      val cast = credits.first().getAs[String]("cast")
      return cast
  }

  /**
   * Simple get of the json object for the crew
   * @return
   */
  def getCrew():String = {
    val crew = credits.first().getAs[String]("crew")
    return crew
  }

  /**
   * returns the list of cast marching the gender
   * @param gender
   * @return
   */
  def getCastByGender(gender: Int):List[Map[String,Object]] = {
    // cast document seems to have invalid ' symbols.  THe following isn't bulletproof, but should help with parsing.
    // Also found cases where the token None appears in a path .  Again not bulletproof, but
    // we can wrap it in quotes to prevent parse errors.
    val castParsable = getCast().replace("'","\"").replace(": None", ": \"None\"")
    val json = parse(castParsable)

    val elements = json.children

    val gendered = ListBuffer[Map[String,Object]]()

    for (index <- 0 until elements.size - 1) {
      val person = elements(index).values.asInstanceOf[Map[String,Object]]
      if (person("gender") == gender) {
        gendered += person
      }
    }
    gendered.toList
  }

  /**
   * returns the list of crew marching the gender
   * @param gender
   * @return
   */
  def getCrewByGender(gender: Int):List[Map[String,Object]] = {
    // crew document seems to have invalid ' symbols.  THe following isn't bulletproof, but should help with parsing.
    // Also found cases where the token None appears in a path .  Again not bulletproof, but
    // we can wrap it in quotes to prevent parse errors.
    val crewParsable = getCrew().replace("'","\"").replace(": None", ": \"None\"")
      .replace("O\"C", "O'C")
    val json = parse(crewParsable)


    val elements = json.children

    val gendered = ListBuffer[Map[String,Object]]()

    for (index <- 0 until elements.size - 1) {
      val person = elements(index).values.asInstanceOf[Map[String,Object]]
      if (person("gender") == gender) {
        gendered += person
      }
    }
    gendered.toList
  }
}
