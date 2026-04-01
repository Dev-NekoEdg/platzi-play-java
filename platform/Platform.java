package platform;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import contenido.Genre;
import contenido.Movie;
import exception.MovieExistsException;

public class Platform {

    private String name;
    private List<Movie> content;

    public Platform(String name) {
        this.name = name;
        this.content = new ArrayList<>();
    }

    public void addContent(Movie newMovie) {
        Movie existingMovie = getMovieByTitle(newMovie.getTitle());
        if (existingMovie != null) {
            throw new MovieExistsException(existingMovie.getTitle());
        }
        content.add(newMovie);
    }

    // getters y setters
    public int getTotalMovies() {
        return content.size();
    }

    public void showTitles() {
        System.out.println("Películas disponibles en " + this.name + ":");
        // for (Movie movie : content) {
        // System.out.println(movie.getTitle());
        // }

        // lambda expression
        content.forEach(mov -> System.out.println(mov.getTitle()));
    }

    public List<String> getTitles() {
        System.out.println("Películas disponibles en " + this.name + ":");
        // map(Movie::getTitle) es equivalente a map(mov -> mov.getTitle())
        // se lñe llama method reference y es una forma más concisa de escribir la
        // lambda expression.
        return content.stream().map(Movie::getTitle).toList();
    }

    public Movie getMovieByTitle(String title) {
        // for (Movie movie : content) {
        // if (movie.getTitle().equalsIgnoreCase(title)) {
        // return movie;
        // }
        // }
        // return null; // Si no se encuentra la película

        // lambda expression
        return content.stream()
                .filter(mov -> mov.getTitle().equalsIgnoreCase(title))
                .findFirst().orElse(null);
    }

    public List<Movie> getMoviesByGenre(Genre genre) {
        // lambda expression
        return content.stream()
                .filter(mov -> mov.getGenre().equals(genre))
                .toList();
    }

    public int getTotalDuration() {
        // lambda expression
        return content.stream()
                .mapToInt(Movie::getDuration)
                .sum();
    }

    public List<Movie> getPopularMovies(int topN) {
        return content.stream()
        .sorted(Comparator.comparingDouble(Movie::getRating).reversed())
        .limit(topN)
        .toList();
    }

    public void removeContent(Movie movie) {
        content.remove(movie);
    }

}
