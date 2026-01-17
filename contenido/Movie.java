package contenido;

import java.time.LocalDate;

public class Movie {
    private String title;
    private String description;
    private int duration;
    private String genre;
    // public int premierYear;
    private LocalDate premiereDate;
    private double rating;
    private boolean isAvailable;

    public Movie(String title, int duration, String genre) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
        this.premiereDate = LocalDate.now();
    }

    public void Play() {
        System.out.println("Playing " + this.title);
    }

    public String GetDatasheet() {
        return this.title + "(" + this.premiereDate.getYear() + ")\n"
                + "Genre: " + this.genre + "\n"
                + "Rating: " + this.rating + "/5";
    }

    public void Rate(double rate) {
        if (rate >= 0 && rate <= 5) {
            this.rating = rate;
        }
    }

    public boolean isPopular() {
        return this.rating >= 4;
    }

    //getters y setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public LocalDate getPremiereDate() {
        return premiereDate;
    }
    public void setPremiereDate(LocalDate premiereDate) {
        this.premiereDate = premiereDate;
    }
    public double getRating() {
        return rating;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }


}