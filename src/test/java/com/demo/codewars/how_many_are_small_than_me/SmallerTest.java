package com.demo.codewars.how_many_are_small_than_me;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SmallerTest {
    @Test
    public void initialTests() {
        assertArrayEquals(new int[] {4, 3, 2, 1,0}, Smaller.smaller(new int[] {5,4,3,2,1}));
        assertArrayEquals(new int[] {0,0,0}, Smaller.smaller(new int[] {1,2,3}));
        assertArrayEquals(new int[] {1,1,0}, Smaller.smaller(new int[] {1,2,0}));
        assertArrayEquals(new int[] {0,1,0}, Smaller.smaller(new int[] {1,2,1}));
        assertArrayEquals(new int[] {3,3,0,0,0}, Smaller.smaller(new int[] {1,1,-1,0,0}));
        assertArrayEquals(new int[] {4, 1, 5, 5, 0, 0, 0, 0, 0}, Smaller.smaller(new int[] {5, 4, 7, 9, 2, 4, 4, 5, 6}));

        System.out.println("---------Performance test!----------");
        List<Integer> list = new ArrayList<>();
        Random r = new Random();
        for (int i=0; i<500000; i++) list.add(r.nextInt(250000)-100000);
        int[] testData = new int[list.size()];
        for (int i=0; i<list.size(); i++) testData[i] = list.get(i);
        StopWatch stopWatch = new StopWatch();
        System.out.println("Test Start");
        stopWatch.start();
        Smaller.smaller(testData);
        stopWatch.stop();
        System.out.println("Test Done, Result: "+stopWatch.getTotalTimeSeconds()+" seconds.");
        System.out.println("------End of Performance test!-------");
    }
}