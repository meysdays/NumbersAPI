package com.example.numbersapi.exception;

import com.example.numbersapi.Entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
//        return ResponseEntity.badRequest().body(Map.of(
//                "number", "alphabet",
//                "error", true
//        ));

        return new ResponseEntity<>(new com.example.numbersapi.Entity.ErrorResponse("alphabet", true), HttpStatus.BAD_REQUEST);
    }
}
