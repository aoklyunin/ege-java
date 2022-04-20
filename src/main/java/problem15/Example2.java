package problem15;

public class Example2 {
    public static void main(String[] args) {
        // перебираем значения A
        for (int A = 1; A < 1000; A++) {
            // переменная, отвечающая на вопрос, истинно ли выражение
            // для любых при при заданном A
            boolean f = true;
            // перебираем значения k
            for (int k = 1; k < 1000; k++) {
                if (!f)
                    break;
                for (int n = 1; n < 1000; n++) {
                    // если выражение ложно
                    if (!((5 * k + 6 * n > 57) || ((k <= A) && (n < A)))) {
                        // помещаем в переменную ответ, что выражение
                        // истинно не для всех x
                        f = false;
                        break;
                    }
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
