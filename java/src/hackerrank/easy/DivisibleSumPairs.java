package hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DivisibleSumPairs {
    public static int divisibleSumPairs(int k,  List<Integer> valores) {
        int pares = 0;

        for(int i = 0; i < valores.size(); i++) {
            for(int j = 0; j < valores.size(); j++) {
                if(i >= j) continue; // Impedir repetições e somar com o mesmo valor
                int sum = valores.get(i) + valores.get(j);

                if(sum % k == 0) pares += 1;
            }
        }

        return pares;
    }

    public static void main(String[] args) {
        int k = 3;
        List<Integer> valores = new LinkedList<>(Arrays.asList(1, 3, 2, 6, 1, 2));

        System.out.println(divisibleSumPairs(k, valores));
    }
}
