package com.demo.codewars.roman_numerals;

/*
Create a RomanNumerals class that can convert a roman numeral to and from an integer value. It should follow the API
demonstrated in the examples below. Multiple roman numeral values will be tested for each helper method.

Modern Roman numerals are written by expressing each digit separately starting with the left most digit and skipping any
digit with a value of zero. In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 2008 is
written as 2000=MM, 8=VIII; or MMVIII. 1666 uses each Roman symbol in descending order: MDCLXVI.

Input range : 1 <= n < 4000

In this kata 4 should be represented as IV, NOT as IIII (the "watchmaker's four").

Examples
RomanNumerals.toRoman(1000) // should return 'M'
RomanNumerals.fromRoman("M") // should return 1000
Help
Symbol	Value
I	1
IV	4
V	5
X	10
L	50
C	100
D	500
M	1000
*/

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RomanNumerals {

    private final static TreeMap<Integer, String> toRomanMap = new TreeMap<>();
    private final static Map<Character, Integer> fromRomanMap = new HashMap<>();

    static {
        toRomanMap.put(1000,"M");
        toRomanMap.put(900,"CM");
        toRomanMap.put(500,"D");
        toRomanMap.put(400,"CD");
        toRomanMap.put(100,"C");
        toRomanMap.put(90,"XC");
        toRomanMap.put(50,"L");
        toRomanMap.put(40,"XL");
        toRomanMap.put(10,"X");
        toRomanMap.put(9,"IX");
        toRomanMap.put(5,"V");
        toRomanMap.put(4,"IV");
        toRomanMap.put(1,"I");
    }

    static {
        fromRomanMap.put('M',1000);
        fromRomanMap.put('D',500);
        fromRomanMap.put('C',100);
        fromRomanMap.put('L',50);
        fromRomanMap.put('X',10);
        fromRomanMap.put('V',5);
        fromRomanMap.put('I',1);
    }

    public static String toRoman(int n) {
        int number = toRomanMap.floorKey(n);
        if (n == number) return toRomanMap.get(n);
        String result = toRomanMap.get(number) + toRoman(n-number);
        System.out.println(result);
        return result;
    }

    public static int fromRoman(String romanNumeral) {
        int number = 0;
        for (int i=0; i<romanNumeral.length()-1; i++) {
            int currentNumber = fromRomanMap.get(romanNumeral.charAt(i));
            if (currentNumber >= fromRomanMap.get(romanNumeral.charAt(i+1))) {
                number += currentNumber;
            } else number -= currentNumber;
        }
        return number + fromRomanMap.get(romanNumeral.charAt(romanNumeral.length()-1));
    }
}
