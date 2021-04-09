package com.demo.codewars.duplicatecounter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingDuplicatesTest {

    @Test
    public void emptyReturnsZero() {
        assertEquals(0, CountingDuplicates.duplicateCount(""));
    }

    @Test
    public void abcdeReturnsZero() {
        assertEquals(0, CountingDuplicates.duplicateCount("abcde"));
    }

    @Test
    public void abcdeaaReturnsOne() {
        assertEquals(1, CountingDuplicates.duplicateCount("abcdeaa"));
    }

    @Test
    public void abcdeaBReturnsTwo() {
        assertEquals(2, CountingDuplicates.duplicateCount("abcdeaB"));
    }

    @Test
    public void IndivisibilitiesReturnsTwo() {
        assertEquals(2, CountingDuplicates.duplicateCount("Indivisibilities"));
    }

    @Test
    public void abcdefghijklmnopqrstuvwxyzReturnsZero() {
        assertEquals(0, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void abcdefghijklmnopqrstuvwxyzaaAbReturnsTwo() {
        assertEquals(2, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyzaaAb"));
    }

    @Test
    public void abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzReturnsTwentySix() {
        assertEquals(26, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZReturnsTwentySix() {
        assertEquals(26, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }
}