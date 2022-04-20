package problem16;

public class Example1 {
    // функция
    static int F(int n) {
        if (n == 1)
            return 1;
        if (n % 2 == 0)
            return n + 2 + F(n - 1);
        return 2 * F(n - 2);
    }

    public static void main(String[] args) {
        // выводим F(24)
        System.out.println(F(24));
    }
}
