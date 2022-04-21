package problem22;

public class Example {
    public static void main(String[] args) {
        int x, L, M, Q;
        for (int i = 1000; i > 0; i--) {
            // нельзя пребирать сам x, потому что
            // он меняется во время выполнения дальнейших команд
            x = i;
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
            // если значения совпадают
            if (L == 4 && M == 5) {
                // выводим значение счётчика
                System.out.println(i);
                break;
            }
        }
    }
}
