package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClosestNumbers {
    public static List<Integer> closestNumbers(List<Integer> values) {
        int menorDistancia = Integer.MAX_VALUE;
        List<Integer> orderedValues = values.stream().sorted().collect(Collectors.toList());

        for(int i = 0; i < orderedValues.size() - 1; i++) {
            int distancia = orderedValues.get(i + 1) - orderedValues.get(i);

            if(distancia < menorDistancia) menorDistancia = distancia;
        }

        List<Integer> results = new ArrayList<>();

        for(int i = 0; i < orderedValues.size() - 1; i++) {
            if((orderedValues.get(i + 1) - orderedValues.get(i)) == menorDistancia) {
                results.add(orderedValues.get(i));
                results.add(orderedValues.get(i + 1));
            }
        }

        return results;
    }

    public static void main(String[] args) {
//        Integer[] values = new Integer[] {5, 2, 3, 4, 1};
//        Integer[] values = new Integer[] {5, 4, 3, 2};
//        Integer[] values = new Integer[] {-20, -3916237, -357920, -3620601,
//                7374819, -7330761, 30, 6246457, -6461594, 266854};
        Integer[] values = new Integer[] {-20, -3916237, -357920, -3620601,
                7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470};

        System.out.println(closestNumbers(Arrays.asList(values)));
    }
}
