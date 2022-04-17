package problem5;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        // создаём сканер
        Scanner scanner = new Scanner(System.in);
        // читаем число
        int i = scanner.nextInt();
        // номер читаемого разряда
        int r = 0;
        // пока есть хотя бы одна цифра в числе
        while (i > 0) {
            // получаем цифру младшего разряда
            int c = i % 10;
            // выводим разряд и соответствующую ему цифру
            System.out.println(r + ": " + c);
            // увеличиваем номер текущего разряда
            r++;
            // отбрасываем младший разряд числа
            i /= 10;
        }

    }
}
