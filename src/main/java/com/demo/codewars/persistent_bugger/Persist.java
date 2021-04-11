package com.demo.codewars.persistent_bugger;

//import java.util.LinkedList;

/*
Description:
Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence, which is the
 number of times you must multiply the digits in num until you reach a single digit.

For example:

 persistence(39) == 3 // because 3*9 = 27, 2*7 = 14, 1*4=4
                      // and 4 has only one digit

 persistence(999) == 4 // because 9*9*9 = 729, 7*2*9 = 126,
                       // 1*2*6 = 12, and finally 1*2 = 2

 persistence(4) == 0 // because 4 is already a one-digit number
 */
class Persist {

    public static int persistence(long n) {
        if (n < 10) return 0;
        return 1 + persistence(multiply(n));
    }

    private static long multiply(long n) {
        if (n < 10) return n;
        return n % 10 * multiply(n / 10);
    }
}

/* Previous solution
class Persist {
    public static int persistence(long n) {
        long result = n;
        int iterations = 0;
        while (result>=10){
            LinkedList<Long> stack = extract(result);
            long number = 1;
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                long pop = stack.pop();
                number *= pop;
            }
            result = number;
            iterations++;
        }
        return iterations;
    }

    private static LinkedList<Long> extract(long n) {
        LinkedList<Long> list = new LinkedList<>();
        long number = n;
        while(number > 0) {
            list.push(number%10);
            number /= 10;
        }
        return list;
    }
}
 */
