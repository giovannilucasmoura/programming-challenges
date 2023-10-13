import java.util.*;
import java.util.stream.Collectors;

public class MissingNumbers {
    public static List<Integer> missingNumbers(List<Integer> missingList, List<Integer> originalList) {
        Map<Integer, Integer> missingFrequencyMap = buildFrequencyMap(missingList);
        Map<Integer, Integer> originalFrequencyMap = buildFrequencyMap(originalList);
        List<Integer> missingNumbers = new ArrayList<>();

        for(Integer key : originalFrequencyMap.keySet()) {
            if(!missingFrequencyMap.containsKey(key) ||
                    originalFrequencyMap.get(key) > missingFrequencyMap.get(key))
                missingNumbers.add(key);
        }

        return missingNumbers;
    }

    public static Map<Integer, Integer> buildFrequencyMap(List<Integer> list) {
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        // Populating map with all distinct values
        for(Integer number : new HashSet<>(list))
            frequencyMap.put(number, 0);

        // Counting frequency of each value
        for(Integer number : list)
            frequencyMap.put(number, frequencyMap.get(number) + 1);

        return frequencyMap;
    }

    public static void main(String[] args) {
//        Integer[] missingList = new Integer[] {203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
//        Integer[] originalList = new Integer[] {203, 204, 204, 205, 206, 207, 205, 208, 203,
//                206, 205, 206, 204};
        Integer[] missingList = new Integer[] {11, 4, 11, 7, 13, 4, 12, 11, 10, 14};
        Integer[] originalList = new Integer[] {11, 4, 11, 7, 3, 7, 10, 13, 4, 8, 12, 11, 10, 14, 12};

        System.out.println(missingNumbers(Arrays.asList(missingList), Arrays.asList(originalList)));
    }
}
