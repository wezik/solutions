package com.demo.fibonacci;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void lessThanSecondForFibonacciN60() {
        StopWatch watch = new StopWatch();
        watch.start();
        BigDecimal result = Fibonacci.getFibonacci(40);
        watch.stop();
        assertEquals(BigDecimal.valueOf(102334155),result);
        assertTrue(watch.getTotalTimeSeconds()<1);
    }
}
