package platform;

import java.time.LocalDateTime;

import contenido.Movie;

public class User {
    public String Name;
    public String Email;
    public LocalDateTime registerDate;

    public void Watch(Movie movie){
        // shortcut for sout -> System.out.println
        // System.out.println("Your watchin... ");
        movie.Play();
    }
}
