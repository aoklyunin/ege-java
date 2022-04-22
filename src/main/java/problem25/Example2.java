package problem25;

public class Example2 {
    public static void main(String[] args) {
        // кол-во найденных чисел изначально равно 0
        int cnt = 0;
        // перебираем числа от 520000 до очень большого, я просто умножил на 10 исходное
        // если не хватит, просто увеличьте верхнюю границу перебора
        for (int i = 520000; i <= 5200000; i++) {
            // сумма делителей
            int sum = 0;
            // максимальный делитель
            int maxD = 1;
            // перебираем числа от [2;i-1]
            for (int d = 2; d < i; d++) {
                // если d - делитель i
                if (i % d == 0) {
                    // прибавляем делитель к сумме
                    sum += d;
                    // т.к. мы перебираем делители в порядке возрастания,
                    // то последний сохранённый будет максимальным
                    maxD = d;
                }
            }
            // если число простое
            if (sum == 0)
                // переходим к следующему шагу цикла
                continue;

            // формируем строку из числа
            String s = sum + "";
            // переменная, отвечающая на вопрос, является ли строка палиндромом
            boolean p = true;
            // перебираем все элементы строки до середины, если их нечётное число, то
            // центральный элемент уже не перебираетс
            for (int j = 0; j < s.length() / 2; j++) {
                // если перебираемый элемент и зеркальный ему во второй половине строки
                // не совпадают
                if (s.charAt(j) != s.charAt(s.length() - 1 - j)) {
                    // строка не может быть палиндромом
                    p = false;
                    // завершаем перебор символов строки
                    break;
                }
            }
            // если строка - палиндром
            if (p) {
                // выводим число, выводим
                System.out.println(i + " " + maxD);
                // увеличиваем кол-во найденных чисел на 1
                cnt++;
                // если найдено пять и больше
                if (cnt >= 5)
                    // завершаем цикл
                    break;
            }
        }
    }
}