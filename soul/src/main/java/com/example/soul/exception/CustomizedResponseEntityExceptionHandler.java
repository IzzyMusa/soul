package com.example.soul.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResoponse> handleAllExceptions
            (Exception ex, WebRequest request) {

        ExceptionResoponse exceptionResoponse =
                new ExceptionResoponse(new Date(), ex.getMessage(),
                        request.getDescription(false));

        return new ResponseEntity<>(exceptionResoponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<ExceptionResoponse> handleUserNotFountException
            (UserNotFoundException ex, WebRequest request) {

        ExceptionResoponse exceptionResoponse =
                new ExceptionResoponse(new Date(), ex.getMessage(),
                        request.getDescription(false));

        return new ResponseEntity<>(exceptionResoponse, HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ExceptionResoponse exceptionResoponse =
                new ExceptionResoponse(new Date(), ex.getMessage(),
                        ex.getBindingResult().toString());

        return new ResponseEntity<>(exceptionResoponse, HttpStatus.BAD_REQUEST);
    }



}
