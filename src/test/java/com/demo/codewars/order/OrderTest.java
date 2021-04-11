package com.demo.codewars.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    @Test
    public void test1() {
        assertEquals(Order.order("is2 Thi1s T4est 3a"), ("Thi1s is2 3a T4est"));
    }

    @Test
    public void test2() {
        assertEquals(Order.order("4of Fo1r pe6ople g3ood th5e the2"), ("Fo1r the2 g3ood 4of th5e pe6ople"));
    }

    @Test
    public void test3() {
        assertEquals(Order.order(""),(""));
    }

    @Test
    public void test4() {
        assertEquals(Order.order("3 6 4 2 8 7 5 1 9"),"1 2 3 4 5 6 7 8 9");
    }
}
