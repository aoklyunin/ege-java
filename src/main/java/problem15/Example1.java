package problem15;

public class Example1 {
    // операция импликации(следования)
    static boolean impl(boolean a, boolean b) {
        return !a || b;
    }

    public static void main(String[] args) {
        // перебираем значения A
        for (int A = 1000; A > 0; A--) {
            // переменная, отвечающая на вопрос, истинно ли выражение
            // для любых при при заданном A
            boolean f = true;
            // перебираем значения x
            for (int x = 1; x < 1000; x++) {
                // если выражение ложно
                if (!(impl(x % A != 0, impl(x % 6 == 0, x % 9 != 0)))) {
                    // помещаем в переменную ответ, что выражение
                    // истинно не для всех x
                    f = false;
                    // заканчиваем перебор x
                    break;
                }
            }
            // если выражение оказалось истинным для всех x
            if (f) {
                // выводим A
                System.out.println(A);
                // заканчиваем перебор
                break;
            }
        }
    }
}
