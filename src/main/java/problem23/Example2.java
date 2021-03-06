package problem23;

public class Example2 {

    // кол-во подходящих программ
    static int cnt = 0;

    // следующий ход, value - текущее значение, met8 - ответ на вопрос, встречено ли число 8,
    // met10 - ответ на вопрос, встречено ли число 10
    static void next(int value, boolean met8, boolean met10) {
        // если значение больше целевого, то оно точно не встретится
        if (value > 12)
            // поэтому завершаем выполнение программы
            return;
        // если значение равно целевому
        if (value == 12) {
            // если при этом встречено число 10
            if (met8 && met10)
                // увеличиваем счётчик подходящих программ на 1
                cnt++;
            return;
        }
        // если значение равно 10
        if (value == 10)
            // говорим, что число 10 встречено
            met10 = true;
        // если значение равно 8
        if (value == 8)
            // говорим, что число 8 встречено
            met8 = true;
        // увеличиваем значение на 1 и запускаем обработку следующего хода
        next(value + 1, met8, met10);
        // увеличиваем значение на 2 и запускаем обработку следующего хода
        next(value + 2, met8, met10);
        // умножаем значение на 3 и запускаем обработку следующего хода
        next(value * 3, met8, met10);
    }

    public static void main(String[] args) {
        // запускаем программу для значения 1
        next(2, false, false);
        // выводим количество подходящих программ
        System.out.println(cnt);
    }
}
