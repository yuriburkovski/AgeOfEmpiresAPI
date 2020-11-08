package pl.sdaacademy.aoeapi.common.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sdaacademy.aoeapi.details_loader.service.NoCivilizationFoundException;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(value = NoCivilizationFoundException.class)
    public ResponseEntity<Object> notFoundException(NoCivilizationFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
