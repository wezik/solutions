package com.demo.codewars.dubstep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SongTests {
    @Test
    public void Test1() {
        assertEquals("ABC", new Dubstep().SongDecoder("WUBWUBABCWUB"));
    }
    @Test
    public void Test2()
    {
        assertEquals("R L", new Dubstep().SongDecoder("RWUBWUBWUBLWUB"));
    }

    @Test
    public void Test3()
    {
        assertEquals("W U", new Dubstep().SongDecoder("WWUBWUBWUBUWUB"));
    }
    @Test
    public void Test4()
    {
        assertEquals("WUUUUUUUU", new Dubstep().SongDecoder("WUBWUBWUBWUBWUUUUUUUU"));
    }
}
