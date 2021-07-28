package com.demo.codewars.vin_checker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CodeWarsTest {
    @Test
    public void basicTestCases() {
        assertTrue(CodeWars.checkVin("5YJ3E1EA7HF000337"));
        assertTrue(CodeWars.checkVin("5YJ3E1EAXHF000347"));
        assertTrue(CodeWars.checkVin("5VGYMVUX7JV764512"));
        assertFalse(CodeWars.checkVin("7WDMMTDV9TG739741"));
        assertFalse(CodeWars.checkVin("7JTRH08L5EJ234829"));
    }
}