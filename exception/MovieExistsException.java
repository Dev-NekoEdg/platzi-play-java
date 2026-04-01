package exception;

public class MovieExistsException extends RuntimeException {
    public MovieExistsException(String title) {
        super("La película '" + title + "' ya existe!.");
    }
}
