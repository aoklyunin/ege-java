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
        // максимальный размер файла
        int maxSize = 0;

        // перебираем упорядоченные размеры файлов
        for (int i = 0; i < n; i++) {
            // если добавление
            if (sum + arr[i] <= s) {
                // прибавляем к сумме
                sum += arr[i];
                // т.к. мы перебираем размеры файлов в порядке возрастания,
                // то в переменной maxSize сохранится самый большой размер
                maxSize = arr[i];
            } else
                break;
        }
        // выводим сумму и размер
        System.out.println(sum + " " + maxSize);
    }
}
