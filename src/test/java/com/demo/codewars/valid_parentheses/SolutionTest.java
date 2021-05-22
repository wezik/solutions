package com.demo.codewars.valid_parentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void sampleTest() {
        // assertEquals("expected", "actual");
        assertFalse(Solution.validParentheses("("));
        assertTrue(Solution.validParentheses("()"));
        assertFalse(Solution.validParentheses("())"));
        assertTrue(Solution.validParentheses("32423(sgsdg)"));
        assertFalse(Solution.validParentheses("(dsgdsg))2432"));
        assertTrue(Solution.validParentheses("adasdasfa"));
    }
}