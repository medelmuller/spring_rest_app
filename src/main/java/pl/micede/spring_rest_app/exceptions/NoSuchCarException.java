package pl.micede.spring_rest_app.exceptions;

public class NoSuchCarException extends RuntimeException{
    public NoSuchCarException(String registrationNumber) {
        super(String.format("Car with [%s] registration number does not exists!", registrationNumber));
    }

    // najlepiej obsługiwać z poziomu service albo repository
}
