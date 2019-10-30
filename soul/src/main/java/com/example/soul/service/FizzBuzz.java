package com.example.soul.service;

public class FizzBuzz {


    public static String fizzbuzzfunc(int val){

        if(val%3 == 0 && val% 5 == 0){
            return "fizzbuzz";

        }

        if (val%3 == 0){
            return "fizz";
        }

        if (val%5==0){
            return "buzz";
        }
        return  String.valueOf(val);
    }

    private static void fizzBuzzToN(int n){
        for (int i = 0; i<= n; i++){
            System.out.println(fizzbuzzfunc(n));
        }
    }

    public static void main(String[] args) {

        fizzBuzzToN(100);

    }


}
