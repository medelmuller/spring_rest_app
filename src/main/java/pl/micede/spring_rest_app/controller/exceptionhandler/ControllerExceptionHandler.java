package pl.micede.spring_rest_app.controller.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.micede.spring_rest_app.exceptions.ExistingCarException;
import pl.micede.spring_rest_app.exceptions.NoSuchCarException;

@RestControllerAdvice
public class ControllerExceptionHandler {
// tak robimy jeśli nie wystarczy żeby nam pokazywało błąd w consoli, tylko żeby pokazać też klientowi co się stało
    // nie używamy jeśli nie chcemy pokazać błędu klientowi
    @ExceptionHandler(ExistingCarException.class)
    public ResponseEntity<String> handleExistingCarException(ExistingCarException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(NoSuchCarException.class)
    public ResponseEntity<String> handleNoExistingCarException(NoSuchCarException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
