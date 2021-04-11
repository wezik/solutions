package com.demo.fibonacci;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void lessThanSecondForFibonacciN60() {
        StopWatch watch = new StopWatch();
        watch.start();
        Fibonacci.getFibonacci(60);
        watch.stop();
        System.out.println(watch.getTotalTimeMillis());
        assertTrue(watch.getTotalTimeSeconds()<1);
    }
}
