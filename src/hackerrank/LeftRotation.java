package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotation {
    public static List<Integer> rotateLeft(int rotacao, List<Integer> lista) {
        Integer[] arrayRotacao = new Integer[lista.size()];

        for(int i = 0; i < lista.size(); i++) {
            if(i - rotacao >= 0) {
                arrayRotacao[i - rotacao] = lista.get(i);
            } else {
                arrayRotacao[lista.size() - rotacao + i] = lista.get(i);
            }
        }

        return Arrays.asList(arrayRotacao);
    }

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();

        lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(rotateLeft(4, lista));
        lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(rotateLeft(2, lista));
    }
}
