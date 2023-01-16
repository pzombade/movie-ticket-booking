package com.publicissapient.movieticketbooking.advice;

import com.publicissapient.movieticketbooking.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApplicationAdviceHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> userNotFound(String msg) {
        log.error("UserNotFoundException: " + msg);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }
}
