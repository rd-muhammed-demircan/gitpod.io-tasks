package com.example.demo.algo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlgoMainTest {

    @Test
    void verifyCorrectSum(){
        int x = 5;
        int y = 4;
        int expected = 9;

        int actual = AlgoMain.sum(x, y);

        assertEquals(expected, actual);
    }
}