package problem26;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Example1 {
    // главный метод программы, не забудьте throws FileNotFoundException, иначе программа,
    // работающая с файлом не запустится
    public static void main(String[] args) throws FileNotFoundException {
        // открываем файл, относительный путь строится от корня проекта
        // можно вместо этого закинуть файл куда-нибудь на диск и указать полный путь
        Scanner in = new Scanner(new File("src/main/java/problem26/26.txt"));
        // читаем объём хранилища
        int s = in.nextInt();
        // читаем кол-во файлов
        int n = in.nextInt();

        // создаём массив размеров файла
        int[] arr = new int[n];
        // читаем размеры
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        // сортируем размеры по возрастанию
        Arrays.sort(arr);

        // сумма файлов
        int sum = 0;
        // индекс файла максимального размера
        int posMax = 0;

        // перебираем упорядоченные размеры файлов
        for (int i = 0; i < n; i++) {
            // если добавление
            if (sum + arr[i] <= s) {
                // прибавляем к сумме
                sum += arr[i];
                // т.к. мы перебираем размеры файлов в порядке возрастания,
                // то в переменной posMax сохранится индекс файла, наибольшего размера
                posMax = i;
            } else
                break;
        }

        // сохраняем максимальную сумму
        int max = sum;
        // перебираем все возможные пары элементов массива
        // первый элемент - один из индексов файлов, взятых для сохранения
        // их индексы находятся в диапазоне [0, posMax]
        for (int i = 0; i <= posMax; i++) {
            // второй элемент - один из индексов файлов, не взятых для сохранения
            // их индексы находятся в диапазоне [posMax+1, n)
            for (int j = posMax + 1; j < n; j++) {
                // находим сумму, которая бы получилась, если бы мы не сохранили файл, перебираемый
                // первым циклом и сохранили файл, перебираемый вторым
                int nSum = sum - arr[i] + arr[j];
                // если новая сумма не превышает заданный размер и
                // при этом больше найденной
                if (nSum <= s && nSum > max)
                    // сохраняем её в качестве найденной
                    max = nSum;
            }
        }

        // выводим сумму и размер
        System.out.println(sum + " " + arr[posMax]);
    }
}
