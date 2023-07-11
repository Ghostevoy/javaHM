import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class homework2 {
    public static void main(String[] args) {
        String string = stringRead(new File("file1.txt"));
        System.out.println(string);
        whereSelect(string);
    }

    static String stringRead(File file) {
        String newstring = "";
        try {
            FileReader reader = new FileReader(file);
            StringBuilder builder = new StringBuilder();
            int c;
            while ((c = reader.read()) != -1) {
                builder.append((char) c);
            }
            return newstring = builder.toString();
        } catch (IOException e) {
            System.out.println("Произошла ошибка при парсинге строки.");
        }
        return newstring;
    }

    static void whereSelect(String string) {
        StringBuilder somestring = new StringBuilder("select * from students where ");
        String[] sql = string.split(" ");

        boolean firstCondition = true;

        for (String condition : sql) {
            if (condition.contains("null")) {
                continue;
            } else {
                if (!firstCondition) {
                    somestring.append(" AND ");
                }
                somestring.append(condition);
                firstCondition = false;
            }
        }

        somestring = new StringBuilder(somestring.toString().replace("{", ""));
        somestring = new StringBuilder(somestring.toString().replace("}", ""));
        somestring = new StringBuilder(somestring.toString().replace(":", "="));
        somestring = new StringBuilder(somestring.toString().replace(",", " "));

        System.out.println(somestring);
    }
}