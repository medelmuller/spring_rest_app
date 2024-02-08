package pl.micede.spring_rest_app.exceptions;
// przypomnieć sobie checked i unchecked wyjątki
public class ExistingCarException extends RuntimeException{
    public ExistingCarException(String registrationNumber) {
        super(String.format("Car with [%s] registration number already exists!", registrationNumber));
    }
}
