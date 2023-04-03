package hackerrank;

import java.util.LinkedList;
import java.util.List;

public class CamelCase4 {
    public static String camelCaseFormat(String input) {
        String operation = input.split(";")[0];
        String type = input.split(";")[1];
        String words = input.split(";")[2];

        if(operation.equals("S")){
            String split = "";

            if(type.equals("V")) {
                int wordStart = 0;
                for(int i = 0; i < words.length(); i++) {
                    char c = words.charAt(i);

                    if(Character.isUpperCase(c)){
                        if(wordStart != 0) split += " ";
                        split += words.substring(wordStart, i);
                        wordStart = i;
                    } else if(i == words.length() - 1) {
                        split += " " + words.substring(wordStart, i + 1);
                    }
                }

                return split.toLowerCase();
            }
        } else if(operation.equals("C")) {
            if(type == "M") {

            }
        }

        return input;
    }

    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();

        strings.add("S;V;iPad");
        strings.add("C;M;mouse pad");
        strings.add("C;C;code swarm");
        strings.add("S;C;OrangeHighlighter");

        for(String str : strings) {
            System.out.println(camelCaseFormat(str));
        }
    }
}
