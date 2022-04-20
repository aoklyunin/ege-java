package problem16;

public class Example2 {
    // кол-во звёздочек
    static int cnt = 0;

    // функция
    static void F( int n )
    {
        cnt++;
        if( n >= 1 ) {
            cnt++;
            F(n-1);
            F(n-2);
            F(n-3);
        }
    }

    public static void main(String[] args) {
        // запускае F(22)
        F(22);
        // выводим кол-во звёздочек
        System.out.println(cnt);
    }
}
