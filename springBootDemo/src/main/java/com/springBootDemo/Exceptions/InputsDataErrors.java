package com.springBootDemo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InputsDataErrors extends Exception {
    private static final long serialVersionUID = 1L;

    public InputsDataErrors(String message) {


        super(message);
    }
}
