package hackerrank;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LonelyInteger {

    public static int lonelyInteger(List<Integer> a) {
        List<Integer> uniques = a.stream().distinct().collect(toList());
        int lonelyInteger = 0;

        for(Integer num : uniques) {
            long repeats = a.stream().filter(i -> i == num).count();
            if(repeats == 1) lonelyInteger = num;
        }

        return lonelyInteger;
    }
    public static void main(String[] args) throws IOException {
        List<Integer> a = new LinkedList<>();
        a.add(16);
        a.add(3);
        a.add(3);
        a.add(5);
        a.add(5);
        a.add(9);
        a.add(9);
        System.out.println(lonelyInteger(a));
    }
}
