package hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SparseArrays {
    public static List<Integer> matchingStrings(List<String> strings, List<String> buscas) {
        List<Integer> resultados = new LinkedList<>();

        for(String busca : buscas) {
            int repeticoes = 0;
            for(String string : strings) {
                if(string.equals(busca))  repeticoes += 1;
            }
            resultados.add(repeticoes);
        }

        return resultados;
    }

    public static void main(String[] args) {
        List<String> strings = new LinkedList<>(Arrays.asList("abcde", "sdaklfj", "asdjf", "na",
                "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"));
        List<String> buscas = new LinkedList<>(Arrays.asList("abcde", "sdaklfj", "asdjf", "na", "basdn"));

        System.out.println(matchingStrings(strings, buscas));
    }
}
