import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static void insertionSortArray(Integer[] array) {
        int i, key, j;
        for (i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    public static void insertionSortList(List<Integer> list) {
        int i, key, j;
        for(i = 1; i < list.size(); i++) {
            key = list.get(i);
            j = i - 1;

            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j = j - 1;
            }
            list.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        Integer[] array = new Integer[100000];
        for(int i = 0; i < 100000; i++) {
            array[i] = 100000 - i;
        }

        Integer[] iteratedArray = Arrays.copyOf(array, array.length);

        long time = System.currentTimeMillis();
        insertionSortArray(iteratedArray);
        System.out.println("Array time: " + String.valueOf(System.currentTimeMillis() - time) + "ms");

        List<Integer> list = Arrays.asList(array);

        time = System.currentTimeMillis();
        insertionSortList(list);
        System.out.println("List time: " + String.valueOf(System.currentTimeMillis() - time) + "ms");
    }
}
