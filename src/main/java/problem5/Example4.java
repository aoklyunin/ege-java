package problem5;

import java.util.HashSet;

public class Example4 {
    public static void main(String[] args) {
        // множество значений
        HashSet<Integer> values = new HashSet<>();
        // перебираем значения
        for (int i = 500; i <= 5000; i++) {
            // создаём строку с двоичным представлением перебираемого значения
            String s = Integer.toString(i, 2);
            // обрезаем строку
            s = s.substring(1);
            // переводим обрезанную строку обратно в число, второй
            // аргумент указывает, в какой системе счисления записано число
            int r = Integer.parseInt(s, 2);
            // добавляем разность
            values.add(i - r);
        }
        // перебираем все значения множества
        for (Integer value : values) {
            // выводим каждое с новой строки
            System.out.println(value);
        }
    }
}
