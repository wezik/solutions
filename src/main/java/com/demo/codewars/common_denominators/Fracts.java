package com.demo.codewars.common_denominators;
/*
Common denominators

You will have a list of rationals in the form

{ {numer_1, denom_1} , ... {numer_n, denom_n} }
or
[ [numer_1, denom_1] , ... [numer_n, denom_n] ]
or
[ (numer_1, denom_1) , ... (numer_n, denom_n) ]
where all numbers are positive ints. You have to produce a result in the form:

(N_1, D) ... (N_n, D)
or
[ [N_1, D] ... [N_n, D] ]
or
[ (N_1', D) , ... (N_n, D) ]
or
{{N_1, D} ... {N_n, D}}
or
"(N_1, D) ... (N_n, D)"
depending on the language (See Example tests) in which D is as small as possible and

N_1/D == numer_1/denom_1 ... N_n/D == numer_n,/denom_n.
Example:

convertFracs [(1, 2), (1, 3), (1, 4)] `shouldBe` [(6, 12), (4, 12), (3, 12)]
Note:
Due to the fact that the first translations were written long ago - more than 6 years - these first translations have only irreducible fractions.

Newer translations have some reducible fractions. To be on the safe side it is better to do a bit more work by simplifying fractions even if they don't have to be.

Note for Bash:
input is a string, e.g "2,4,2,6,2,8" output is then "6 12 4 12 3 12"
 */

public class Fracts {

    private static long greatestCommonDivisor(long a, long b) {
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }
    private static long leastCommonMultiple(long a, long b) {
        return a * b / greatestCommonDivisor(a, b);
    }
    public static String convertFrac(long[][] lst) {
        if (lst == null) {
            return "";
        }
        if (lst.length <=0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        long[][] resultLst = new long[lst.length][2];
        for  (int i = 0; i < lst.length; i++) {
            long divisor = greatestCommonDivisor(lst[i][0], lst[i][1]);
            resultLst[i][0] = lst[i][0] / divisor;
            resultLst[i][1] = lst[i][1] / divisor;
        }
        long leastCommonMultipleAll = 1 ;
        for (long[] l : resultLst) {
            leastCommonMultipleAll = leastCommonMultiple(leastCommonMultipleAll, l[1]);
        }
        for (long[] l : resultLst) {
            result.append("(")
                    .append(l[0] * leastCommonMultipleAll / l[1])
                    .append(",")
                    .append(leastCommonMultipleAll)
                    .append(")"
                    );
        }
        return result.toString();
    }

}
