package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class SubarrayDivision2 {
    public static int birthday(List<Integer> s, int d, int m) {
        int total = 0;
        for(int i = m; i <= s.size(); i++) {
            if(s.subList(i - m, i).stream().collect(Collectors.summingInt(Integer::new)) == d)
                total += 1;
        }
        return total;
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
