package experiments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {
    public static void mergeList(List<Integer> list, int leftIndex, int middleIndex, int rightIndex) {
        int i, j, k;
        int n1 = middleIndex - leftIndex + 1;
        int n2 = rightIndex - middleIndex;

        List<Integer> leftSplit = new ArrayList<>();
        List<Integer> rightSplit = new ArrayList<>();

        for(i = 0; i < n1; i++)
            leftSplit.add(list.get(leftIndex + i));
        for(j = 0; j < n2; j++)
            rightSplit.add(list.get(middleIndex + 1 + j));

        i = 0;
        j = 0;
        k = leftIndex;
        while(i < n1 && j < n2) {
            if(leftSplit.get(i) <= rightSplit.get(j)) {
                list.set(k, leftSplit.get(i));
                i++;
            } else {
                list.set(k, rightSplit.get(j));
                j++;
            }
            k++;
        }

        while(i < n1) {
            list.set(k, leftSplit.get(i));
            i++;
            k++;
        }

        while(j < n2) {
            list.set(k, rightSplit.get(j));
            j++;
            k++;
        }
    }

    public static void mergeSortList(List<Integer> list) {
        mergeSortList(list, 0, list.size() - 1);
    }

    public static void mergeSortList(List<Integer> list, int leftIndex, int rightIndex) {
        if(leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            mergeSortList(list, leftIndex, middleIndex);
            mergeSortList(list, middleIndex + 1, rightIndex);

            mergeList(list, leftIndex, middleIndex, rightIndex);
        }
    }

    public static void mergeArray(Integer[] array, int leftIndex, int middleIndex, int rightIndex) {
        int i, j, k;
        int n1 = middleIndex - leftIndex + 1;
        int n2 = rightIndex - middleIndex;

        Integer[] leftSplit = new Integer[n1];
        Integer[] rightSplit = new Integer[n2];

        for(i = 0; i < n1; i++)
            leftSplit[i] = array[leftIndex + i];
        for(j = 0; j < n2; j++)
            rightSplit[j] = array[middleIndex + 1 + j];

        i = 0;
        j = 0;
        k = leftIndex;
        while(i < n1 && j < n2) {
            if(leftSplit[i] <= rightSplit[j]) {
                array[k] = leftSplit[i];
                i++;
            } else {
                array[k] = rightSplit[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            array[k] = leftSplit[i];
            i++;
            k++;
        }

        while(j < n2) {
            array[k] = rightSplit[j];
            j++;
            k++;
        }
    }

    public static void mergeSortArray(Integer[] array) {
        mergeSortArray(array, 0, array.length - 1);
    }

    public static void mergeSortArray(Integer[] array, int leftIndex, int rightIndex) {
        if(leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;

            mergeSortArray(array, leftIndex, middleIndex);
            mergeSortArray(array, middleIndex + 1, rightIndex);

            mergeArray(array, leftIndex, middleIndex, rightIndex);
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[100000];
        for(int i = 0; i < 100000; i++) {
            array[i] = 100000 - i;
        }

        Integer[] iteratedArray = Arrays.copyOf(array, array.length);

        long time = System.currentTimeMillis();
        mergeSortArray(iteratedArray);
        System.out.println("Array time: " + String.valueOf(System.currentTimeMillis() - time) + "ms");

        List<Integer> list = Arrays.asList(array);

        time = System.currentTimeMillis();
        mergeSortList(list);
        System.out.println("List time: " + String.valueOf(System.currentTimeMillis() - time) + "ms");
    }
}
