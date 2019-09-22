package com.moviechallenge
import org.scalatest.FunSuite

class MovieTest extends FunSuite {
    test("FindMovie get title") {
      assert("X" === "X")
      assert(new Movie().find("Tank Girl") === "Tank Girl")
    }
}
