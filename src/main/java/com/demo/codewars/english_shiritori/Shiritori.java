package com.demo.codewars.english_shiritori;

/*
Background:
In Japan, a game called Shiritori is played. The rules are simple, a group of people take turns calling out a word whose beginning
 syllable is the same as the previous player's ending syllable. For example, the first person would say the word ねこ, and the
 second player must make a word that starts with こ, like　こむぎ. This repeats until a player can not think of a word fast enough
 or makes a word that ends in ん, because there are no words that begin with ん　in the Japanese language.

English Shiritori has the same principle, with the first and last letters of words. That being said the lose condition is saying
a word that doesn't start with the previous word's last letter or not saying a word quick enough.

For example: apple -> eggs -> salmon -> nut -> turkey ...

Your Task:
You will be given a list of strings, a transcript of an English Shiritori match. Your task is to find out if the game ended early,
and return a list that contains every valid string until the mistake. If a list is empty return an empty list. If one of the
elements is an empty string, that is invalid and should be handled.

Examples:
All elements valid:
The array {"dog","goose","elephant","tiger","rhino","orc","cat"}

should return {"dog","goose","elephant","tiger","rhino","orc","cat"}

An invalid element at index 2:
The array {"dog","goose","tiger","cat", "elephant","rhino","orc"}

should return ("dog","goose") since goose ends in 'e' and tiger starts with 't'

An invalid empty string at index 2:
The array {"ab","bc","","cd"}

should return ("ab","bc")

All invalid empty string at index 0:
The array {"","bc","","cd"}

should return An Empty List

Resources:
https://en.wikipedia.org/wiki/Shiritori

Notes:
猫 = ねこ = neko = cat

小麦 = こむぎ = komugi = wheat
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shiritori {
//    public static List<String> theGame(List<String> words) {
//        List<String> resultList = new ArrayList<>();
//        if (!words.isEmpty()) {
//            if (words.get(0).length()>0) {
//                resultList.add(words.get(0));
//            } else return Collections.emptyList();
//        } else return Collections.emptyList();
//        for (int i=1; i<words.size(); i++) {
//            String previousWord = resultList.get(i-1);
//            String currentWord = words.get(i);
//            if (currentWord.length()>0) {
//                if (previousWord.charAt(previousWord.length() - 1) == currentWord.charAt(0)) {
//                    resultList.add(currentWord);
//                } else break;
//            } else break;
//        }
//        return resultList;
//    }
    public static List<String> theGame(List<String> words) {
        if(words.isEmpty() || words.get(0).length()<=0) {
            return Collections.emptyList();
        }
        List<String> resultList = new ArrayList<>();
        resultList.add(words.get(0));
        for (int i=1; i<words.size(); i++) {
            String prev = resultList.get(i-1);
            String curr = words.get(i);
            if (validate(prev,curr)) {
                resultList.add(curr);
            } else return resultList;
        }
        return resultList;
    }

    private static boolean validate(String s1, String s2) {
        if (s1.length()<=0 || s2.length()<=0) return false;
        return s1.charAt(s1.length() - 1) == s2.charAt(0);
    }
}
