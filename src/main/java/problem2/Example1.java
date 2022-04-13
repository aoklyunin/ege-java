package problem2;

import java.util.Arrays;
import java.util.HashSet;

public class Example1 {

    // кол-во переменных (используется для удобства)
    static int SIZE = 4;

    static char[] names = {'x', 'y', 'z', 'w'};

    static int[][] values = new int[][]{
            {1, -1, 1, -1, 1},
            {0, 1, -1, 0, 1},
            {-1, 1, 1, 0, 1}
    };

    static boolean f(boolean x, boolean y, boolean z, boolean w) {
        return (x || y) && (y != z) && !w;
    }

    static boolean impl(boolean a, boolean b) {
        return !a || b;
    }


    static boolean checkValue(boolean xV, boolean yV, boolean zV, boolean wV) {
        return (f(xV, yV, zV, wV) && xV && zV) ||
                (f(xV, yV, zV, wV) && !xV && yV && !wV) ||
                (f(xV, yV, zV, wV) && yV && zV && !wV);

    }

    // главный метод программы
    public static void main(String[] args) {
        boolean[] bVals = new boolean[]{false, true};
        for (boolean xV : bVals)
            for (boolean yV : bVals)
                for (boolean zV : bVals)
                    for (boolean wV : bVals) {
                        System.out.println("______________________________");
                        System.out.println(xV + " " + yV + " " + zV + " " + wV);
                        if (checkValue(xV, yV, zV, wV))
                            System.out.println("> "+xV + " " + yV + " " + zV + " " + wV);
                    }

    }

}
