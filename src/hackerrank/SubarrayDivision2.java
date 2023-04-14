package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SubarrayDivision2 {
    public static int birthday(List<Integer> s, int d, int m) {
        Integer[] posicoes = new Integer[m];
        Arrays.fill(posicoes, 0);

        List<List<Integer>> combinacoes = new ArrayList<>();

        do {
            for(int i = m - 1; i >= 0; i--) {
                if(posicoes[i] < s.size() - 1) {
                    posicoes[i] += 1;
                    break;
                } else if(posicoes[i] == s.size() - 1) {
                    posicoes[i] = 0;
                    try {
                        if(posicoes[i - 1] != s.size() - 1) {
                            posicoes[i - 1] += 1;
                            break;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }
                }
            }

            if(valoresDistintos(posicoes)) {
                Integer[] valores = new Integer[m];
                int soma = 0;
                for(int i = 0; i < posicoes.length; i++) {
                    valores[i] = s.get(posicoes[i]);
                    soma += s.get(posicoes[i]);
                }
                System.out.println(Arrays.toString(valores));
                if (soma == d) {
                    combinacoes.add(Arrays.stream(valores).sorted().collect(Collectors.toList()));
                }
            }
        } while (!Arrays.stream(posicoes).allMatch(i -> i == s.size() - 1));

        return (int) combinacoes.stream().distinct().count();
    }

    public static boolean valoresDistintos(Integer[] array) {
        Integer valorUnico = array[0];

        for(int i = 1; i < array.length; i++) {
            if(array[i] == valorUnico) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        List<Integer> segmentos = null;

        segmentos = new ArrayList<>(Arrays.asList(4, 5, 4, 2, 4, 5, 2, 3, 2, 1, 1, 5, 4));
        System.out.println(birthday(segmentos, 15, 4));
        segmentos = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 2));
        System.out.println(birthday(segmentos, 3, 2));
        segmentos = new ArrayList<>(Arrays.asList(4));
        System.out.println(birthday(segmentos, 4, 1));

    }
}
