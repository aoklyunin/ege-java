package problem2;

import java.util.Arrays;

public class Example3 {
    // список перебираемых значений переменной boolean
    static boolean[] booleanValues = new boolean[]{false, true};
    // имена колонок
    static char[] names = {'x', 'y', 'z', 'w'};

    // логическая функция, аргументы которой мы подбираем
    static boolean f(boolean x, boolean y, boolean z, boolean w) {
        return ((x && !y) || impl(w, z)) == (z == x);
    }

    // операция импликации(следования)
    static boolean impl(boolean a, boolean b) {
        return !a || b;
    }

    // проверка значений в линии на совпадение
    static int findLine(boolean xV, boolean yV, boolean zV, boolean wV, boolean f, boolean[][] combinations) {
        if (!yV && !zV && wV && f && combinations[0] == null) {
            return 0;
        }
        if (!xV && yV && !zV && !wV && f && combinations[1] == null) {
            return 1;
        }
        if (!xV && wV && f && combinations[2] == null) {
            return 2;
        }
        return -1;
    }

    // обработка перестановки
    static void processPermutation(int[] p) {
        // найденные комбинации, их три, потому что известных строчек таблицы истинности 3
        boolean[][] combinations = new boolean[16][];
        // кол-во найденных комбинаций
        int foundCombinationCnt = 0;
        // перебираем все варианты значений для каждой логической переменной
        // из таблицы истинности, значений всего два: true и false
        for (boolean xV0 : booleanValues)
            for (boolean yV0 : booleanValues)
                for (boolean zV0 : booleanValues)
                    for (boolean wV0 : booleanValues) {
                        // чтобы использовать перестановку, построим на основе четырёх логических
                        // переменных массив
                        boolean[] values = new boolean[]{
                                xV0, yV0, zV0, wV0
                        };

                        // получим значения логических переменных с учётом перестановки
                        // т.е. мы по сути формируем строку значений, которую потом будем сверять с данной
                        boolean xV = values[p[0]];
                        boolean yV = values[p[1]];
                        boolean zV = values[p[2]];
                        boolean wV = values[p[3]];
                        // ищем подходящую строку таблицы
                        int lineNum = findLine(xV, yV, zV, wV, f(xV0, yV0, zV0, wV0), combinations);
                        // если строка найдена и ещё не сохранена соответствующая этой строке комбинация
                        if (lineNum != -1) {
                            // сохраняем комбинацию
                            combinations[lineNum] = values;
                            foundCombinationCnt++;
                        }
                    }

        if (foundCombinationCnt == 3) {
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
        if (pos == p.length - 1) {
            processPermutation(p);
        } else { // иначе
            // Перебираем все оставшиеся элементы
            for (int i = pos; i < p.length; i++) {
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
        // создаём массив индексов
        int[] arr = new int[]{0, 1, 2, 3};
        // запускаем перебор перестановок
        permute(arr, 0);
    }

    // поменять местами элементы массива arr с индексами l и r
    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

}

