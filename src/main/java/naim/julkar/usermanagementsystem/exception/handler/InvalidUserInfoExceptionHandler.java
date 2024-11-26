package naim.julkar.usermanagementsystem.exception.handler;

import java.util.LinkedHashMap;
import java.util.Map;

import naim.julkar.usermanagementsystem.exception.UserNameAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class InvalidUserInfoExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleValidationExceptions(
        MethodArgumentNotValidException ex
    ) {
        Map<String, String> errors = new LinkedHashMap<>();
        errors.put("message", "Invalid user information!");

        ex
            .getBindingResult()
            .getFieldErrors()
            .forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
            );

        return errors;
    }

    @ExceptionHandler(UserNameAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleUserAlreadyExistsExceptions(UserNameAlreadyExistsException ex) {
        Map<String, String> errors = new LinkedHashMap<>();
        errors.put("message", ex.getMessage());
        return errors;
    }
}
