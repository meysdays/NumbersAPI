package com.example.numbersapi.service;

import com.example.numbersapi.Entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GetNumberService {

    @Autowired
    private RestTemplate restTemplate;

    public Response getFunFact(int number) {
        int num = number;
        boolean prime = isPrime(number);
        boolean perfect = isPerfectNumber(number);
        String[] properties = {isArmstrongNumber(number), isEvenOdd(number)};
        int sum = sumOfDigits(number);
        String fun = getData(number);

        return new Response(num,prime,perfect,properties,sum,fun);
    }

    public String getData(int num) {
        String url = "http://numbersapi.com/"+num;
        return restTemplate.getForObject(url, String.class);
    }

    public static boolean isPrime(int num){
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false; // Not a prime number
            }
        }
        return true;
    }

    public static boolean isPerfectNumber(int num){
        if (num <= 0) {
            return false;
        }

        int sum = 0;

        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }

    public static String isArmstrongNumber(int num){
        int absNum = num;
        int originalNum = absNum;
        int sum = 0;
        int numDigits = String.valueOf(absNum).length();

        while (absNum > 0) {
            int digit = absNum % 10; // Get the last digit
            sum += (int) Math.pow(digit, numDigits); // Raise digit to the power of numDigits and add to sum
            absNum /= 10; // Remove last digit
        }

        if(sum == originalNum){
            return "armstrong";
        }
        return "not armstrong";
    }

    public static String isEvenOdd(int num){
        if(num % 2 == 0){
            return  "even";
        }
        return "odd";
    }

    public static int sumOfDigits(int num) {
        num = Math.abs(num);
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }
}
