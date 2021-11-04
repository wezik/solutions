package com.demo.codewars.twice_linear;

import com.sun.source.util.Trees;

import java.util.*;

public class DoubleLinear {

    public static int dblLinear(int n) {
        if (n<1) return 1;
        SortedSet<Integer> resultSet = new TreeSet<>();
        for (int i=0; i<n; i++) {
            int x = i==0 ? 1 : resultSet.first();
            resultSet.add(x*2+1);
            resultSet.add(x*3+1);
            resultSet.remove(x);
        }
        return resultSet.first();
    }

}
