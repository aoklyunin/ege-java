package problem25;

public class Example1 {
    public static void main(String[] args) {
        for (int i = 174457; i <= 174505; i++) {
            int dCnt = 0;
            int[] dArr = new int[2];
            for (int d = 2; d < i; d++) {
                if (i % d == 0) {
                    if (dCnt < 2)
                        dArr[dCnt] = d;
                    dCnt++;
                }
            }
            if (dCnt == 2) {
                System.out.println(dArr[0] + " " + dArr[1]);
            }
        }
    }
}
