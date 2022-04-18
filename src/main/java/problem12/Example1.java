package problem12;

public class Example1 {

    public static void main(String[] args) {
        // создаём строку
        String s = "";
        // добавляем в неё 70 символов '8'
        for (int i = 0; i < 70; i++) {
            s += "8";
        }
        // пока строка содержит "2222" или "8888"
        while (s.contains("2222")||s.contains("8888")){
            // если строка содержит "2222"
            if(s.contains("2222"))
                // заменяем "2222" на "88"
                s = s.replace("2222","88");
            // если строка содержит "8888"
            else
                // заменяем "8888" на "22"
                s = s.replace("8888","22");
        }
        // выводим результат
        System.out.println(s);

    }
}
