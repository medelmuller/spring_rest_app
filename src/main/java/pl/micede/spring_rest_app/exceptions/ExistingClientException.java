package pl.micede.spring_rest_app.exceptions;

import pl.micede.spring_rest_app.model.Client;

public class ExistingClientException extends RuntimeException{
//    public ExistingClientException(String pesel) {
//        super(String.format("Client with [%s] pesel number exists already!", pesel));
//    }

    public ExistingClientException(Client newClient) {
        super(String.format("Client with [%s] exists already!", newClient));
    }
}
