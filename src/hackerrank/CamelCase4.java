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

            if(type.equals("M"))
                split = split.replace("()", "");

            return split.toLowerCase();
        } else {
            String[] split = words.split(" ");
            String combine = "";
            if(type.equals("C")) {
                for(int i = 0; i < split.length; i++) {
                    for(int j = 0; j < split[i].length(); j++) {
                        if(j == 0) combine += Character.toUpperCase(split[i].charAt(j));
                        else combine += split[i].charAt(j);
                    }
                }
            } else if(type.equals("M") || type.equals("V")) {
                for(int i = 0; i < split.length; i++) {
                    if(i == 0) {
                        combine += split[i];
                    } else {
                        for(int j = 0; j < split[i].length(); j++) {
                            if(j == 0) combine += Character.toUpperCase(split[i].charAt(j));
                            else combine += split[i].charAt(j);
                        }
                    }
                }

                if(type.equals("M")) combine += "()";
            }

            return combine;
        }
    }

    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();

        strings.add("S;V;iPad");
        strings.add("C;M;mouse pad");
        strings.add("C;C;code swarm");
        strings.add("S;C;OrangeHighlighter");
        strings.add("S;M;plasticCup()");
        strings.add("C;V;mobile phone");
        strings.add("C;C;coffee machine");
        strings.add("S;C;LargeSoftwareBook");
        strings.add("C;M;white sheet of paper");
        strings.add("S;V;pictureFrame");

        for(String str : strings) {
            System.out.println(camelCaseFormat(str));
        }
    }
}
