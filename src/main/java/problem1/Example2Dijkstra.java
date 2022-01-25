package problem1;

import java.util.*;

public class Example2Dijkstra {

    public static void main(String[] args) {
        // кол-во вершин графа
        int SIZE = 8;
        //       А  Б  В  Г  Д  Е  Ж  З
        int[][] m = new int[][]{
                {0, 5, 0, 2, 4, 0, 0, 0}, // А
                {0, 0, 0, 5, 0, 0, 7, 2}, // Б
                {0, 0, 0, 0, 0, 0, 0, 8}, // В
                {0, 0, 0, 0, 0, 0, 1, 0}, // Г
                {0, 0, 3, 0, 0, 0, 0, 0}, // Д
                {0, 0, 0, 0, 0, 0, 2, 0}, // Е
                {0, 0, 0, 0, 0, 0, 0, 0}, // Ж
                {0, 0, 0, 0, 0, 4, 0, 0}, // З
        };
        // названия вершин
        char[] names = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З'};
        // расстояния от начальной вершины до рассматриваемой
        int[] distances = new int[]{-1, -1, -1, -1, -1, -1, -1, -1};
        // упорядоченное множество, в котором будут лежать индексы вершин графа, которые
        // нам надо обработать
        TreeSet<Integer> toProcess = new TreeSet<>();
        // начинаем с точки Б, поэтому индекс 1
        int currentPoint = 1;
        // расстояние от точки до самой себя равно нулю
        distances[currentPoint] = 0;
        // Добавляем в множество вершин на обработку индекс текущей вершины
        toProcess.add(currentPoint);
        // пока множество вершин на обработку не пусто
        while (!toProcess.isEmpty()) {
            System.out.println("current: " + names[currentPoint]);
            System.out.println(Arrays.toString(distances));
            //System.out.println(Arrays.toString(m[currentPoint]));
            // удаляем индекс текущей вершины из множества на обработку
            toProcess.remove(currentPoint);
            // перебираем все вершины
            for (int i = 0; i < SIZE; i++) {
                // если у текущей есть с ней ребро
                if (m[currentPoint][i] > 0) {
                    System.out.println(names[i] + " " + distances[i] + " " + (distances[currentPoint] + m[currentPoint][i]));
                    // если расстояние при этом равно -1, т.е. мы ещё не обрабатывали эту вершину
                    if (distances[i] == -1)
                        // добавляем её в множество на обработку
                        toProcess.add(i);
                    // если текущего элемента нет в множестве на рассмотрение, переходим к
                    // следующему
                    if (!toProcess.contains(i))
                        continue;
                    // если мы не обрабатывали вершину или новое расстояние через рассматриваемую вершину выше
                    if (distances[i] == -1 || distances[i] > distances[currentPoint] + m[currentPoint][i])
                        // рассчитываем новое расстояние, как сумму длины пути до текущей вершины
                        // и ребра от текущей вершины до заданной
                        distances[i] = distances[currentPoint] + m[currentPoint][i];
                }
            }
            // если множество на обработку пустое
            if (toProcess.isEmpty())
                // заканчиваем цикл
                break;

            // делаем текущей вершиной первый элемент множества на обработку
            currentPoint = toProcess.first();
        }

        System.out.println(Arrays.toString(distances));
        // Выводим расстояние от Б до Ж
        System.out.println(distances[6]);
    }
}
