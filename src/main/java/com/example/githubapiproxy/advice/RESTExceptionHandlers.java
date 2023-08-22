package com.example.githubapiproxy.advice;

import com.example.githubapiproxy.model.dto.ErrorMessage;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RESTExceptionHandlers {

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<?> NotFoundExceptionHandler() {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage(HttpStatus.NOT_FOUND.value(), "User with specified username not found!"));
    }
}
