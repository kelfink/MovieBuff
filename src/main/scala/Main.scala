import com.moviechallenge.Movie
import com.moviechallenge.Credits


object Main extends App {
  val movie = new Movie("Brazil")
  println(new Credits(movie.findId()).getCast())
}
