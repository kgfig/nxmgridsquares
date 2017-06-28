package com.example.kathleengay.nxmgridsquares.squares;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

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
    public static int countSquares(int n, int m) {
        int min = min(n, m);
        int count = 0;

        for (int r = 1; r <= min; r++) {
            count += countSquares(n, m, r);
        }

        return count;
    }

    public static int countSquares(int n, int m, int r) {
        return (n - (r - 1)) * (m - (r - 1));
    }

    public static int min(int a, int b) {
        return a < b ? a :
                (a > b ? b : a);
    }

}
