package com.moviechallenge

import org.scalatest.FunSuite

class CreditsTest extends FunSuite {
    test("Credits get Cast") {
      val credits = new Credits("862") // toy story
      assert(credits.getCast().contains("Woody"))
    }
  test("Credits get Cast By Gender") {
    val credits = new Credits("862") // toy story
    val femaleCast = credits.getCastByGender(1)
    // TODO:  there must be a better assert library.  like assertEquals(x, 3)
    // Also, mock/stubs on the Credits class would let us test better with data we inject.
    print("first female case: " + femaleCast.head)
    assert(femaleCast.size == 3)

    assert(femaleCast.head("name") == "Annie Potts")
  }
  test("Credits get Crew By Gender") {
    val credits = new Credits("862") // toy story
    val femaleCast = credits.getCrewByGender(1)
    // TODO:  there must be a better assert library.  like assertEquals(x, 3)
    // Also, mock/stubs on the Credits class would let us test better with data we inject.
    print("first female case: " + femaleCast.head)
    assert(femaleCast.size == 4)

    assert(femaleCast.head("name") == "Bonnie Arnold")
  }
}