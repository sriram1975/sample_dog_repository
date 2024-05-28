package com.acme.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ErrorControllerTest {

    public ErrorController errorController = new ErrorController();

    @Test
    public void handleThrowableTest()
    {
        ResponseEntity<String> responseEntity = errorController.handleThrowable(new Throwable());
        assertEquals("500", Objects.requireNonNull(responseEntity.getStatusCode()).toString());
    }
}
