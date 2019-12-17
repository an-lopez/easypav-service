package com.anlh.easypav.easypav.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
@RestController
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) throws Exception{
        ExceptionResponse response = new ExceptionResponse(500, ex.getMessage());
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(SQLException.class)
    public final ResponseEntity<Object> handleSQLExceptions(Exception ex, WebRequest request) throws Exception{
        ExceptionResponse response = new ExceptionResponse(500, "Database error, check logs.");
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
