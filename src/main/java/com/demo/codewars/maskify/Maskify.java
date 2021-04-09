package com.demo.codewars.maskify;

/*
Description:
Usually when you buy something, you're asked whether your credit card number, phone number or answer to your most secret question
is still correct. However, since someone could look over your shoulder, you don't want that shown on your screen. Instead, we mask it.

Your task is to write a function maskify, which changes all but the last four characters into '#'.

Example
maskify("4556364607935616") == "############5616"
maskify(     "64607935616") ==      "#######5616"
maskify(               "1") ==                "1"
maskify(                "") ==                 ""
maskify("Skippy")                                   == "##ippy"
maskify("Nananananananananananananananana Batman!") == "####################################man!"
 */

public class Maskify {
    public static String maskify(String str) {
        int length = str.length();
        int offset = 4;
        if (length>=offset) {
            String lastChars = str.substring(str.length()-offset);
            return "#".repeat(str.length() - offset) + lastChars;
        }
        return str;
    }
}
