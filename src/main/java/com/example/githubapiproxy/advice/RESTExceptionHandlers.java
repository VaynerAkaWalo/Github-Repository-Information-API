package com.example.githubapiproxy.advice;

import com.example.githubapiproxy.model.dto.ErrorMessage;
import feign.FeignException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RESTExceptionHandlers {

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<?> NotFoundExceptionHandler() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(HttpStatus.NOT_FOUND.value(), "User not found"));
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ErrorMessage> UnsupportedResponseFormatHandler() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");

        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .headers(headers)
                .body(new ErrorMessage(HttpStatus.NOT_ACCEPTABLE.value(), "Unsupported media type"));
    }

    @ExceptionHandler(FeignException.Forbidden.class)
    public ResponseEntity<ErrorMessage> RateLimitExceededHandler() {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(new ErrorMessage(HttpStatus.FORBIDDEN.value(), "Rate limit exceeded!"));
    }
}
