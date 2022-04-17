package problem6;

public class Example1 {
    public static void main(String[] args) {
        // перебираем значения переменной s
        for (int i = 0; i < 100000; i++) {
            int s = i;
            int n = 1;
            while (s < 51) {
                s = s + 5;
                n = n * 2;
            }
            // если ответ совпал
            if (n == 64) {
                // выводим необходимое значение i
                System.out.println(i);
                // завершаем перебор
                break;
            }
        }
    }
}
