package com.anlh.easypav.easypav.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class AppException extends RuntimeException{

    public AppException(String message) {
        super(message);
    }
}
