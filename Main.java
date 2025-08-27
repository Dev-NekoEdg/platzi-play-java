import java.time.LocalDate;
import java.time.LocalDateTime;

import contenido.Movie;
import platform.User;

public class Main {

    public static void main(String[] args) {

        Movie movie = new Movie();
        movie.title = "Superman";
        movie.description = "superhero movie";
        // movie.premierYear=2025;
        movie.premiereDate = LocalDate.of(2025, 7, 23);
        movie.genre = "Fiction";
        movie.duration = 129;
        
        movie.Rate(4.2);


        System.out.println(movie.GetDatasheet());

        User user = new User();
        user.Name = "Pluto";
        user.registerDate = LocalDateTime.now();
        
        System.out.println(user.registerDate);
        user.Watch(movie);

    }
}