package hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class MaxMin {
    public static int maxMin(int k, List<Integer> arr) {
        int smallestDifference = Integer.MAX_VALUE;

        List<Integer> orderedList = arr.stream().sorted().collect(Collectors.toList());
        
        int i = 0;
        while(i <= orderedList.size() - k) {
            int smallerValue = orderedList.get(i);
            int biggerValue = orderedList.get(i + k - 1);

            int difference = biggerValue - smallerValue;
            if(difference < smallestDifference)
                smallestDifference = difference;
            i++;
        }

        return smallestDifference;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int k = 4;

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(100);
        list.add(200);

        System.out.println(maxMin(k, list));
    }
}
