package problem14;

import java.math.BigInteger;

public class Example2 {
    public static void main(String[] args) {
        // первое значение
        BigInteger value1 = BigInteger.valueOf(4).pow(512);
        // второе значение
        BigInteger value2 = BigInteger.valueOf(8).pow(512);
        // третье
        BigInteger value3 = BigInteger.valueOf(2).pow(128);
        // четвёртое
        BigInteger value4 = BigInteger.valueOf(250);


        // вычисляем результат
        BigInteger result = value1.add(value2).subtract(value3).subtract(value4);

        // формируем строку представляющее число в семеричной системе счисления
        String resultString = result.toString(2);
        // кол-во нужных цифр 0
        int cnt = 0;
        // перебираем все цифры
        for (char c : resultString.toCharArray()) {
            // если цифра равна 6
            if (c == '0')
                // увеличиваем кол-во на 1
                cnt++;
        }
        // выводим кол-во символов
        System.out.println(cnt);
    }
}
