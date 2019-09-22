package com.moviechallenge

import org.scalatest.FunSuite

class CreditsTest extends FunSuite {
    test("Credits get Cast") {
      val credits = new Credits("862") // toy story
      assert(credits.getCast().contains("Woody"))
    }
}