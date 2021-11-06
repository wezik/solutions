package com.demo.codewars.next_smaller_number_with_same_digits;

import java.util.*;

/*
Write a function that takes a positive integer and returns the next smaller positive integer containing the same digits.

For example:

nextSmaller(21) == 12
nextSmaller(531) == 513
nextSmaller(2071) == 2017
Return -1 (for Haskell: return Nothing, for Rust: return None), when there is no smaller number that contains the same
digits. Also return -1 when the next smaller number with the same digits would require the leading digit to be zero.

nextSmaller(9) == -1
nextSmaller(111) == -1
nextSmaller(135) == -1
nextSmaller(1027) == -1 // 0721 is out since we don't write numbers with leading zeros
some tests will include very large numbers.
test data only employs positive integers.
The function you write for this challenge is the inverse of this kata: "Next bigger number with the same digits."
 */
public class Kata {

    public static long nextSmaller(long n) {
        String number = String.valueOf(n);
        int iX = findIndexOfX(number);
        if (iX>=0) {
            int iY = findIndexOfY(number,iX);
            if (iY>0) {
                number = swapDigits(number, iX, iY);
                if (number.charAt(0)=='0') return -1;
                long result = Long.parseLong(sortDescendingToTheRight(number, iX));
                return result < n ? result : -1;
            }
        }
        return -1;
    }

    private static int findIndexOfX(String s) {
        for (int i=s.length()-2; i>=0; i--) {
            for (int j=i+1; j<s.length(); j++) {
                if (Integer.parseInt(s.charAt(i)+"") > Integer.parseInt(s.charAt(j)+"")) {
                    return i;
                }
            }
        }
        return -1;
    }

    private static int findIndexOfY(String s, int indexOfX) {
        int largest = -1;
        int largestIndex = -1;
        for (int i=indexOfX+1; i<s.length(); i++) {
            int digit = Integer.parseInt(s.charAt(i)+"");
            if (digit > largest && digit < Integer.parseInt(s.charAt(indexOfX)+"")) {
                largest = digit;
                largestIndex = i;
            }
        }
        return largestIndex;
    }

    private static String swapDigits(String s, int indexOfX, int indexOfY) {
        StringBuilder sb = new StringBuilder(s);
        char x = sb.charAt(indexOfX);
        char y = sb.charAt(indexOfY);
        sb.setCharAt(indexOfX,y);
        sb.setCharAt(indexOfY,x);
        return sb.toString();
    }

    private static String sortDescendingToTheRight(String number, int iX) {
        char[] chars = number.substring(iX+1).toCharArray();
        List<Integer> list = new Stack<>();
        for (char c: chars) list.add(Integer.parseInt(c+""));
        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        sb.append(number);
        int j=0;
        for (int i=iX+1; i<sb.length(); i++) {
            sb.setCharAt(i,Character.forDigit(list.get(j++),10));
        }
        return sb.toString();
    }
}
