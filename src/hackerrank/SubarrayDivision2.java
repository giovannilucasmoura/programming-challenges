package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SubarrayDivision2 {
    public static int birthday(List<Integer> s, int d, int m) {
        Integer[] valores = new Integer[m];
        Arrays.fill(valores, 0);

        s = s.stream().distinct().collect(Collectors.toList());

        List<List<Integer>> combinacoes = new ArrayList<>();

        while(true) {
            if(valorFinal(valores, s.size())) break;

            for(int i = m - 1; i >= 0; i--) {
                if(valores[i] < s.size()) {
                    valores[i] += 1;
                    break;
                } else if(valores[i] == s.size()) {
                    valores[i] = 0;
                    if(valores[i - 1] != s.size()) {
                        valores[i - 1] += 1;
                        break;
                    }
                }
            }


            if(valoresDistintos(valores)) {
                int soma = Arrays.stream(valores).sum();

                if (soma == d) {
                    combinacoes.add(Arrays.asList(valores));
                }
            }
        }

        return combinacoes.size();
    }

    public static boolean valoresDistintos(Integer[] array) {
        return Arrays.stream(array).distinct().count() == array.length;
    }

    public static boolean valorFinal(Integer[] array, int valor) {
        if(Arrays.stream(array).distinct().count() == 1 && array[0] == valor)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        List<Integer> segmentos = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 2));

        System.out.println(birthday(segmentos, 3, 2));
    }
}
