package com.demo.codewars.maskify;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class MaskifyTest {

    @Test
    public void testEmpty() {
        assertEquals("", Maskify.maskify(""));
    }

    @Test
    public void testSingle() {
        assertEquals("z",Maskify.maskify("z"));
    }

    @Test
    public void testShort() {
        assertEquals("#adwf",Maskify.maskify("zadwf"));
    }

    @Test
    public void testLong() {
        assertEquals("#####6789",Maskify.maskify("123456789"));
    }

}
