package com.sapient.productcatalogue.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class B2CException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public B2CException(String message) {
        super(message);
    }
}
