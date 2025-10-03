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
}
