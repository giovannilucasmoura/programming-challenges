import java.util.*;
import java.util.stream.Collectors;

public class PermutingTwoArrays {
    public static String twoArrays(int k, List<Integer> listA, List<Integer> listB) {
        listA = listA.stream().sorted().collect(Collectors.toList());
        listB = listB.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());

        for(int i = 0; i < listA.size(); i++) {
            if(listA.get(i) + listB.get(i) < k) return "NO";
        }

        return "YES";
    }

    public static void main(String[] args) {
        int[] k = new int[]{1, 10, 5};
        Integer[][][] arrays = new Integer[][][] {
            {{0, 1}, {0, 2}},
            {{2, 1, 3}, {7, 8, 9}},
            {{1, 2, 2, 1}, {3, 3, 3, 4}}
        };

        for(int i = 0; i < k.length; i++) {
            System.out.println(
                    twoArrays(k[i],
                    new ArrayList<Integer>(Arrays.asList(arrays[i][0])),
                    new ArrayList<Integer>(Arrays.asList(arrays[i][1]))));
        }
    }
}
