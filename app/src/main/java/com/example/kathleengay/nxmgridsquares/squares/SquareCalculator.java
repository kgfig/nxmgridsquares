package com.example.kathleengay.nxmgridsquares.squares;

import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by tictocproject on 28/06/2017.
 */

public class SquareCalculator {

    private SquareCalculator() {
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

        for (int r = 1; r < min; r++) {
            count += (n - r - 1) *
                    (m - r - 1);
        }

        return count;
    }

    public static int min(int a, int b) {
        return a < b ? a :
                (a > b ? b : a);
    }

    public static int max(int a, int b) {
        return a > b ? a :
                (a < b ? b : a);
    }
}
