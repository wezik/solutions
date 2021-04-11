package com.demo.fibonacci;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    private static final Map<Integer,BigDecimal> map = new HashMap<>();

    public static BigDecimal getFibonacci(int n) {
        if (n==0||n==1) return BigDecimal.valueOf(n);
        if (map.containsKey(n)) return map.get(n);
        BigDecimal result = getFibonacci(n-1).add(getFibonacci(n-2));
        map.put(n,result);
        return result;
    }
}
