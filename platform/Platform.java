package platform;

import java.util.ArrayList;
import java.util.List;

import contenido.Movie;

public class Platform {

    private String name;
    private List<Movie> content;

    public Platform(String name) {
        this.name = name;
        this.content = new ArrayList<>();
    }

    public void addContent(Movie newMovie) {
        content.add(newMovie);
    }

    // getters y setters
    public int getTotalMovies() {
        return content.size();
    }

    public void showTitles() {
        System.out.println("Películas disponibles en " + this.name + ":");
        for (Movie movie : content) {
            System.out.println(movie.getTitle());
        }
    }

    public Movie getMovieByTitle(String title) {
        for (Movie movie : content) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null; // Si no se encuentra la película
    }

    public void removeContent(Movie movie) {
        content.remove(movie);
    }
}
