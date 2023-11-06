package bookQueries.ExceptionHandler;

public class BookNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;
    public BookNotFoundException(String error) {
        super(error);
    }
}
