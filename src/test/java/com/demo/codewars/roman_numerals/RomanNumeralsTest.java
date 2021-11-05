package com.demo.codewars.roman_numerals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralsTest {

    @Test
    public void testToRoman() throws Exception {
        assertEquals(RomanNumerals.toRoman(1), "I");
        assertEquals(RomanNumerals.toRoman(2), "II");
        assertEquals(RomanNumerals.toRoman(100), "C");
        assertEquals(RomanNumerals.toRoman(90), "XC");
        assertEquals(RomanNumerals.toRoman(94), "XCIV");
        assertEquals(RomanNumerals.toRoman(3000), "MMM");
        assertEquals(RomanNumerals.toRoman(1666), "MDCLXVI");
    }

    @Test
    public void testFromRoman() throws Exception {
        assertEquals(RomanNumerals.fromRoman("I"), 1);
        assertEquals(RomanNumerals.fromRoman("II"), 2);
        assertEquals(RomanNumerals.fromRoman("C"), 100);
        assertEquals(RomanNumerals.fromRoman("XC"), 90);
        assertEquals(RomanNumerals.fromRoman("XCIV"), 94);
        assertEquals(RomanNumerals.fromRoman("MMM"), 3000);
        assertEquals(RomanNumerals.fromRoman("MDCLXVI"), 1666);
    }
}