package platform;

import java.time.LocalDateTime;

import contenido.Movie;

public class User {
    private String Name;
    private String Email;
    private LocalDateTime registerDate;

    public User(String Email) {
        this.Name = "";
        this.Email = Email;
        this.registerDate = LocalDateTime.now();
    }

    public void Watch(Movie movie) {
        System.out.println(this.Name + " is watching " + movie.getTitle());
        // shortcut for sout -> System.out.println
        // System.out.println("Your watchin... ");
        movie.Play();
    }

    // getters y setters
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public LocalDateTime getRegisterDate() {
        return registerDate;
    }
}
