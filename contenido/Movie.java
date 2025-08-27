package contenido;

import java.time.LocalDate;

public class Movie {
    public String title;
    public String description;
    public int duration;
    public String genre;
    // public int premierYear;
    public LocalDate premiereDate;
    public double rating;
    public boolean isAvailable;

    public void Play()  {
        System.out.println("Playing " + this.title);
    }

    public String GetDatasheet()  {
        return this.title + "("  + this.premiereDate.getYear() + ")\n" 
                        + "Genre: " + this.genre + "\n" 
                        + "Rating: " + this.rating + "/5";
    }

    public void Rate(double rate){
        if(rate >= 0 && rate <= 5)
        {
            this.rating = rate;
        }
    }

    public boolean isPopular(){
        return this.rating >= 4;
    }
}