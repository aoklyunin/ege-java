package problem22;


import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int x, L, M, Q;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        Q = 9;
        L = 0;
        while (x >= Q) {
            L = L + 1;
            x = x - Q;
        }
        M = x;
        if (M < L) {
            M = L;
            L = x;
        }
        System.out.println(L);
        System.out.println(M);
    }
}
