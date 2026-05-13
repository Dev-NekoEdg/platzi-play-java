package platform;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import contenido.Genre;
import contenido.Movie;
import contenido.MovieSummary;
import exception.MovieExistsException;

public class Platform {

    private String name;
    private List<Movie> content;

    /// Map es como un diccionario, es un Key, Value Pair.
    private Map<Movie, Integer> playCounts;


    public Platform(String name) {
        this.name = name;
        this.content = new ArrayList<>();
        this.playCounts = new HashMap<>();
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

    public void playMovie(String title) {
        Movie movie = getMovieByTitle(title);
        if (movie != null) {
            movie.Play();
            playCounts.put(movie, playCounts.getOrDefault(movie, 0) + 1);
            System.out.println("Reproducciones de '" + movie.getTitle() + "': " + playCounts.get(movie));
        } else {
            System.out.println("Película no encontrada.");
        }
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

    public List<MovieSummary> getMovieSummaries() {
        return content.stream()
                .map(mov ->
                    new MovieSummary(
                        mov.getTitle(), 
                        mov.getDuration(),
                        mov.getGenre())
                    ).toList();
    }

}
