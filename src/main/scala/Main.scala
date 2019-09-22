import com.moviechallenge.Movie

object Main extends App {
  def cube(x: Int) = {
    print("THINGS")
    x * x * x
  }
  print("WHOOPDIEDOO")
  val movie = new Movie()
  movie.find("Plan 9 from Outer Space")
}
