package com.anlh.easypav.easypav.exception;

import lombok.Data;

@Data
public class ExceptionResponse {

    private String message;
    private int status;

    public ExceptionResponse(int status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

}
