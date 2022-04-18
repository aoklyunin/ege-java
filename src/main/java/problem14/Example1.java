package problem14;

import java.math.BigInteger;

public class Example1 {
    public static void main(String[] args) {
        // первое значение
        BigInteger value1 = BigInteger.valueOf(49).pow(7);
        // второе значение
        BigInteger value2 = BigInteger.valueOf(7).pow(21);
        // третье
        BigInteger value3 = BigInteger.valueOf(7);
        // вычисляем результат
        BigInteger result = value1.add(value2).subtract(value3);
        // формируем строку представляющее число в семеричной системе счисления
        String resultString = result.toString(7);
        // кол-во нужных цифр 0
        int cnt = 0;
        // перебираем все цифры
        for (char c : resultString.toCharArray()) {
            // если цифра равна 6
            if (c == '6')
                // увеличиваем кол-во на 1
                cnt++;
        }
        // выводим кол-во символов
        System.out.println(cnt);
    }
}
