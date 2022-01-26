package problem1;

import java.util.Arrays;

public class Example6 {
    // кол-во вершин графа
    static int SIZE = 6;
    //       A  B  C  D  E  F
    static int[][] m = new int[][]{
            {0, 2, 4, 8, 0, 16}, // A
            {2, 0, 0, 3, 0, 0}, // B
            {4, 0, 0, 3, 0, 0}, // C
            {8, 3, 3, 0, 5, 3}, // D
            {0, 0, 0, 5, 0, 5}, // E
            {16, 0, 0, 3, 5, 0}, // F
    };

    static int findMinDistance(int start, int end, int skipPoint) {
        // заполняем расстояния от начальной вершины до рассматриваемой значениями -1
        int[] distances = new int[SIZE];
        Arrays.fill(distances,-1);
        // начинаем с точки Б, поэтому индекс 1
        int currentPoint = start;
        // расстояние от точки до самой себя равно нулю
        distances[currentPoint] = 0;
        // массив флагов, закончена ли проверка для заданной точки
        boolean[] complete = new boolean[SIZE];
        // пока есть следующая точка
        while (currentPoint != -1) {
           // System.out.println("current: " + currentPoint + " " + names[currentPoint]);
         //   System.out.println(Arrays.toString(distances));
            // перебираем все вершины
            for (int i = 0; i < SIZE; i++) {
                if (i == currentPoint || i == skipPoint || complete[i])
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
        return distances[end];
    }

    public static void main(String[] args) {
        int part1 = findMinDistance(0, 4, 1);
        int part2 = findMinDistance(4, 5, 1);
        System.out.println(part1 + part2);
    }
}
