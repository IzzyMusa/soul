package com.example.soul.service

import spock.lang.Specification
import spock.lang.Unroll


class FizzBuzzSpec extends Specification {

    FizzBuzz fizzBuzz = new FizzBuzz()

    @Unroll
    def 'test fizz buzz when a -#scenario'() {


        when:
        String results = fizzBuzz.fizzbuzzfunc(var)

        then:

        results == expected

        where:
        scenario                                 | var | expected
        'number is divisible by 3 only'          | 3   | 'fizz'
        'number is divisible by 5 only'          | 5   | 'buzz'
        'number is divisible by both 5 and 3'    | 15  | 'fizzbuzz'
        'number is not divisible by both 5 or 3' | 13  | '13'

    }

}
