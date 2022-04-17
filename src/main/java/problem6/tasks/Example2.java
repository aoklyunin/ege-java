package problem6.tasks;

import java.util.Scanner;

public class Example2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int d = scanner.nextInt();
        int n = 0;
        int s = 0;
        while (s <= 365) {
            s = s + d;
            n = n + 5;
        }
        System.out.println(n);
    }
}

