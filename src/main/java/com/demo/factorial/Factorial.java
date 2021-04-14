package com.demo.factorial;

import java.math.BigDecimal;

import static java.math.BigDecimal.ONE;

public class Factorial {

    public static BigDecimal factorial(int n) {
        if (n==0) return BigDecimal.ZERO;
        else if (n==1) return BigDecimal.ONE;
        else return BigDecimal.valueOf(n).multiply(factorial(n-1));
    }

}
