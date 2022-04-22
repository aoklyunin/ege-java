package problem24;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Example3 {
    // главный метод программы, не забудьте throws FileNotFoundException, иначе программа,
    // работающая с файлом не запустится
    public static void main(String[] args) throws FileNotFoundException {
        // открываем файл, относительный путь строится от корня проекта
        // можно вместо этого закинуть файл куда-нибудь на диск и указать полный путь
        Scanner in = new Scanner(new File("src/main/java/problem24/24-157.txt"));
        // читаем строку файла
        String s = in.nextLine();
        // кол-во подряд идущих различных отличных от соседей символов
        // изначально длина такой последовательности равна 1
        int cnt = 1;
        // масимальная длина тоде равна 1
        int maxCnt = 1;
        // перебираем все индексы, кроме последнего, потому что
        // будем сравнивать пары
        for (int i = 0; i < s.length() - 1; i++) {
            // если нет сочетания стоящих рядом букв `P` и `R`
            if (!((s.charAt(i) == 'P' && s.charAt(i + 1) == 'R') ||
                    (s.charAt(i) == 'R' && s.charAt(i + 1) == 'P'))) {
                // увеличиваем количество на 1
                cnt++;
            } else { // если текущий символ такой же, как и следующий
                // если количество подряд идущих различных символов
                // больше максимального
                if (cnt > maxCnt) {
                    // сохраняем новое максимальное количество
                    maxCnt = cnt;
                }
                // сбрасываем кол-во подряд идущих различных символов
                cnt = 1;
            }
        }
        // !не забудьте проверить последнее количество различных символов
        // потому что последний символ мог тоже отличаться, и тогда
        // внутри цикла проверку длины его последовательности с максимальной
        // выполнена не будет, ведь она срабатывает только
        // если мы встречаем первый повторяющийся символ
        if (cnt > maxCnt) {
            // сохраняем новое максимальное количество
            maxCnt = cnt;
        }
        // выводим максимальное количество
        System.out.println(maxCnt);

    }
}
