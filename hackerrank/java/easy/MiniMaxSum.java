import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MiniMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        long sumMin = arr.stream().sorted().limit(4).mapToLong(l -> l).sum();
        long sumMax = arr.stream().sorted(Collections.reverseOrder()).limit(4).mapToLong(l -> l).sum();

        System.out.println(sumMin + " " + sumMax);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = new LinkedList<>();

        arr.add(1);
        arr.add(3);
        arr.add(5);
        arr.add(7);
        arr.add(9);

        miniMaxSum(arr);

        bufferedReader.close();
    }
}
