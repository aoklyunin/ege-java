package problem14;

public class Example3 {
    public static void main(String[] args) {
        // исходное число
        int val = 381;
        // перебираем основания
        for (int i = 32; i >= 0; i--) {
            // создаём строку с представлением перебираемого значения
            //  в системе счиления с основанием i
            String s = Integer.toString(val, i);
            // если число оканчивается на тройку и содержит три цифры
            if (s.charAt(s.length()-1)=='3'&&s.length()==3){
                // выводим основание
                System.out.println(i);
                // останавливаем цикл
                break;
            }
        }
    }
}
