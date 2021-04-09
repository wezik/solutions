package com.demo.codewars.duplicatecounter;

import java.util.HashMap;
import java.util.Map;

/*
Description:
Count the number of Duplicates
Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more
than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and
numeric digits.

Example
"abcde" -> 0 # no characters repeats more than once
"aabbcde" -> 2 # 'a' and 'b'
"aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
"indivisibility" -> 1 # 'i' occurs six times
"Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
"aA11" -> 2 # 'a' and '1'
"ABBA" -> 2 # 'A' and 'B' each occur twice
 */

public class CountingDuplicates {
    public static int duplicateCount(String text) {
        char[] stringChars = text.toLowerCase().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : stringChars) {
            if(map.containsKey(c)) {
                int counter = map.get(c);
                map.put(c, ++counter);
            } else map.put(c, 1);
        }
        return (int) map.entrySet().stream().filter(e -> e.getValue() >= 2).count();
    }
}
