package dio.springperson.mts.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Integer id) {
        super("Mentioned ID " + id + "is not in our database");
    }
}
