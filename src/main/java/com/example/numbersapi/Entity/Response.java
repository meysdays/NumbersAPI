package com.example.numbersapi.Entity;

import lombok.*;

@Data
@AllArgsConstructor
public class Response {
    public int number;
    public boolean is_prime;
    public boolean is_perfect;
    public String[] properties;
    public int digit_sum;
    public String fun_fact;

    public Response(int number, boolean is_prime, boolean is_perfect, String[] properties, int digit_sum, String fun_fact) {
        this.number = number;
        this.is_prime = is_prime;
        this.is_perfect = is_perfect;
        this.properties = properties;
        this.digit_sum = digit_sum;
        this.fun_fact = fun_fact;
    }
}
