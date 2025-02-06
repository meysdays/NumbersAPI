package com.example.numbersapi.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
//@AllArgsConstructor
public class ErrorResponse {
    public String number;
    public boolean error;

    public ErrorResponse(String number, boolean error) {
        this.number = number;
        this.error = error;
    }
}
