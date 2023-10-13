import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class PlusMinus {
    public static void plusMinus(List<Integer> arr) {
        List<Long> values = new LinkedList<>();

        values.add(arr.stream().filter(i -> i > 0).count());
        values.add(arr.stream().filter(i -> i < 0).count());
        values.add(arr.stream().filter(i -> i == 0).count());

        values.forEach(n ->
                System.out.printf("%.6f%n", Float.valueOf(n) / arr.size()));
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = new LinkedList<>();

        arr.add(5);
        arr.add(4);
        arr.add(0);
        arr.add(-2);
        arr.add(1);

        plusMinus(arr);

        bufferedReader.close();
    }
}
