package com.demo.codewars.common_denominators;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractsTest {
    @Test
    public void test_fractions() throws Exception {
        long[][] lst;
        lst = new long[][] { {1, 2}, {1, 3}, {10, 40} };
        assertEquals("(6,12)(4,12)(3,12)", Fracts.convertFrac(lst));
    }
    private static String Array2D2String(long[][] lst) {
        String s = "["; int l = lst.length;
        for (int i = 0; i < l; i++) {
            long[] a = lst[i];
            s += "[" + a[0] + ", " + a[1];
            if (i < l-1) s += "], ";
            else s += "]";
        }
        return s += "]";
    }
    private static void testing(long[][] lst, String expected) {
        System.out.println("Testing " + Array2D2String(lst));
        String actual = Fracts.convertFrac(lst);
        System.out.println("Actual " + actual);
        System.out.println("Expect " + expected);
        System.out.println("-");
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        long[][] lst = new long[][] { {1, 2}, {1, 3}, {1, 4} };
        testing(lst, "(6,12)(4,12)(3,12)");
        lst = new long[][] { {69, 130}, {87, 1310}, {30, 40} };
        testing(lst, "(18078,34060)(2262,34060)(25545,34060)");
        lst = new long[][] {  };
        testing(lst, "");

        lst = new long[][] { {77, 130}, {84, 131}, {3, 4} };
        testing(lst, "(20174,34060)(21840,34060)(25545,34060)");
        lst = new long[][] { {6, 13}, {187, 1310}, {31, 41} };
        testing(lst, "(322260,698230)(99671,698230)(527930,698230)");
        lst = new long[][] { {8, 15}, {7, 111}, {4, 25} };
        testing(lst, "(1480,2775)(175,2775)(444,2775)");

        lst = new long[][] { {1, 2}, {1, 3}, {1, 4} };
        testing(lst, "(6,12)(4,12)(3,12)");
        lst = new long[][] { {77, 130}, {840, 1310}, {3, 4} };
        testing(lst, "(20174,34060)(21840,34060)(25545,34060)");
        lst = new long[][] { {1, 100}, {30, 10000}, {1, 2500}, {1, 20000} };
        testing(lst, "(200,20000)(60,20000)(8,20000)(1,20000)");

        lst = new long[][] { {1, 1}, {3, 1}, {4, 1}, {5, 1} };
        testing(lst, "(1,1)(3,1)(4,1)(5,1)");
        lst = new long[][] { {3, 1} };
        testing(lst, "(3,1)");
        lst = new long[][] { {77, 130}, {84, 131}, {30, 40} };
        testing(lst, "(20174,34060)(21840,34060)(25545,34060)");
        lst = new long[][] { {1, 100}, {3, 1000}, {1, 2500}, {1, 20000} };
        testing(lst, "(200,20000)(60,20000)(8,20000)(1,20000)");
    }

}
