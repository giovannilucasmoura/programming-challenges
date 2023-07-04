package hackerrank;

import java.util.*;

public class CountSort {
    public static void countSort(List<List<String>> list) {
        String[] orderedStrings = new String[100];
        Arrays.fill(orderedStrings, "");

        for(int i = 0; i < list.size(); i++) {
            int number = Integer.valueOf(list.get(i).get(0));

            if(i < list.size() / 2)
                orderedStrings[number] += "- ";
            else
                orderedStrings[number] += list.get(i).get(1) + " ";
        }

        System.out.println(String.join("", orderedStrings));
    }

    public static void countSortStringBuilder(List<List<String>> list) {
        StringBuilder[] orderedStrings = new StringBuilder[100];

        for(int i = 0; i < list.size(); i++) {
            int number = Integer.valueOf(list.get(i).get(0));

            if(orderedStrings[number] == null) orderedStrings[number] = new StringBuilder();

            if(i < list.size() / 2)
                orderedStrings[number].append("- ");
            else
                orderedStrings[number].append(list.get(i).get(1) + " ");
        }

        String output = "";

        for(int i = 0; i < orderedStrings.length; i++)
            if(orderedStrings[i] != null) System.out.print(orderedStrings[i]);
    }

    public static void main(String[] args) {
        String[] strings = new String[] { "0 ab", "6 cd", "0 ef", "6 gh", "4 ij", "0 ab", "6 cd", "0 ef",
                "6 gh", "0 ij", "4 that", "3 be", "0 to", "1 be", "5 question", "1 or", "2 not", "4 is",
                "2 to", "4 the" };
//        String[] strings = new String[] { "1 e", "2 a", "1 b", "3 a", "4 f", "1 f", "2 a", "1 e", "1 b", "1 c" };
        List<List<String>> list = new ArrayList<>();

        for(String string : strings) {
            list.add(new ArrayList<>(Arrays.asList(string.split(" "))));
        }

        countSort(list);
    }
}
