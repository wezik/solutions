package com.demo.codewars.persistent_bugger;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import static org.junit.jupiter.api.Assertions.*;

public class PersistTest {

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals(3, Persist.persistence(39));
        assertEquals(0, Persist.persistence(4));
        assertEquals(2, Persist.persistence(25));
        assertEquals(4, Persist.persistence(999));
    }

}