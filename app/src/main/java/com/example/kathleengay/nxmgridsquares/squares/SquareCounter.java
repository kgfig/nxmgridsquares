package com.example.kathleengay.nxmgridsquares.squares;

/**
 * Created by tictocproject on 28/06/2017.
 */

public class SquareCounter {

    private SquareCounter() {
    }

    /**
     * Returns the total number of squares of an nxm grid
     *
     * @param n width
     * @param m height
     * @return
     */
    public static int countAllSquares(int n, int m) {
        int min = Math.min(n, m);
        int count = 0;

        for (int r = 1; r <= min; r++) {
            count += countRxRSquares(n, m, r);
        }

        return count;
    }

    /**
     * Returns the number of rxr squares in an nxm grid
     * @param n
     * @param m
     * @param r
     * @return the number of rxr squares in an nxm grid
     */
    public static int countRxRSquares(int n, int m, int r) {
        return (n - (r - 1)) * (m - (r - 1));
    }

}
