package com.api.rest.disney.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<BugDetail> handlerResourceNotFoundException (ResourceNotFoundException exception, WebRequest webRequest) {
        BugDetail bugDetail = new BugDetail(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(bugDetail, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BugDetail> handlerGlobalException (Exception exception, WebRequest webRequest) {
        BugDetail bugDetail = new BugDetail(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(bugDetail, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, String> errores = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String nameField = ((FieldError)error).getField();
            String message = error.getDefaultMessage();
            errores.put(nameField, message);
        });
        return new ResponseEntity<>(errores, HttpStatus.BAD_REQUEST);
    }
}
