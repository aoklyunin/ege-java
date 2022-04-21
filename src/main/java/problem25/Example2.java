package problem25;

public class Example2 {
    public static void main(String[] args) {
        for (int i = 77777777; i <= 88888888; i++) {
            int dCnt = 0;
            int dMin = i;
            for (int d = 2; d < Math.sqrt(i) + 1; d++) {
                if (i % d == 0)
                    if (d % 2 == 0 || (i / d) % 2 == 0) {
                        dCnt++;
                        if (d < dMin)
                            dMin = d;
                    }
            }
           // System.out.println(i + " " + dCnt);
            if (dCnt == 5) {
                System.out.println(i + " " + dMin+" "+dCnt);
            }
        }
    }
}
