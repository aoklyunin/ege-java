package problem6.tasks;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int n = 1;
        while (s < 51) {
            s = s + 5;
            n = n * 2;
        }
        System.out.println(n);
    }
}
