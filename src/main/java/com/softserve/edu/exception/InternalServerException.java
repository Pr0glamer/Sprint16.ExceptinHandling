package com.softserve.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.INTERNAL_SERVER_ERROR, reason="Server error")
public class InternalServerException extends Exception {
    public InternalServerException() {
    }

    public InternalServerException(String message) {
        super(message);
    }
}
