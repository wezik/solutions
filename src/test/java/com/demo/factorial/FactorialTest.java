package com.demo.factorial;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void factorialTest() {
        BigDecimal result = Factorial.factorial(8);
        assertEquals(BigDecimal.valueOf(40320),result);
    }

    @Test
    void factorialTestIf0() {
        BigDecimal result = Factorial.factorial(0);
        assertEquals(BigDecimal.valueOf(0),result);
    }

}
