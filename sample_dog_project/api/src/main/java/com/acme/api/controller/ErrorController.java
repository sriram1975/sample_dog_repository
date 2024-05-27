package com.acme.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ErrorController {

	// TODO

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<String> handleThrowable(Throwable t) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(t.getMessage());
  }
	
}
