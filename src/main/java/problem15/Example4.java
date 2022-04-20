package problem15;

public class Example4 {
    // операция импликации(следования)
    static boolean impl(boolean a, boolean b) {
        return !a || b;
    }

    public static void main(String[] args) {
        // минимальная длина интервала
        int minRange = 2000;
        // перебираем начало интервала
        for (int A0 = -1000; A0 < 1000; A0++) {
            // перебираем конец интервала
            for (int A1 = A0 + 1; A1 < 1000; A1++) {
                // переменная, отвечающая на вопрос, истинно ли выражение
                // для любых при при заданном A
                boolean f = true;
                // перебираем значения x
                for (int x = -1000; x < 1000; x++) {
                    // если выражение ложно
                    if (!(
                            impl(x >= A0 && x <= A1, x * x <= 64) &&
                                    impl(x * x <= 25, x >= A0 && x <= A1)
                    )) {
                        // помещаем в переменную ответ, что выражение
                        // истинно не для всех x
                        f = false;
                        // заканчиваем перебор x
                        break;
                    }
                }
                // если выражение оказалось истинным для всех x
                if (f) {
                    // если минимальная длина диапазона меньше
                    // длины текущего
                    if (minRange > A1 - A0)
                        // сохраняем новую длину
                        minRange = A1 - A0;
                }
            }
        }
        // выводим минимальную длину диапазона
        System.out.println(minRange);
    }
}