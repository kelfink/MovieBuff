import com.moviechallenge.Movie
import com.moviechallenge.Credits


object Main extends App {
  val movie = new Movie("Toy Story")
  val credits = new Credits(movie.findId())
  val femaleCast = credits.getCastByGender(1).map(_("name"))
  val maleCast = credits.getCastByGender(2).map(_("name"))
  val femaleCrew = credits.getCrewByGender(1).map(_("name"))
  val maleCrew = credits.getCrewByGender(2).map(_("name"))
  println("Movie Female Cast " + femaleCast)
  println("Movie Male Cast " + maleCast)

  println("Movie Female Crew " + femaleCrew)
  println("Movie Male Crew " + maleCrew)

  println("Count Female Cast: " + femaleCast.size)
  println("Count Male Cast: " + maleCast.size)
  println("Count Female Crew: " + femaleCrew.size)
  println("Count Male Crew: " + maleCrew.size)
}
