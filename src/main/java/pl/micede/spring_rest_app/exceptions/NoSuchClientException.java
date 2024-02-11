package pl.micede.spring_rest_app.exceptions;

public class NoSuchClientException extends RuntimeException{

    public NoSuchClientException(String pesel) {
        super(String.format("Client with [%s] pesel number does not exist!", pesel));
    }
}
