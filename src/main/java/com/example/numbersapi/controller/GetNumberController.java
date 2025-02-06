package com.example.numbersapi.controller;

import com.example.numbersapi.Entity.Response;
import com.example.numbersapi.service.GetNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class GetNumberController {

    @Autowired
    GetNumberService getNumberService;

    @GetMapping("/classify-number")
    public ResponseEntity<Response> getNumber(@Validated @RequestParam int number){

        Response res = getNumberService.getFunFact(number);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<Map<String, Object>> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
//        return ResponseEntity.badRequest().body(Map.of(
//                "number", "alphabet",
//                "error", true
//        ));
//    }
}
