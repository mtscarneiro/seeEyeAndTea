package dio.springperson.mts.exceptions;

public class DatabaseViolationException extends RuntimeException {

    public DatabaseViolationException(String message) {
        super(message);
    }
}
