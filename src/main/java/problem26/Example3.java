package problem26;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class Example3 {
    // главный метод программы, не забудьте throws FileNotFoundException, иначе программа,
    // работающая с файлом не запустится
    public static void main(String[] args) throws FileNotFoundException {
        // открываем файл, относительный путь строится от корня проекта
        // можно вместо этого закинуть файл куда-нибудь на диск и указать полный путь
        Scanner in = new Scanner(new File("src/main/java/problem26/26-57.txt"));
        // создаём упорядоченное мн-во длин кусков кабеля
        TreeSet<Integer> set = new TreeSet<>();
        // получаем кол-во кусков
        int n = in.nextInt();
        // получаем требуемую длину
        int m = in.nextInt();
        // читаем длины кусков кабеля
        for (int i = 0; i < n; i++) {
            // получаем значение
            int w = in.nextInt();
            // добавляем его в множество
            set.add(w);
        }

        // кол-во сварок
        int sCnt = 0;
        // кол-во оставшихся кусков
        int rCnt = 0;
        // пока в множестве есть элементы
        while (!set.isEmpty()) {
            // сумма длин для нового блока
            int sum = 0;
            // кол-во использованных блоков
            int eCnt = 0;
            // пока суммарная длина меньше заданной и есть элементы в множестве
            while (sum < m && !set.isEmpty()) {
                // получаем самый большой элемент множества, т.е. берём
                // кусок кабеля самой большой длины
                int e = set.pollLast();
                // добавляем его к суммарной длине
                sum += e;
                // увеличиваем кол-во взятых кусков на 1
                eCnt++;
            }
            // если в итоге сумма меньше требуемой длины,
            // значит, куски кабеля кончились, при этом их количество лежит в eCnt
            if (sum < m) {
                // просто сохраняем оставшееся количество
                rCnt = eCnt;
                // завершаем цикл
                break;
            } else { // если суммарная длина больше или равна требуемой
                // получаем длину остатка
                int nE = sum - m;
                // добавляем его в множество
                set.add(nE);
                // прибавляем к количеству сварок число сварок для этого блока
                // она на 1 меньшее числа кусков, ведь в сварке всегда участвует два блока
                sCnt += eCnt - 1;
            }
        }
        // выводим кол-во сварных швов и кол-во оставшихся кусков
        System.out.println(sCnt + " " + rCnt);
    }
}
