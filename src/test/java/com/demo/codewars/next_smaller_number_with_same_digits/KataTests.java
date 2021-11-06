package com.demo.codewars.next_smaller_number_with_same_digits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KataTests {
    @Test
    public void basicTests() {
        assertEquals(12, Kata.nextSmaller(21));
        assertEquals(790, Kata.nextSmaller(907));
        assertEquals(513, Kata.nextSmaller(531));
        assertEquals(-1, Kata.nextSmaller(1027));
        assertEquals(414, Kata.nextSmaller(441));
        assertEquals(123456789, Kata.nextSmaller(123456798));
        assertEquals(-1, Kata.nextSmaller(1000));
        assertEquals(-1, Kata.nextSmaller(1003));
        assertEquals(1003, Kata.nextSmaller(1030));
        assertEquals(25962, Kata.nextSmaller(26259));
        assertEquals(153, Kata.nextSmaller(315));
    }
}
