import java.time.LocalDate;
import java.time.LocalDateTime;

import contenido.Movie;
import platform.Platform;
import platform.User;
import utils.CustomUtils;

public class Main {

    public static final String VERSION = "1.0";
    public static final String PLATFORM_NAME = "Platzi play";

    public static void main(String[] args) {
        Platform platform = new Platform(PLATFORM_NAME);
        System.out.println(PLATFORM_NAME + " v" + VERSION);

        String title = CustomUtils.GetString("Ingrese titulo de la película:");
        String description = CustomUtils.GetString("Ingrese descripción de la película:");
        int premierYear = CustomUtils.GetInt("Ingrese el año de estreno de la película:");
        // movie.premiereDate = LocalDate.of(2025, 7, 23);
        String genre = CustomUtils.GetString("Ingrese Genero de la película:");
        int duration = CustomUtils.GetInt("Ingrese duración de la película:");
        double rate = CustomUtils.GetDecimal("ingrese el rating de la película:");

        Movie movie = new Movie(title, duration, genre);
        movie.setDescription(description);
        movie.Rate(rate);

        movie.setPremiereDate(LocalDate.of(premierYear, 11, 11));
System.out.println("------------------");
        System.out.println(movie.GetDatasheet());

        System.out.println(movie.getTitle());
        // movie.setTitle("New Title");
        // System.out.println(movie.getTitle());
        
        platform.addContent(movie);
        System.out.println("# of movies in platform: " + platform.getTotalMovies());
        
        User user = new User("PlutonioMiaunster@miaumiau.com");
        user.setName("Pluto");
        // user.registerDate = LocalDateTime.now();
        
        System.out.println(user.getRegisterDate());
        user.Watch(movie);

    }
}