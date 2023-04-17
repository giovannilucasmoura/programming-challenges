package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SalesByMatch {
    public static int sockMerchant(List<Integer> lista) {
        int pares = 0;
        int i = 0;

        lista.sort(Comparator.naturalOrder());

        System.out.println(lista);
        while(i < lista.size()) {
            Integer valorAtual = lista.get(i);
            Integer proximoValor = null;
            try {
                proximoValor = lista.get(i + 1);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
            if(valorAtual == proximoValor) {
                pares += 1;
                i += 2;
            } else {
                i += 1;
            }
        }

        return pares;
    }

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();

        lista = new ArrayList<>(Arrays.asList(1, 2, 1, 2, 1, 3, 2));
        System.out.println(sockMerchant(lista));
        lista = new ArrayList<>(Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20));
        System.out.println(sockMerchant(lista));

    }
}
