package problem2;

import java.util.Arrays;
import java.util.HashSet;

public class OldExample {

    // кол-во переменных (используется для удобства)
    static int SIZE = 4;

    static char[] names = {'x', 'y', 'z', 'w'};

    static int[][] values = new int[][]{
            {1, -1, 1, -1, 1},
            {0, 1, -1, 0, 1},
            {-1, 1, 1, 0, 1}
    };

    static boolean[][] combinations;

    static int currentCombinationCnt;

//    static int [] getChoose(int cnt, int fullSize){
//        int [] res = new int[cnt];
//        Math.
//    }

    // получить обратную перестановку
    static int[] getReversePermutation(int[] arr) {
        int[] reverse = new int[arr.length];
        for (int i = 0; i < SIZE; i++) {
            reverse[arr[i]] = i;
        }
        return reverse;
    }

    static boolean impl(boolean a, boolean b) {
        return !a || b;
    }


    static boolean f(boolean x, boolean y, boolean z, boolean w) {
        return ((x && !y) || (impl(w, z))) == (z == x);
    }

    static void showTable(int[] p, int[] c) {
        // получаем обратную перестановку
        int[] reverse = getReversePermutation(p);
        // выводим названия вершин
        for (int i = 0; i < SIZE; i++) {
            System.out.print(names[reverse[i]] + " ");
        }
        System.out.println();
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (values[i][j] != -1 && (combinations[c[i]][p[j]] ^ (values[i][j] == 1)))
                    return;
            }
            boolean xValue = combinations[c[i]][p[0]];
            boolean yValue = combinations[c[i]][p[1]];
            boolean zValue = combinations[c[i]][p[2]];
            boolean wValue = combinations[c[i]][p[3]];
            System.out.println((xValue?1:0)+" "+(yValue?1:0)+" "+(zValue?1:0)+" "+(wValue?1:0)+" "+(f(xValue, yValue, zValue, wValue)?1:0));
        }
    }


    // обработка перестановки
    static void processPermutation(int[] p, int[] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (values[i][j] != -1 && (combinations[c[i]][p[j]] ^ (values[i][j] == 1)))
                    return;
            }
            boolean xValue = combinations[c[i]][p[0]];
            boolean yValue = combinations[c[i]][p[1]];
            boolean zValue = combinations[c[i]][p[2]];
            boolean wValue = combinations[c[i]][p[3]];
            if (f(xValue, yValue, zValue, wValue) ^ (values[i][SIZE] == 1))
                return;
        }
        System.out.println("====================================");
        showTable(p, c);
        //System.out.println(Arrays.toString(p) + "\n" + Arrays.toString(c));
        //System.out.println("=================================");
    }

    // функция-генератор перестановок
    static void permute(int[] p, int pos, int[] choose) {
        // Если мы дошли до последнего элемента
        if (pos == SIZE - 1) {
            processPermutation(p, choose);
        } else { // иначе
            // Перебираем все оставшиеся элементы
            for (int i = pos; i < SIZE; i++) {
                // меняем местами текущий элемент и перебираемый
                swap(p, pos, i);
                // Вызываем Рекурсию для следующего элемента
                permute(p, pos + 1, choose);
                // меняем местами обратно
                swap(p, pos, i);
            }
        }
    }

    // обработка перестановки
    static void processChoose(int[] choose) {
        // запускаем генерацию перестановок
        permute(new int[]{0, 1, 2, 3}, 0, choose);
    }

    // функция-генератор перестановок
    static void choose(int[] c, int pos, int size) {
        // Если мы дошли до последнего элемента
        if (pos == c.length) {
            if (isUnique(c))
                processChoose(c);
        } else { // иначе
            // Перебираем все индексы
            for (int i = 0; i < size; i++) {
                // делаем текущий элемент выборки равным счётчику цикла
                c[pos] = i;
                // Вызываем Рекурсию для следующего элемента
                choose(c, pos + 1, size);
            }
        }
    }

    // главный метод программы
    public static void main(String[] args) {
        // запускаем генерацию перестановок
        int combinationCnt = (int) Math.pow(2, SIZE);
        // Рассчитываем комбинации
        combinations = new boolean[combinationCnt][SIZE];
        currentCombinationCnt = 0;
        combine(new boolean[]{false, false, false, false}, 0, new boolean[]{true, false});

        int[] initPermuteArr = new int[values.length];
        Arrays.fill(initPermuteArr, -1);
        choose(initPermuteArr, 0, combinationCnt);
    }

    static void processCombination(boolean[] combination) {
        combinations[currentCombinationCnt] = Arrays.copyOf(combination, combination.length);
        currentCombinationCnt++;
    }

    static void combine(boolean[] combination, int pos, boolean[] dataset) {
        // Если мы дошли до последнего элемента
        // Обратите внимание: здесь, в отличие от перестановок нам
        // нужно выполнить на один шаг больше, потому что мы перебираем все возможные
        // значения для каждого из элементов, в перестановках другая логика
        if (pos == SIZE) {
            processCombination(combination);
        } else {
            // Перебираем все элементы массива-источника
            for (int i = 0; i < dataset.length; i++) {
                // подставляем на текущее место в массив этот элемент
                combination[pos] = dataset[i];
                // и запускаем рекурсию на следующем шаге
                combine(combination, pos + 1, dataset);
            }
        }
    }

    // поменять местами элементы массива arr с индексами l и r
    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    public static int getFactorial(int f) {
        int result = 1;
        for (int i = 2; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    static int[] getInitPermuteArr(int size) {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = i;
        }
        return res;
    }

    static boolean isUnique(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        return set.size() == arr.length;
    }

}
