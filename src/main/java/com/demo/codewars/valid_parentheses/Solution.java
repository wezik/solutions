package com.demo.codewars.valid_parentheses;

/*
Write a function that takes a string of parentheses, and determines if the order of the parentheses is valid. The function should
return true if the string is valid, and false if it's invalid.

Examples
"()"              =>  true
")(()))"          =>  false
"("               =>  false
"(())((()())())"  =>  true
Constraints
0 <= input.length <= 100

Along with opening (() and closing ()) parenthesis, input may contain any valid ASCII characters. Furthermore, the input string
may be empty and/or not contain any parentheses at all. Do not treat other forms of brackets as parentheses (e.g. [], {}, <>).
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {

//    //First attempt
//
//    public static boolean validParentheses(String string) {
//        if (string == null) {
//            return false;
//        }
//        char[] chars = string.toCharArray();
//        List<Character> parens = new ArrayList<>();
//        String filter = "()";
//        for (char c : chars) {
//            if (filter.contains(Character.toString(c))) {
//                parens.add(c);
//            }
//        }
//        int state = 0;
//        for (char c : parens) {
//            if (c == '(') state++;
//            else if (c == ')') state--;
//            if (state < 0) return false;
//        }
//        return state==0;
//    }

    //refactored solution

    public static boolean validParentheses(String string) {
        char[] chars = string.toCharArray();
        int result = 0;
        for (char c : chars) {
            if ('('==c) result++;
            else if (')'==c) result--;
            if (result<0) return false;
        }
        return result==0;
    }

}
