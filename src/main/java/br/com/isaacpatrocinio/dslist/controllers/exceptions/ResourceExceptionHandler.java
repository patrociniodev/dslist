package br.com.isaacpatrocinio.dslist.controllers.exceptions;

import br.com.isaacpatrocinio.dslist.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        StandardError errorObject = new StandardError();
        errorObject.setTimestamp(Instant.now());
        errorObject.setStatus(HttpStatus.NOT_FOUND.value());
        errorObject.setError("Resource not found");
        errorObject.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorObject);
    }
}
