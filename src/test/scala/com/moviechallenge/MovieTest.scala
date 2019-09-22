package com.moviechallenge
import org.scalatest.FunSuite

class MovieTest extends FunSuite {
    test("Movie find id") {
      assert(new Movie("Tank Girl").findId() === "9067")
    }
}
