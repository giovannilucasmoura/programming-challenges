import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int leftRightSum = 0;
        int rightLeftSum = 0;
        int size = arr.get(0).size();
        int i = 0;
        int j = 0;
        int x = 0;
        int y = size - 1;

        for(int z = 0; z < size; z++) {
            leftRightSum += arr.get(i).get(j);
            rightLeftSum += arr.get(x).get(y);

            i += 1;
            j += 1;
            x += 1;
            y -= 1;
        }

        return Math.abs(leftRightSum - rightLeftSum);
    }
    public static void main(String[] args) throws IOException {
        List<List<Integer>> a = new LinkedList<>();
        List<Integer> l1 = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        List<Integer> l3 = new LinkedList<>();
        List<Integer> l4 = new LinkedList<>();

        l1.add(5);
        l1.add(8);
        l1.add(-3);
        l1.add(4);

        l2.add(22);
        l2.add(6);
        l2.add(90);
        l2.add(1);

        l3.add(40);
        l3.add(-16);
        l3.add(5);
        l3.add(-9);

        l4.add(3);
        l4.add(-50);
        l4.add(8);
        l4.add(37);

        a.add(l1);
        a.add(l2);
        a.add(l3);
        a.add(l4);

        System.out.println(diagonalDifference(a));
    }
}
