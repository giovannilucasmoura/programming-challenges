import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BreakingRecords {
    public static List<Integer> breakingRecords(List<Integer> scores) {
        int max = scores.get(0);
        int min = scores.get(0);
        int maxRecordBreak = 0;
        int minRecordBreak = 0;

        for(Integer score : scores) {
            if(score > max) {
                maxRecordBreak += 1;
                max = score;
            } else if(score < min) {
                minRecordBreak += 1;
                min = score;
            }
        }

        return new LinkedList<>(Arrays.asList(maxRecordBreak, minRecordBreak));
    }
    public static void main(String[] args) {
        List<Integer> scores = new LinkedList<>(Arrays.asList(10, 5, 20, 20, 4, 5, 2, 25, 1));

        System.out.println(breakingRecords(scores));
    }
}
