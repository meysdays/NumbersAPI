package com.example.numbersapi.exception;

import com.example.numbersapi.Entity.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

//    @Autowired
//    private ErrorResponse errorResponse;

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
//        return ResponseEntity.badRequest().body(Map.of(
//                "number", "alphabet",
//                "error", true
//        ));

        return new ResponseEntity<>(new ErrorResponse("alphabet", true), HttpStatus.BAD_REQUEST);
    }
}
