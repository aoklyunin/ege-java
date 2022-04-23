package problem27;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Example3 {
    // максимальная подходящая сумма
    static int maxSum = 0;

    // функция для рекуррентного заполнения массива последовательностями
    // остатков, если при этом все их вычесть из исходной суммы и результат
    // будет делиться на 6, тогда по массиву остатков возьмём
    // столько первых разниц, сколько соответствующих остатков задействовано
    static void process(int pos, int[] arr, int[][] d, int fsum) {
        // если массив остатков полностью заполнен
        if (pos == arr.length) {
            // вычетаем из исходной суммы остатки
            int subs = fsum;
            for (int j : arr) {
                subs -= j;
            }
            // если разность делится на 6
            if (subs % 6 == 0) {
                // номера разностей, которые мы ещё не использовали,
                // пока что все равны 0,
                int[] dPs = new int[6];
                // перебираем массив остатков
                for (int i = 0; i < arr.length; i++) {
                    // если задействованный остаток равен ноль или
                    // мы не встретили достаточное кол-во разниц заданного остатка
                    // и они все кончились
                    if (arr[i] == 0 || d[arr[i]][dPs[i]] == 10000000)
                        // заканчиваем выполнение функции
                        return;
                    // вычитаем из исходной суммы соответствующую разницу
                    fsum -= d[arr[i]][dPs[i]];
                    // говорим, что из массива разниц мы взяли ещё одну
                    dPs[i]++;
                }
                // если новая подходящая сумма больше максимальной
                if (fsum > maxSum)
                    // сохраняем новую сумму в качестве максимальной
                    maxSum = fsum;

            }
        } else
            // на место pos в массиве остатков ставим по очереди все остатки
            for (int i = 0; i < arr.length; i++) {
                // для конкретного варианта ставим на меcто pos остаток, равный i
                arr[pos] = i;
                // запускаем рекурсию для следующего положения
                process(pos + 1, arr, d, fsum);
            }
    }

    // главный метод программы, не забудьте throws FileNotFoundException, иначе программа,
    // работающая с файлом не запустится
    public static void main(String[] args) throws FileNotFoundException {
        // открываем файл, относительный путь строится от корня проекта
        // можно вместо этого закинуть файл куда-нибудь на диск и указать полный путь
        Scanner in = new Scanner(new File("src/main/java/problem27/27-2a.txt"));


        // читаем кол-во чисел
        int n = in.nextInt();
        // создаём массив для подсчёта подмножеств, сумма которых имеет тот
        // или иной остаток от деления на 12
        int[][] d = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                d[i][j] = 10000000;
            }
        }

        // изначально сумма чисел равна 0
        int sum = 0;

        // читаем сами числа
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int delta = Math.abs(a - b);
            int r = delta % 6;

            int pos = 0;
            while (pos < 6 && d[r][pos] <= delta)
                pos++;
            if (pos < 6)
                d[r][pos] = delta;
            sum += Math.max(a, b);
        }

        // если сумма уже делится на 6
        if (sum % 6 == 0) {
            // выводим её
            System.out.println(sum);
            // завершаем работу программы
            return;
        }

        // запускаем перебор остатков
        process(0, new int[]{0, 0, 0, 0, 0, 0}, d, sum);
        // выводим максимальную сумму
        System.out.println(maxSum);


    }
}
