package problem2;


public class Example1 {
    // список перебираемых значений переменной boolean
    static boolean[] booleanValues = new boolean[]{false, true};

    // логическая функция, аргументы которой мы подбираем
    static boolean f(boolean x, boolean y, boolean z) {
        return impl(x, y) && impl(y, z);
    }

    // операция импликации(следования)
    static boolean impl(boolean a, boolean b) {
        return !a || b;
    }

    // главный метод программы
    public static void main(String[] args) {
        // выводим заголовок
        System.out.println("x y z");
        // перебираем все наборы значений
        for (boolean xV0 : booleanValues)
            for (boolean yV0 : booleanValues)
                for (boolean zV0 : booleanValues)
                        // если функция даёт ложь
                        if (!f(xV0, yV0, zV0))
                            // выводим этот набор аргументов
                            System.out.println(
                                    (xV0 ? 1 : 0) + " " + (yV0 ? 1 : 0) + " " + (zV0 ? 1 : 0)
                            );

    }
}

