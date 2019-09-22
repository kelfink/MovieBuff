import org.scalatest.FunSuite

class MainTest extends FunSuite {
  test("Main.cube") {
    assert(Main.cube(3) === 27)
  }
}