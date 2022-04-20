package problem15;

public class Example5 {
    // операция импликации(следования)
    static boolean impl(boolean a, boolean b) {
        return !a || b;
    }

    public static void main(String[] args) {
        // перебираем значения A
        for (int a = 1; a < 1000; a++) {
            // переменная, отвечающая на вопрос, истинно ли выражение
            // для любых при при заданном a
            boolean f = true;
            // перебираем значения x
            for (int x = 1; x < 1000; x++) {
                // если выражение ложно
                if (!(((x & 125) != 1) || impl((x & 34) == 2, (x & a) == 0))) {
                    // помещаем в переменную ответ, что выражение
                    // истинно не для всех x
                    f = false;
                    // заканчиваем перебор x
                    break;
                }
            }
            // если выражение оказалось истинным для всех x
            if (f) {
                // выводим a
                System.out.println(a);
                // заканчиваем перебор
                break;
            }
        }
    }
}
