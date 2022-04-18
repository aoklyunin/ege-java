package problem12;

public class Example2 {

    public static void main(String[] args) {
        // создаём строку
        String a = "ПОЕЗД";
        int i = a.length();
        int k = 2;
        String b = "А";
        while (i > 0) {
            char c = a.charAt(i-1);
            b = b + c;
            i = i - k;
        }
        b = b + "Т";
        // выводим результат
        System.out.println(b);
    }
}
