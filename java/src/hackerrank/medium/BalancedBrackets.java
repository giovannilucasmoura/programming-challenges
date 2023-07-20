package hackerrank;

import java.util.LinkedList;
import java.util.List;

public class BalancedBrackets {
    public static String isBalanced(String str) {
        if(validBracket(str)) return "YES";
        else return "NO";
    }

    public static boolean validBracket(String str) {
        System.out.println(str);

        List<String> substrings = new LinkedList<>();
        char abertura = '-';
        char fechamento = '-';
        int aberturaIndex = 0;
        int aberturaRepeticoes = 0;

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(abertura == '-') {
                abertura = c;
                aberturaIndex = i;

                if(abertura == '(') fechamento = ')';
                else if(abertura == '[') fechamento = ']';
                else if(abertura == '{') fechamento = '}';
                else return false;
            } else {
                if(c == abertura) {
                    aberturaRepeticoes += 1;
                } else if (c == fechamento) {
                    if(aberturaRepeticoes > 0) {
                        aberturaRepeticoes -= 1;
                    } else {
                        substrings.add(str.substring(aberturaIndex, i + 1));
                        abertura = '-';
                        fechamento = '-';
                    }
                }
            }
        }

        System.out.println(substrings);
        if(substrings.size() == 1) {
            String substring = substrings.get(0);
            return validBracket(substring.substring(1, substring.length() - 1));
        } else {
            return false;
        }
    }

    public static boolean validBracket_old(String str) {
        char abertura = str.charAt(0);
        char fechamento = '-';
        int aberturaRepeticoes = 0;

        if(abertura == '(') fechamento = ')';
        else if(abertura == '[') fechamento = ']';
        else if(abertura == '{') fechamento = '}';
        else return false;

        // Se não encontrar fechamento já é inválido
        if(str.indexOf(fechamento) == -1) return false;

        // Encontrar carater que fecha o de abertura
        int fechadorIndex = 0;
        for(char c : str.substring(1).toCharArray()) {
            fechadorIndex += 1;
            if(c == abertura) {
                aberturaRepeticoes += 1;
            } else if (c == fechamento) {
                if(aberturaRepeticoes > 0) {
                    aberturaRepeticoes -= 1;
                } else {
                    if(fechadorIndex == 1) return true;
                    break;
                }
            }
        }

        if(aberturaRepeticoes != 0) return false;

        String substr = str.substring(0, fechadorIndex + 1);

        if(substr.equals(str)) {
            return validBracket(str.substring(1, fechadorIndex));
        } else {
            return validBracket(str.substring(substr.length()));
        }
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"[](){}", "[][]{}{[]}", "{[(])}", "[]()[]", "{{[[(())]]}}",
                "{{[((()]]]}}", "{]", "{(([])[])[]]}"};

        for (String string : strings) {
            System.out.println(isBalanced(string));
        }
    }
}
