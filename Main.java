import java.time.LocalDate;
import java.time.LocalDateTime;

import contenido.Movie;
import platform.Platform;
import platform.User;
import utils.CustomUtils;

public class Main {

    public static final String VERSION = "1.0";
    public static final String PLATFORM_NAME = "Platzi play";
    public static final int PLATFORM_ADD_OPTION = 1;
    public static final int PLATFORM_SHOW_ALL_OPTION = 2;
    public static final int PLATFORM_SEARCH_BY_TITLE_OPTION = 3;
    public static final int PLATFORM_DELETE_OPTION = 4;
    public static final int PLATFORM_EXIT_OPTION = 5;
    private static Platform platform = new Platform(PLATFORM_NAME);

    public static void main(String[] args) {
        System.out.println(PLATFORM_NAME + " v" + VERSION);
        InitialLoad(platform);

        while (true) {

            int option = CustomUtils.GetInt("""
                        Ingrese una de las siguientes opciones:
                        1. Agregar contenido
                        2. Mostrar todo
                        3. Buscar Por título
                        4. Eliminar
                        5. Salir
                    """);

            System.out.println("Opción seleccionada: " + option);

            switch (option) {
                case PLATFORM_ADD_OPTION:
                    Add();
                    break;
                case PLATFORM_SHOW_ALL_OPTION:
                    ShowAll();
                    break;
                case PLATFORM_SEARCH_BY_TITLE_OPTION:
                    FindByTitle();
                    break;
                case PLATFORM_DELETE_OPTION:
                    Delete();
                    break;
                case PLATFORM_EXIT_OPTION:
                    System.exit(0);
                    break;
            }
        }

    }

    private static void Add() {
        String title = CustomUtils.GetString("Ingrese titulo de la película:");
        String description = CustomUtils.GetString("Ingrese descripción de la película:");
        // int premierYear = CustomUtils.GetInt("Ingrese el año de estreno de la
        // película:");
        // movie.premiereDate = LocalDate.of(2025, 7, 23);
        String genre = CustomUtils.GetString("Ingrese Genero de la película:");
        int duration = CustomUtils.GetInt("Ingrese duración de la película:");
        double rate = CustomUtils.GetDecimal("ingrese el rating de la película:");

        Movie movie = new Movie(title, duration, genre);
        movie.setDescription(description);
        movie.Rate(rate);
        platform.addContent(movie);
    }

    private static void ShowAll() {
        platform.showTitles();
    }

    private static void FindByTitle() {
        String title = CustomUtils.GetString("Ingrese el título de la película a buscar:");
        Movie movie = platform.getMovieByTitle(title);
        if (movie != null) {
            System.out.println("Película encontrada:");
            System.out.println(movie.GetDatasheet());
        } else {
            System.out.println("Película no encontrada.");
        }
    }

    private static void Delete() {
        String title = CustomUtils.GetString("Ingrese el título de la película a eliminar:");
        Movie movie = platform.getMovieByTitle(title);
        if (movie != null) {
            platform.removeContent(movie);
            System.out.println("Película eliminada.");
        } else {
            System.out.println("Película no encontrada.");
        }
    }

    private static void InitialLoad(Platform platform) {
        Movie movie1 = new Movie("Inception", 148, "Sci-Fi");
        movie1.setDescription("A thief who steals corporate secrets through the use of dream-sharing technology.");
        movie1.Rate(4.8);
        platform.addContent(movie1);

        Movie movie2 = new Movie("The Dark Knight", 152, "Action");
        movie2.setDescription("When the menace known as the Joker wreaks havoc and chaos on the people of Gotham.");
        movie2.Rate(4.9);
        platform.addContent(movie2);

        Movie movie3 = new Movie("Interstellar", 169, "Adventure");
        movie3.setDescription(
                "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.");
        movie3.Rate(4.7);
        platform.addContent(movie3);
    }

    private static void IdividualPlatform() {
        Platform platform = new Platform(PLATFORM_NAME);
        System.out.println(PLATFORM_NAME + " v" + VERSION);

        String title = CustomUtils.GetString("Ingrese titulo de la película:");
        String description = CustomUtils.GetString("Ingrese descripción de la película:");
        // int premierYear = CustomUtils.GetInt("Ingrese el año de estreno de la
        // película:");
        // movie.premiereDate = LocalDate.of(2025, 7, 23);
        String genre = CustomUtils.GetString("Ingrese Genero de la película:");
        int duration = CustomUtils.GetInt("Ingrese duración de la película:");
        double rate = CustomUtils.GetDecimal("ingrese el rating de la película:");

        Movie movie = new Movie(title, duration, genre);
        movie.setDescription(description);
        movie.Rate(rate);

        // movie.setPremiereDate(LocalDate.of(premierYear, 11, 11));
        System.out.println("------------------");
        System.out.println(movie.GetDatasheet());

        System.out.println(movie.getTitle());
        // movie.setTitle("New Title");
        // System.out.println(movie.getTitle());

        platform.addContent(movie);
        Movie movie2 = new Movie("Movie 2", 120, "Action");
        platform.addContent(movie2);

        System.out.println("# of movies in platform: " + platform.getTotalMovies());

        platform.showTitles();

    }
}