package hackerrank.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SansaXor {
    // This method solves the problem, however the problem actually wants an optimized answer
    // answer using XOR's properties, which are explained by @hell_io on this problem's discussions
//    public static int actualSansaXor(List<Integer> list) {
//        List<Integer> results = new ArrayList<>();
//
//        int n = 1;
//        while(n <= list.size()) {
//            int i = 0;
//            while(i + n <= list.size()) {
//                if(n > 1)
//                    results.add(list.subList(i, i + n).stream().reduce(0, (total, e) -> total ^ e));
//                else
//                    results.add(list.get(i));
//                i++;
//            }
//            n++;
//        }
//
//        return results.stream().reduce(0, (total, e) -> total ^ e);
//    }

    public static int sansaXor(List<Integer> list) {
        if(list.size() % 2 == 0) return 0;
        else {
            return IntStream
                    .range(0, list.size())
                    .filter(i -> (i + 1) % 2 == 1)
                    .mapToObj(i -> list.get(i))
                    .reduce(0, (total, e) -> total ^ e);
        }
    }

    // Commented code is manual XOR calculation, converting to binary and back to decimal
    // Unnecessary due to the ^ operator
//    public static int xor(List<Integer> values) {
//        String xorString = "";
//
//        String[] columns = new String[32];
//        Arrays.fill(columns, "");
//
//        for(int i = 0; i < 32; i++) {
//            for(int j = 0; j < values.size(); j++) {
//                columns[i] += toBinary(values.get(j)).charAt(i);
//            }
//        }
//
//        for(String column : columns) {
//            xorString += column.chars()
//                    .mapToObj(c -> (char) c)
//                    .filter(e -> e.equals('1'))
//                    .count() % 2 == 1 ? "1" : "0";
//        }
//
//        return toDecimal(xorString);
//    }
//
//    public static String toBinary(Integer value) {
//        return String.format("%32s", Integer.toBinaryString(value)).replace(" ", "0");
//    }
//
//    public static Integer toDecimal(String binaryValue) {
//        return Integer.parseInt(binaryValue, 2);
//    }

    public static void main(String[] args) {
        Integer[] values = new Integer[] { 3, 4, 5 };

        System.out.println(sansaXor(Arrays.asList(values)));
    }
}
