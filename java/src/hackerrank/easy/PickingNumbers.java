package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PickingNumbers {
    public static int pickingNumbers(List<Integer> lista) {
        int maiorSequencia = 0;
        int sequenciaAtual = 0;

        lista.sort(Comparator.naturalOrder());

        int valorAtual = lista.get(0);

        for(int i = 1; i < lista.size(); i++) {
            if(lista.get(i) == valorAtual || lista.get(i) == valorAtual + 1) {
                if(sequenciaAtual == 0) sequenciaAtual = 2;
                else sequenciaAtual += 1;
            } else {
                valorAtual = lista.get(i);
                sequenciaAtual = 0;
            }
            if(sequenciaAtual > maiorSequencia) maiorSequencia = sequenciaAtual;
        }

        return maiorSequencia;
    }

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();

        lista = new ArrayList<>(Arrays.asList(1, 1, 1, 3, 3));
        System.out.println(pickingNumbers(lista));
        lista = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(pickingNumbers(lista));
        lista = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 3, 5));
        System.out.println(pickingNumbers(lista));
        lista = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5));
        System.out.println(pickingNumbers(lista));
        lista = new ArrayList<>(Arrays.asList(4, 6, 5, 3, 3, 1));
        System.out.println(pickingNumbers(lista));
        lista = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 1, 2));
        System.out.println(pickingNumbers(lista));
    }
}
