package com.softserve.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No marathon for this Id")
public class MarathonNotFoundException extends RuntimeException {
    public MarathonNotFoundException() {
    }

    public MarathonNotFoundException(String message) {
        super(message);
    }
}
