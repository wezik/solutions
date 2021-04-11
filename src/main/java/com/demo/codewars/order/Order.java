package com.demo.codewars.order;


/*
Description:
Your task is to sort a given string. Each word in the string will contain a single number. This number is the position the word should have in the result.

Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).

If the input string is empty, return an empty string. The words in the input String will only contain valid consecutive numbers.

Examples
"is2 Thi1s T4est 3a"  -->  "Thi1s is2 3a T4est"
"4of Fo1r pe6ople g3ood th5e the2"  -->  "Fo1r the2 g3ood 4of th5e pe6ople"
""  -->  ""
 */

public class Order {
    public static String order(String s) {
        if (s.equals("")) return s;
        String[] words = s.split(" ");
        String[] sortedWords = sortWordsArray(words);
        return buildStringFromArray(sortedWords);
    }

    private static String[] sortWordsArray(String[] words) {
        String[] sortedWords = new String[words.length];
        for(String word : words) {
            if (word.matches(".*\\d.*")) {
                int i = Integer.parseInt(extractNumber(word));
                sortedWords[i-1] = word;
            }
        }
        return sortedWords;
    }

    private static String buildStringFromArray(String[] words) {
        StringBuilder builder = new StringBuilder();
        for(String s: words) {
            if(builder.length()>0) builder.append(" ");
            builder.append(s);
        }
        return builder.toString();
    }

    private static String extractNumber(String s) {
        StringBuilder builder = new StringBuilder();
        char[] chars = s.toCharArray();
        for(char c : chars) {
            if (Character.isDigit(c)) {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
