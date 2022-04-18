package problem8;

import java.util.HashSet;

public class Example3 {

    // множество кодов, сделано специально статическим, чтобы
    // сначала получить все перестановки, добавить их в множество,
    // а потом в main() просто выведем его размер
    static HashSet<String> set = new HashSet<>();

    // обработка перестановки
    static void processPermutation(char[] arr) {
        // переменная, которая отвечает на вопрос, подходит ли нам текущая комбинация
        // изначально кладём в неё ответ, правда ли, что первый символ - не 'Ь'
        boolean f = arr[0] != 'Ь';
        // строка с кодом
        String s = "";
        for (int i = 0; i < arr.length - 1; i++) {
            // если текущий символ - 'Ь', а следующий - гласная
            if (arr[i] == 'Ь' && (arr[i + 1] == 'А' || arr[i + 1] == 'У'))
                // тогда комбинация нам не подходит
                f = false;
            // прибавляем текущий символ к строке
            s += arr[i];
        }
        // добавляем последний символ к строке
        s += arr[arr.length - 1];
        // если повторяющихся символов в строке нет
        if (f) {
            // добавляем её в множество
            set.add(s);
        }
    }

    // поменять местами элементы массива arr с индексами l и r
    public static void swap(char[] arr, int l, int r) {
        char tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


    // функция-генератор перестановок
    static void permute(char[] p, int pos) {
        // Если мы дошли до последнего элемента
        if (pos == p.length - 1) {
            processPermutation(p);
        } else { // иначе
            // Перебираем все оставшиеся элементы
            for (int i = pos; i < p.length; i++) {
                // меняем местами текущий элемент и перебираемый
                swap(p, pos, i);
                // Вызываем Рекурсию для следующего элемента
                permute(p, pos + 1);
                // меняем местами обратно
                swap(p, pos, i);
            }
        }
    }

    // главный метод программы
    public static void main(String[] args) {
        // запускаем генерацию перестановок
        permute(new char[]{'В', 'У', 'А', 'Л', 'Ь'}, 0);
        // выводим размер множества
        System.out.println(set.size());
    }

}
