import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumAbsoluteDifference {
    public static int minimumAbsoluteDifference(List<Integer> values) {
        List<Integer> orderedValues = values.stream().sorted().collect(Collectors.toList());
        int minimumDifference = Integer.MAX_VALUE;

        for(int i = 0; i < orderedValues.size() - 1; i++) {
            int difference = Math.abs(orderedValues.get(i + 1) - orderedValues.get(i));
            if(difference < minimumDifference) minimumDifference = difference;
        }

        return minimumDifference;
    }

    public static void main(String[] args) {
        Integer[] values = new Integer[] {3, -7, 0};
//        Integer[] values = new Integer[] {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
//        Integer[] values = new Integer[] {1, -3, 71, 68, 17};

        System.out.println(minimumAbsoluteDifference(Arrays.asList(values)));
    }
}
