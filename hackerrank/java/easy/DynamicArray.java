import java.util.ArrayList;
import java.util.List;

public class DynamicArray {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> results = new ArrayList<>();
        int lastAnswer = 0;

        for(int i = 0; i < n; i++)
            arr.add(new ArrayList<>());

        for(List<Integer> query : queries) {
            int idx = (query.get(1) ^ lastAnswer) % n;

            if(query.get(0) == 1) {
                arr.get(idx).add(query.get(2));
            } else if(query.get(0) == 2) {
                lastAnswer = arr.get(idx).get(query.get(2) % arr.get(idx).size());
                results.add(lastAnswer);
            }
        }

        return results;
    }

    public static void main(String[] args) throws Exception {
        int n = 2;
        List<List<Integer>> queries = new ArrayList<>();
        List<Integer> query = new ArrayList<>();

        query.add(1);
        query.add(0);
        query.add(5);

        queries.add(query);
        query = new ArrayList<>();

        query.add(1);
        query.add(1);
        query.add(7);

        queries.add(query);
        query = new ArrayList<>();

        query.add(1);
        query.add(0);
        query.add(3);

        queries.add(query);
        query = new ArrayList<>();

        query.add(2);
        query.add(1);
        query.add(0);

        queries.add(query);
        query = new ArrayList<>();

        query.add(2);
        query.add(1);
        query.add(1);

        queries.add(query);

        System.out.println(dynamicArray(n, queries));
    }
}
