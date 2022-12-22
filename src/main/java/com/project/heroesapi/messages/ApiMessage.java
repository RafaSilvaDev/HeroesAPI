package com.project.heroesapi.messages;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

public class ApiMessage {
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiMessage(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiMessage(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        this.errors = Arrays.asList(error);
    }
}
