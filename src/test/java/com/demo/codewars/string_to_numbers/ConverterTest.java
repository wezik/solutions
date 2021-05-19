package com.demo.codewars.string_to_numbers;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest {

    @Test
    public void convert_test0(){
        int R = 10234567;
        String s = "CodeWars";

        assertEquals(R, Converter.convert(s));
    }

    @Test
    public void convert_testBasic1(){
        int R = 1020;
        String s = "KATA";

        assertEquals(R, Converter.convert(s));
    }

    @Test
    public void convert_testBasic2(){
        int R = 11001201;
        String s = "AABBADBA";

        assertEquals(R, Converter.convert(s));
    }

    @Test
    public void convert_testBasic3(){
        int R = 0;
        String s = "";

        assertEquals(R, Converter.convert(s));
    }

    @Test
    public void convert_testBasic4(){
        int R = 1;
        String s = "W";

        assertEquals(R, Converter.convert(s));
    }

    @Test
    public void convert_testBasic5(){
        int R = 111;
        String s = "WWW";

        assertEquals(R, Converter.convert(s));
    }

    @Test
    public void convert_random(){
        Stream.generate(ConverterTest::randomWord)
                .limit(10)
                .forEach(word -> {
                    var acctual = convert(word);
                    var excpected = Converter.convert(word);
                    assertEquals(acctual, excpected);
                });
    }

    @Test
    public void convert_RandomMixedCase(){
        Stream.generate(ConverterTest::randomWordUpperLower)
                .limit(10)
                .forEach(word -> {
                    var acctual = convert(word);
                    var excpected = Converter.convert(word);
                    assertEquals(acctual, excpected);
                });
    }


    static String randomWord(){
        IntFunction<String> toString = ch -> Character.toString((char)ch);

        // https://stackoverflow.com/a/39912839/5322506
        char[] letters = new Random()
                .ints('A', 'Z' +1)
                .distinct()
                .limit(10L)
                .mapToObj(toString)
                .collect(Collectors.joining())
                .toCharArray();


        return new Random()
                .ints(19L, 0, 10)
                .map( pos-> letters[pos])
                .mapToObj(ch ->(char)ch)
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append )
                .toString();
    }

    static String randomWordUpperLower(){
        IntFunction<String> toString = ch -> Character.toString((char)ch);

        // https://stackoverflow.com/a/39912839/5322506
        char[] letters = new Random()
                .ints('A', 'z' +1)
                .filter(ch -> ch <= 'Z' || 'a' <= ch)
                .distinct()
                .limit(10L)
                .mapToObj(toString)
                .collect(Collectors.joining())
                .toCharArray();


        return new Random()
                .ints(19L, 0, 10)
                .map( pos-> letters[pos])
                .mapToObj(ch ->(char)ch)
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append )
                .toString();
    }

    private static long convert(String X){
        if(X.length()==0)
            return 0;
        String x = String.valueOf(X).toLowerCase();
        String result = new String();
        int c = 0;
        for(int i = 0; i < x.length(); i++)
        {
            if(i == 0)  result += "1";
            else{
                if(x.indexOf(x.charAt(i)) != i)
                    result += result.charAt(x.indexOf(x.charAt(i)));
                else{
                    result += String.valueOf(c);
                    c = c == 0?2:c+1;
                }
            }
        }
        return Long.parseLong(result);
    }
}
