package problem26;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Example2 {
    // главный метод программы, не забудьте throws FileNotFoundException, иначе программа,
    // работающая с файлом не запустится
    public static void main(String[] args) throws FileNotFoundException {
        // открываем файл, относительный путь строится от корня проекта
        // можно вместо этого закинуть файл куда-нибудь на диск и указать полный путь
        Scanner in = new Scanner(new File("src/main/java/problem26/26-59.txt"));

        // словарь записей вида: "номер ряда: упорядоченное множество мест"
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        // читаем кол-во записей
        int n = in.nextInt();
        // читаем сами записи
        for (int i = 0; i < n; i++) {
            // читаем номер ряда
            int r = in.nextInt();
            // читаем номер места
            int v = in.nextInt();
            // если в словаре есть запись с текущим номером ряда
            if (map.containsKey(r)) {
                // получаем ряд
                TreeSet<Integer> row = map.get(r);
                // добавляем номер места в ряд
                row.add(v);
            } else {
                // создаём новый ряд
                TreeSet<Integer> row = new TreeSet<>();
                // добавляем в него место
                row.add(v);
                // добавляем в словарь ряд с ключом, соответствующим его номеру
                map.put(r, row);
            }
        }

        // максимальный номер ряда
        int maxR = 0;
        // минимальный номер места
        int minV = -1;

        // перебираем записи словаря
        for (Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
            // получаем ряд
            TreeSet<Integer> row = entry.getValue();
            // получаем минимальный номер места в ряде
            int l = row.first();
            // получаем максимальный номер места в ряде
            int r = row.last();
            // перебираем все места ряда
            for (int i = l; i <= r; i++) {
                // если текущее место занято и занято через два,
                // значит выполняется условие задачи для места с номером i+1
                if (row.contains(i) && row.contains(i + 3)) {
                    // если номер ряда больше максимального
                    if (entry.getKey() > maxR) {
                        // сохраняем в качестве минимального номера
                        // номер следующего места
                        minV = i + 1;
                        // сохраняем номер ряда
                        maxR = entry.getKey();
                    }
                    // завершаем перебор мест
                    break;
                }
            }
        }

        // выводим номер ряда и номер места
        System.out.println(maxR + " " + minV);


    }
}
