package com.demo.codewars.longest_slidedown;

/*
Description:
Lyrics...
Pyramids are amazing! Both in architectural and mathematical sense. If you have a computer, you can mess with pyramids even if you
 are not in Egypt at the time. For example, let's consider the following problem. Imagine that you have a pyramid built of numbers,
  like this one here:

   /3/
  \7\ 4
 2 \4\ 6
8 5 \9\ 3

Here comes the task...
Let's say that the 'slide down' is the maximum sum of consecutive numbers from the top to the bottom of the pyramid. As you can
see, the longest 'slide down' is 3 + 7 + 4 + 9 = 23

Your task is to write a function longestSlideDown (in ruby/crystal/julia: longest_slide_down) that takes a pyramid representation
as argument and returns its' largest 'slide down'. For example,

longestSlideDown [[3], [7, 4], [2, 4, 6], [8, 5, 9, 3]] => 23
By the way...
My tests include some extraordinarily high pyramids so as you can guess, brute-force method is a bad idea unless you have a few
centuries to waste. You must come up with something more clever than that.

(c) This task is a lyrical version of the Problem 18 and/or Problem 67 on ProjectEuler.
 */

public class LongestSlideDown {

    public static int longestSlideDown(int[][] pyramid) {
        int height = pyramid.length;
        int[][] sumPyramid = new int[height][];
        for (int i = 0; i<height; i++) sumPyramid[i] = pyramid[i].clone();

        for (int y = height-2; y >= 0; y--) {
            for (int x = 0; x < pyramid[y].length; x++) {
                int a = sumPyramid[y + 1][x];
                int b = sumPyramid[y + 1][x + 1];
                sumPyramid[y][x] = pyramid[y][x] + (Math.max(b, a));
            }
        }
        return sumPyramid[0][0];
    }

}
