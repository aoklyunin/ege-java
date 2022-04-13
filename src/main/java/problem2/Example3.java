package problem2;

import java.util.Arrays;

public class Example3 {

    // кол-во переменных (используется для удобства)
    static int SIZE = 4;

    static char[] names = {'x', 'y', 'z', 'w'};

    static boolean f(boolean x, boolean y, boolean z, boolean w) {
        return ((x && y) || (y && z)) == (impl(x, w) && impl(w, z));
    }

    static boolean impl(boolean a, boolean b) {
        return !a || b;
    }

    static void processPermutation(int[] p) {
        boolean[] bVals = new boolean[]{false, true};

        boolean[] found = new boolean[]{false, false, false};

        boolean[][] combinations = new boolean[3][];

        int foundCnt = 0;
        for (boolean xV0 : bVals)
            for (boolean yV0 : bVals)
                for (boolean zV0 : bVals)
                    for (boolean wV0 : bVals) {
                        boolean[] values = new boolean[]{
                                xV0, yV0, zV0, wV0
                        };

                        boolean xV = values[p[0]];
                        boolean yV = values[p[1]];
                        boolean zV = values[p[2]];
                        boolean wV = values[p[3]];

                        // System.out.println(xV0 + " " + yV0 + " " + zV0 + " " + wV0);
                        if (f(xV0, yV0, zV0, wV0) && !xV && yV && zV && wV && !found[0]) {
                            found[0] = true;
                            combinations[0] = values;
                            foundCnt++;
                        }
                        if (f(xV0, yV0, zV0, wV0) && !xV && yV && !zV && !found[1]) {
                            found[1] = true;
                            combinations[1] = values;
                            foundCnt++;
                        }
                        if (f(xV0, yV0, zV0, wV0) && !xV && yV && !zV && !found[2]) {
                            found[2] = true;
                            combinations[2] = values;
                            foundCnt++;
                        }
                    }

        if (foundCnt == 3) {
            System.out.println("++++++++++++++++++++++++++++++");
            System.out.println("перестановка: " + Arrays.toString(p));
            for (int i = 0; i < 4; i++) {
                System.out.print(names[p[i]] + " ");
            }
            System.out.println();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print((combinations[i][p[j]] ? 1 : 0) + " ");
                }
                System.out.println();
            }
        }

    }


    // функция-генератор перестановок
    static void permute(int[] p, int pos) {
        // Если мы дошли до последнего элемента
        if (pos == SIZE - 1) {
            processPermutation(p);
        } else { // иначе
            // Перебираем все оставшиеся элементы
            for (int i = pos; i < SIZE; i++) {
                // меняем местами текущий элемент и перебираемый
                swap(p, pos, i);
                // Вызываем Рекурсию для следующего элемента
                permute(p, pos + 1);
                // меняем местами обратно
                swap(p, pos, i);
            }
        }
    }


    // главный метод программы
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3};
        permute(arr, 0);

    }


    // поменять местами элементы массива arr с индексами l и r
    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


    // получить обратную перестановку
    static int[] getReversePermutation(int[] arr) {
        int[] reverse = new int[arr.length];
        for (int i = 0; i < SIZE; i++) {
            reverse[arr[i]] = i;
        }
        return reverse;
    }
}

