package com.demo.codewars.time_formatter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TimeFormatterTest {
    @Test
    public void exampleTests() {
        assertEquals("1 second", TimeFormatter.formatDuration(1));
        assertEquals("1 minute and 2 seconds", TimeFormatter.formatDuration(62));
        assertEquals("2 minutes", TimeFormatter.formatDuration(120));
        assertEquals("1 hour", TimeFormatter.formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatter.formatDuration(3662));
        assertEquals("23 hours, 32 minutes and 17 seconds", TimeFormatter.formatDuration(84737));
        assertEquals("1 day, 1 hour, 22 minutes and 47 seconds", TimeFormatter.formatDuration(91367));
        assertEquals("1 day, 9 hours, 7 minutes and 42 seconds", TimeFormatter.formatDuration(119262));
        assertEquals("1 hour, 1 minute and 7 seconds", TimeFormatter.formatDuration(3667));
    }
}