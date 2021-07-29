package com.demo.codewars.style_ranking_system;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user = new User();
    private void do_test(int rank, int expectedRank, int expectedProgress) {
        user.incProgress(rank);
        assertEquals(expectedRank, user.rank);
        assertEquals(expectedProgress, user.progress);
    }
    @Test
    public void testIncProgress() {
        do_test(-8, -8, 3);

        user = new User();
        do_test(-7, -8, 10);

        user = new User();
        do_test(-6, -8, 40);

        user = new User();
        do_test(-5, -8, 90);

        user = new User();
        do_test(-4, -7, 60);

        user = new User();
        do_test(-8, -8, 3);

        user = new User();
        do_test(1, -2, 40);
        do_test(1, -2, 80);
        do_test(1, -1, 20);
        do_test(1, -1, 30);
        do_test(1, -1, 40);
        do_test(2, -1, 80);
        do_test(2, 1, 20);
        do_test(-1, 1, 21);
        do_test(3, 1, 61);
        do_test(8, 6, 51);
        do_test(8, 6, 91);
        do_test(8, 7, 31);
        do_test(8, 7, 41);
        do_test(8, 7, 51);
        do_test(8, 7, 61);
        do_test(8, 7, 71);
        do_test(8, 7, 81);
        do_test(8, 7, 91);
        do_test(8, 8, 0);
        do_test(8, 8, 0);
    }
    @Test
    public void invalidRange9() {
        assertThrows(IllegalArgumentException.class, () -> user.incProgress(9));
    }
    @Test
    public void invalidRangeNeg9() {
        assertThrows(IllegalArgumentException.class, () -> user.incProgress(-9));
    }
    @Test
    public void invalidRange0() {
        assertThrows(IllegalArgumentException.class, () -> user.incProgress(0));
    }
}