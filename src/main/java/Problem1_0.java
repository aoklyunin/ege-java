public class Problem1_0 {

    static int SIZE = 7;

    static char[] names = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж'};

    static int[] sourceSum = new int[SIZE];
    static int[] targetSum = new int[SIZE];

    static void processPermutation(int [][] target, int [][] source, int[] arr) {
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

        int gdDistance = source[arr[3]][arr[4]];
        int geDistance = source[arr[3]][arr[5]];
        int abDistance = source[arr[0]][arr[1]];
        if (gdDistance > 0 && geDistance > 0 && gdDistance < geDistance) {
            for (int i = 0; i < SIZE; i++) {
                System.out.print(names[arr[i]] + " ");
            }
            System.out.println();
            System.out.println(abDistance + " " + gdDistance + " " + geDistance);
        }

    }

    static void permute(int [][] target, int [][] source,int[] arr, int l, int r) {
        //System.out.println("permute "+Arrays.toString(arr)+" "+l+" "+r);
        // Base case
        if (l == r) {
            processPermutation(target,source,arr);
        } else {
            // Permutations made
            for (int i = l; i <= r; i++) {
                // Swapping done
                swap(arr, l, i);
                // Recursion called
                permute(target,source,arr, l + 1, r);
                //backtrack
                swap(arr, l, i);
            }
        }
    }

    public static void main(String[] args) {
        //       Пz1  П2  П3  П4  П5  П6  П7
        int [][] source = new int[][]{
                {0 , 10, 15, 0 , 0 , 0 , 0 }, // П1
                {10, 0 , 0 , 13, 17, 0 , 0 }, // П2
                {15, 0 , 0 , 0 , 19, 0 , 9 }, // П3
                {0 , 14, 0 , 0 , 10, 20, 11}, // П4
                {0 , 17, 19, 10, 0 , 0 , 20}, // П5
                {0 , 0 , 0 , 20, 0 , 0 , 25}, // П6
                {0 , 0 , 9 , 11, 20, 25, 0 }  // П7
        };
        //       А  Б  В  Г  Д  Е  Ж
        int [][] target = new int[][]{
                {0, 1, 1, 0, 0, 0, 0}, // A
                {1, 0, 0, 1, 1, 0, 0}, // Б
                {1, 0, 0, 1, 0, 1, 0}, // В
                {0, 1, 1, 0, 1, 1, 0}, // Г
                {0, 1, 0, 1, 0, 1, 1}, // Д
                {0, 0, 1, 1, 1, 0, 1}, // Е
                {0, 0, 0, 0, 1, 1, 0}  // Ж
        };


        permute(target, source, new int[]{0, 1, 2, 3, 4, 5, 6}, 0, 6);
    }


    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


}
