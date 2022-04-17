package problem5;

public class Example3 {
    public static void main(String[] args) {
        // перебираем значения
        for (int i = 500; i <= 5000; i++) {
            // создаём строку с двоичным представлением перебираемого значения
            String s = Integer.toString(i,2);
            // обрезаем строку
            s = s.substring(1);
            // переводим обрезанную строку обратно в число, второй
            // аргумент указывает, в какой системе счисления записано число
            int r = Integer.parseInt(s, 2);
            // выводим разность
            System.out.println(i - r);
        }
    }
}
