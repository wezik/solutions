package com.demo.codewars.time_formatter;

/*
Your task in order to complete this Kata is to write a function which formats a duration, given as a number of seconds,
in a human-friendly way.

The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration is
expressed as a combination of years, days, hours, minutes and seconds.

It is much easier to understand with an example:

TimeFormatter.formatDuration(62)   //returns "1 minute and 2 seconds"
TimeFormatter.formatDuration(3662) //returns "1 hour, 1 minute and 2 seconds"
For the purpose of this Kata, a year is 365 days and a day is 24 hours.

Note that spaces are important.

Detailed rules
The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and one of
the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.

The components are separated by a comma and a space (", "). Except the last component, which is separated by " and ",
just like it would be written in English.

A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1 year is not
correct, but 1 year and 1 second is.

Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.

A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid, but it
should be just 1 minute.

A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1 minute
and 1 second instead. Formally, the duration specified by of a component must not be greater than any valid more
significant unit of time.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimeFormatter {

    private static final int MINUTE_IN_SECONDS = 60;
    private static final int HOUR_IN_SECONDS = 60 * MINUTE_IN_SECONDS;
    private static final int DAY_IN_SECONDS = 24 * HOUR_IN_SECONDS;
    private static final int YEAR_IN_SECONDS = 365 * DAY_IN_SECONDS;

    public static String formatDuration(int seconds) {
        if (seconds < 1) return "now";
        int n = seconds;
        int sec = 0, minutes = 0, hours = 0, days = 0, years = 0;

        while(n>0) {
            if (YEAR_IN_SECONDS <= n) {
                years++;
                n -= YEAR_IN_SECONDS;
            } else if (DAY_IN_SECONDS <= n) {
                days++;
                n -= DAY_IN_SECONDS;
            } else if (HOUR_IN_SECONDS <= n) {
                hours++;
                n -= HOUR_IN_SECONDS;
            } else if (MINUTE_IN_SECONDS <= n) {
                minutes++;
                n -= MINUTE_IN_SECONDS;
            } else {
                sec = n;
                n = 0;
            }
        }

        List<String> resultList = new ArrayList<>();

        if (years > 0) resultList.add(years + " year" + (years == 1 ? "" : "s"));
        if (days > 0) resultList.add(days + " day" + (days == 1 ? "" : "s"));
        if (hours > 0) resultList.add(hours + " hour" + (hours == 1 ? "" : "s"));
        if (minutes > 0) resultList.add(minutes + " minute" + (minutes == 1 ? "" : "s"));
        if (sec > 0) resultList.add(sec + " second" + (sec == 1 ? "" : "s"));

        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0; i<resultList.size()-1; i++) {
            if (stringBuilder.length()!=0) stringBuilder.append(", ");
            stringBuilder.append(resultList.get(i));
        }
        if (stringBuilder.length()!=0) stringBuilder.append(" and ");
        if (resultList.size()!=0) stringBuilder.append(resultList.get(resultList.size()-1));

        return stringBuilder.toString();
    }

}
