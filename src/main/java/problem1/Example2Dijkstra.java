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
        // заполняем расстояния от начальной вершины до рассматриваемой значениями -1
        int[] distances = new int[SIZE];
        Arrays.fill(distances,-1);
        // начинаем с точки Б, поэтому индекс 1
        int currentPoint = 1;
        // расстояние от точки до самой себя равно нулю
        distances[currentPoint] = 0;
        // массив флагов, закончена ли проверка для заданной точки
        boolean[] complete = new boolean[SIZE];
        // пока есть следующая точка
        while (currentPoint != -1) {
            System.out.println("current: " + currentPoint + " " + names[currentPoint]);
            System.out.println(Arrays.toString(distances));
            // перебираем все вершины
            for (int i = 0; i < SIZE; i++) {
                if (i == currentPoint || complete[i])
                    continue;
                // если у текущей есть с ней ребро
                if (m[currentPoint][i] > 0) {
                    // если мы не обрабатывали вершину или новое расстояние через рассматриваемую вершину выше
                    if (distances[i] == -1 || distances[i] > distances[currentPoint] + m[currentPoint][i]) {
                        // рассчитываем новое расстояние, как сумму длины пути до текущей вершины
                        // и ребра от текущей вершины до заданной
                        distances[i] = distances[currentPoint] + m[currentPoint][i];
                    }
                }
            }
            complete[currentPoint] = true;
            // ищем следующую точку
            int nextPoint = -1;
            for (int i = 0; i < SIZE; i++) {
                // если обработка точки не завершена
                if (!complete[i])
                    // если мы уже доходили до точки и следующая точка ещё не задана или
                    // новое расстояние меньше
                    if (distances[i] > 0 && (nextPoint == -1 || distances[i] < distances[nextPoint])) {
                        nextPoint = i;
                    }

            }
            // переходим к следующей точке
            currentPoint = nextPoint;

            //    System.out.println("set cp: " + currentPoint);
        }

        System.out.println(Arrays.toString(distances));
        // Выводим расстояние от Б до Ж
        System.out.println(distances[6]);
    }
}
