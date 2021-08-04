package com.demo.codewars.sum_of_intervals;

/*
Write a function called sumIntervals/sum_intervals() that accepts an array of intervals, and returns the sum of all the
Interval lengths. Overlapping intervals should only be counted once.

Intervals are represented by a pair of integers in the form of an array. The first value of the interval will always be
 ess than the second value. Interval example: [1, 5] is an interval from 1 to 5. The length of this interval is 4.

Overlapping Intervals
List containing overlapping intervals:

[
   [1,4],
   [7, 10],
   [3, 5]
]
The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5],
which has a length of 4.

Examples:
// null argument
Interval.sumIntervals(null);  // => 0

// empty intervals
Interval.sumIntervals(new int[][]{});  // => 0
Interval.sumIntervals(new int[][]{2,2}, {5,5});  // => 0

// disjoined intervals
Interval.sumIntervals(new int[][]{
  {1,2},{3,5}
});  // => (2-1) + (5-3) = 3

// overlapping intervals
Interval.sumIntervals(new int[][]{
  {1,4},{3,6},{2,8}
});  // [1,8] => 7
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Interval {

    public static int sumIntervals(int[][] intervals) {
        Set<Integer> seconds = new HashSet<>();
        if (intervals==null) return 0;
        Arrays.stream(intervals)
                .flatMapToInt(i -> IntStream.range(i[0],i[1]))
                .forEach(seconds::add);
        return seconds.size();
    }

}
