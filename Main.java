import java.time.LocalDate;
import java.time.LocalDateTime;

import contenido.Movie;
import platform.User;
import utils.CustomUtils;

public class Main {

    public static final String VERSION = "1.0";
    public static final String PLATFORM_NAME = "Platzi play";
    public static void main(String[] args) {

        System.out.println(PLATFORM_NAME + " v" + VERSION);

        Movie movie = new Movie();
        movie.title = CustomUtils.GetString("Ingrese titulo de la película:");
        movie.description = CustomUtils.GetString("Ingrese descripción de la película:");
        // movie.premierYear=2025;
        movie.premiereDate = LocalDate.of(2025, 7, 23);
        movie.genre = CustomUtils.GetString("Ingrese Genero de la película:");
        movie.duration = CustomUtils.GetInt("Ingrese duración de la pelúcula:");
        
        movie.Rate(4.2);


        System.out.println(movie.GetDatasheet());

        User user = new User();
        user.Name = "Pluto";
        user.registerDate = LocalDateTime.now();
        
        System.out.println(user.registerDate);
        user.Watch(movie);

    }
}