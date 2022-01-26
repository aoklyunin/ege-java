package problem1;

public class Example9 {
    // названия вершин
    static char[] names = {'A', 'B', 'C', 'D', 'E', 'F'};
    // кол-во вершин графа
    static int SIZE = 6;
    //       A  B  C  D  E  F
    static int[][] m = new int[][]{
            {0, 2, 4, 0, 0, 0}, // A
            {2, 0, 1, 0, 7, 0}, // B
            {4, 1, 0, 3, 4, 0}, // C
            {0, 0, 3, 0, 3, 0}, // D
            {0, 7, 4, 3, 0, 2}, // E
            {0, 0, 0, 0, 2, 0}, // F
    };

    static int findMinDistance(int start, int end) {
        // заполняем расстояния от начальной вершины до рассматриваемой значениями -1
        int[] distances = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            distances[i] = -1;
        }
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
        return distances[end];
    }

    public static void main(String[] args) {
        System.out.println(findMinDistance(0, 5));
    }
}
