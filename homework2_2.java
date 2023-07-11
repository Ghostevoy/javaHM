import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class homework2_2 {

    public static void main(String[] args) {
        String string = stringRead(new File("file2.txt"));
        System.out.println(string);
        String[] arraystring = changeString(string);
        printStrings(arraystring);
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

    static String[] changeString(String string) {
        String[] strings = string.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].contains("[")) {
                strings[i] = strings[i].replace("[", "");
            }
            if (strings[i].contains("]")) {
                strings[i] = strings[i].replace("]", "");
            }
            if (strings[i].contains("{")) {
                strings[i] = strings[i].replace("{", "");
            }
            if (strings[i].contains("}")) {
                strings[i] = strings[i].replace("}", "");
            }
            if (strings[i].contains(",")) {
                strings[i] = strings[i].replace(",", " ");
            }
            if (strings[i].contains(":")) {
                strings[i] = strings[i].replace(":", " ");
            }
            if (strings[i].contains("\"")) {
                strings[i] = strings[i].replace("\"", "");
            }
            if (strings[i].contains("предмет")) {
                strings[i] = strings[i].replace("предмет", "по предмету");
            }
            if (strings[i].contains("фамилия")) {
                strings[i] = strings[i].replace("фамилия", "");
            }
            if (strings[i].contains("оценка")) {
                strings[i] = strings[i].replace("оценка", "получил");
            }
        }
        return strings;
    }

    static void printStrings(String[] array) {
        StringBuilder builder = new StringBuilder("Студент");
        for (String str : array) {
            System.out.println(builder.toString() + str);
        }
    }
}