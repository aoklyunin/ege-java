package problem1;

import java.util.Arrays;
import java.util.TreeSet;

public class Example2 {

    // кол-во вершин (используется для удобства)
    static int SIZE = 7;

    // названия вершин
    static char[] names = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж'};

    //      П1  П2  П3  П4  П5  П6  П7
    static int[][] source = new int[][]{
            {0, 11, 7, 5, 0, 0, 12}, // П1
            {11, 0, 0, 0, 13, 8, 14}, // П2
            {7, 0, 0, 15, 0, 10, 0}, // П3
            {5, 0, 15, 0, 0, 9, 0}, // П4
            {0, 13, 0, 0, 0, 6, 0}, // П5
            {0, 8, 10, 9, 6, 0, 0}, // П6
            {12, 14, 0, 0, 0, 0, 0}  // П7
    };
    //       А  Б  В  Г  Д  Е  Ж
    static int[][] target = new int[][]{
            {0, 1, 0, 1, 0, 0, 0}, // A
            {1, 0, 1, 1, 0, 1, 0}, // Б
            {0, 1, 0, 0, 0, 1, 0}, // В
            {1, 1, 0, 0, 1, 0, 1}, // Г
            {0, 0, 0, 1, 0, 1, 1}, // Д
            {0, 1, 1, 0, 1, 0, 1}, // Е
            {0, 0, 0, 1, 1, 1, 0}  // Ж
    };

    // степени вершин
    static int[] sourceSum = new int[SIZE];
    static int[] targetSum = new int[SIZE];

    static int findMinDistance(int start, int end, int[] arr) {
        // расстояния от начальной вершины до рассматриваемой
        final int[] distances = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
        // упорядоченное множество, в котором будут лежать индексы вершин графа, которые
        // нам надо обработать
        TreeSet<Integer> toProcess = new TreeSet<>();
        // начинаем с точки Б, поэтому индекс 1
        int currentPoint = start;
        // расстояние от точки до самой себя равно нулю
        distances[currentPoint] = 0;
        // Добавляем в множество вершин на обработку индекс текущей вершины
        toProcess.add(currentPoint);
        // пока множество вершин на обработку не пусто
        while (!toProcess.isEmpty()) {
           // System.out.println("current: " + currentPoint + " " + names[currentPoint]);
            // System.out.println(Arrays.toString(distances));
            //System.out.println(Arrays.toString(m[currentPoint]));
            // удаляем индекс текущей вершины из множества на обработку
            toProcess.remove(currentPoint);
            // перебираем все вершины
            for (int i = 0; i < SIZE; i++) {
                // если у текущей есть с ней ребро
                if (source[arr[currentPoint]][arr[i]] > 0) {
                    // System.out.println(names[arr[i]] + " " + distances[arr[i]] + " " + (distances[arr[currentPoint]] + source[arr[currentPoint]][arr[i]]));
                    // если расстояние при этом равно -1, т.е. мы ещё не обрабатывали эту вершину
                    if (distances[i] == -1)
                        // добавляем её в множество на обработку
                        toProcess.add(i);
                    if (!toProcess.contains(i))
                        continue;
                    // если мы не обрабатывали вершину или новое расстояние через рассматриваемую вершину выше
                    if (distances[i] == -1 || distances[i] > distances[currentPoint] + source[arr[currentPoint]][arr[i]]) {
                        // рассчитываем новое расстояние, как сумму длины пути до текущей вершины
                        // и ребра от текущей вершины до заданной
                        distances[i] = distances[currentPoint] + source[arr[currentPoint]][arr[i]];
                    }
                }
            }
            // если множество на обработку пустое
            if (toProcess.isEmpty())
                // заканчиваем цикл
                break;

            currentPoint = toProcess.first();
        }

        return distances[end];
    }

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

        int minAGDistance = findMinDistance(0, 6, arr);
        // если расстояние ГД меньше ГЕ, то комбинация нам подходит
        if (minAGDistance <= 15) {
            // выводим названия вершин
            for (int i = 0; i < SIZE; i++) {
                System.out.print(names[arr[i]] + " ");
            }
            System.out.println();
            // выводим расстояния
            System.out.println(minAGDistance);
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
