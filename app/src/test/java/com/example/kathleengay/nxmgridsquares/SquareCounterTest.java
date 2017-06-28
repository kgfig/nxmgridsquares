package com.example.kathleengay.nxmgridsquares;

import com.example.kathleengay.nxmgridsquares.squares.SquareCounter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tictocproject on 28/06/2017.
 */

public class SquareCounterTest {

    @Test
    public void minTest() {
        final int n = 2;
        final int m = 3;
        assertEquals(n, SquareCounter.min(n, m));
    }

    @Test
    public void countSquaresTest() {
        final int n = 2;
        final int m = 3;
        final int r = 1;
        final int count = 6;
        assertEquals(count, SquareCounter.countSquares(n, m, r));
    }

    @Test
    public void countTotalSquaresTest() {
        final int count = 8;
        final int n = 2;
        final int m = 3;
        assertEquals(count, SquareCounter.countSquares(n, m));
    }
}
