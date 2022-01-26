package problem1;

import java.util.Arrays;

public class Example7 {
    // названия вершин
    static char[] names = {'A', 'B', 'C', 'D', 'E', 'F', 'Z'};
    // кол-во вершин графа
    static int SIZE = 7;
    //       A  B  C  D  E  F  Z
    static int[][] m = new int[][]{
            {0, 4, 6, 0, 0, 0, 30}, // A
            {0, 0, 3, 0, 0, 0, 0}, // B
            {0, 0, 0, 11, 0, 0, 27}, // C
            {0, 0, 0, 0, 4, 7, 10}, // D
            {0, 0, 0, 0, 0, 4, 8}, // E
            {0, 0, 0, 0, 5, 0, 2}, // F
            {29, 0, 0, 0, 0, 0, 0}, // Z
    };

    static int pathCnt = 0;

    static void generatePaths(int currentPoint, int target, int[] inPathPositions, int stepCnt) {
        if (currentPoint == target) {
            if (stepCnt >= 5) {
                pathCnt++;
                int[] pointOrder = new int[SIZE];
                for (int i = 0; i < SIZE; i++) {
                    pointOrder[i] = -1;
                }
                for (int i = 0; i < SIZE; i++) {
                    if (inPathPositions[i] != -1)
                        pointOrder[inPathPositions[i]] = i;
                }
                int realSize = SIZE;
                for (int i = SIZE - 1; i > 0; i--) {
                    if (pointOrder[i] != -1) {
                        realSize = i;
                        break;
                    }
                }

                int pathLength = 0;
                for (int i = 0; i < realSize - 1; i++) {
                    pathLength += m[pointOrder[i]][pointOrder[i + 1]];
                }
                System.out.print(pathLength + ": ");
                // выводим вершины, которые н
                for (int i = 0; i < realSize; i++) {
                    System.out.print(names[pointOrder[i]]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = 0; i < SIZE; i++) {
            if (inPathPositions[i] == -1 && m[currentPoint][i] > 0) {
                int[] copyInPathPositions = Arrays.copyOf(inPathPositions, SIZE);
                copyInPathPositions[i] = stepCnt + 1;
                generatePaths(i, target, copyInPathPositions, stepCnt + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] inPathPositions = new int[SIZE];
        pathCnt = 0;
        for (int i = 0; i < SIZE; i++) {
            inPathPositions[i] = -1;
        }
        int start = 0;
        int target = 6;
        inPathPositions[start] = 0;
        generatePaths(start, target, inPathPositions, 0);
        System.out.println("path cnt: " + pathCnt);
    }
}
