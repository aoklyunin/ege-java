public class Problem1 {

    // кол-во вершин (используется для удобства)
    static int SIZE = 7;

    // названия вершин
    static char[] names = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж'};

    //      П1  П2  П3  П4  П5  П6  П7
    static int[][] source = new int[][]{
            {0, 10, 15,  0,  0,  0,  0}, // П1
            {10, 0,  0, 13, 17,  0,  0}, // П2
            {15, 0,  0,  0, 19,  0,  9}, // П3
            {0, 14,  0,  0, 10, 20, 11}, // П4
            {0, 17, 19, 10,  0,  0, 20}, // П5
            {0,  0,  0, 20,  0,  0, 25}, // П6
            {0,  0,  9, 11, 20, 25,  0}  // П7
    };
    //       А  Б  В  Г  Д  Е  Ж
    static int[][] target = new int[][]{
            {0, 1, 1, 0, 0, 0, 0}, // A
            {1, 0, 0, 1, 1, 0, 0}, // Б
            {1, 0, 0, 1, 0, 1, 0}, // В
            {0, 1, 1, 0, 1, 1, 0}, // Г
            {0, 1, 0, 1, 0, 1, 1}, // Д
            {0, 0, 1, 1, 1, 0, 1}, // Е
            {0, 0, 0, 0, 1, 1, 0}  // Ж
    };

    // взвешенные степени
    static int[] sourceSum = new int[SIZE];
    static int[] targetSum = new int[SIZE];

    // обработка перестановки
    static void processPermutation(int[] arr) {
        // проверяем, что в представлениях совпадают степени вершин
        for (int i = 0; i < SIZE; i++) {
            if (sourceSum[arr[i]] != targetSum[i]) {
                return;
            }
        }

        // нужна проверка связности, т.е. того, что при перестановке все связи сохраняются, те не
        // обратятся в ноль
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                // если в эталонном представлении связь между вершинами есть,
                // а в данном в задании - нет
                if (target[i][j] > 0 && source[arr[i]][arr[j]] == 0)
                    // заканчиваем выполнение обработчика, потому такая перестановка
                    // создаёт представление, не совместимое с данным, а значит, нас не
                    // интересует
                    return;
            }
        }
        // здесь мы уже выполняем проверку, определённую заданием

        // расстояние между Г и Д
        int gdDistance = source[arr[3]][arr[4]];
        // расстояние между Г и Е
        int geDistance = source[arr[3]][arr[5]];
        // расстояние между А и Б
        int abDistance = source[arr[0]][arr[1]];
        // если расстояние ГД меньше ГЕ, то комбинация нам подходит
        if (gdDistance < geDistance) {
            // выводим названия вершин
            for (int i = 0; i < SIZE; i++) {
                System.out.print(names[arr[i]] + " ");
            }
            System.out.println();
            // выводим расстояния
            System.out.println(abDistance + " " + gdDistance + " " + geDistance);
        }

    }

    // поменять местами элементы массива arr с индексами l и r
    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


    // функция-генератор перестановок
    static void permute(int[] p, int pos) {
        // Если мы дошли до последнего элемента
        if (pos == SIZE - 1) {
            processPermutation(p);
        } else { // иначе
            // Перебираем все оставшиеся элементы
            for (int i = pos; i < SIZE; i++) {
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
        // рассчитываем взвешенные степени
        for (int i = 0; i < SIZE; i++) {
            sourceSum[i] = 0;
            targetSum[i] = 0;
            for (int j = 0; j < SIZE; j++) {
                // в исходном представлении надо не забыть заменить ненулевые веса единицей
                sourceSum[i] += Math.signum(source[i][j]);
                targetSum[i] += target[i][j];
            }
        }
        // запускаем генерацию перестановок
        permute(new int[]{0, 1, 2, 3, 4, 5, 6}, 0);
    }

}
