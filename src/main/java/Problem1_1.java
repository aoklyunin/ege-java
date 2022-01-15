public class Problem1_1 {

    static int SIZE = 7;

    static int[][] source = new int[][]{
            {0, 0, 0, 9, 0, 0, 7}, // П1
            {0, 0, 0, 5, 0, 11, 0}, // П2
            {0, 0, 0, 0, 0, 12, 0}, // П3
            {9, 5, 0, 0, 4, 13, 15}, // П4
            {0, 0, 0, 4, 0, 10, 8}, // П5
            {0, 11, 12, 13, 10, 0, 0}, // П6
            {7, 7, 0, 15, 8, 0, 0}  // П7
    };

    static char[] names = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж'};
    //       А  Б  В  Г  Д  Е  Ж
    static int[][] target = new int[][]{
            {0, 1, 0, 0, 0, 0, 0}, // A
            {1, 0, 1, 0, 0, 1, 0}, // Б
            {0, 1, 0, 0, 0, 0, 1}, // В
            {0, 0, 0, 0, 1, 0, 1}, // Г
            {0, 0, 0, 1, 0, 1, 0}, // Д
            {0, 1, 0, 0, 1, 0, 1}, // Е
            {0, 1, 1, 1, 1, 1, 0}  // Ж
    };

    static int[] sourceSum = new int[SIZE];
    static int[] targetSum = new int[SIZE];

    static void processPermutation(int[] arr) {
        for (int i = 0; i < SIZE; i++) {
            if (sourceSum[i] != targetSum[arr[i]]) {
                return;
            }
        }
        // нужна ппроверка связности, что при перестановке все связи сохранятся, те не
        // обратятся в ноль
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (target[i][j] > 0 && source[arr[i]][arr[j]] == 0)
                    return;
            }
        }

        System.out.println(source[arr[3]][arr[6]]);
    }

    static void permute(int[] arr, int l, int r) {
        //System.out.println("permute "+Arrays.toString(arr)+" "+l+" "+r);
        // Base case
        if (l == r) {
            processPermutation(arr);
        } else {
            // Permutations made
            for (int i = l; i <= r; i++) {
                // Swapping done
                swap(arr, l, i);
                // Recursion called
                permute(arr, l + 1, r);
                //backtrack
                swap(arr, l, i);
            }
        }
    }

    public static void main(String[] args) {
        permute(new int[]{0, 1, 2, 3, 4, 5, 6}, 0, 6);
    }


    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


}
