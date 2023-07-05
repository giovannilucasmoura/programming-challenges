package hackerrank.easy;

import java.util.Arrays;
import java.util.List;

public class GridChallenge {
    public static String gridChallenge(List<String> grid) {
        for(int i = 0; i < grid.size(); i++) {
            char[] charArray = grid.get(i).toCharArray();
            Arrays.sort(charArray);
            grid.set(i, String.valueOf(charArray));
        }

        boolean alphabeticalColumns = true;

        for(int i = 0; i < grid.get(0).length(); i++) {
            for(int j = grid.size() - 1; j > 0; j--){
                if(grid.get(j - 1).charAt(i) > grid.get(j).charAt(i)) {
                    alphabeticalColumns = false;
                    break;
                }
            }
        }

        return alphabeticalColumns ? "YES" : "NO";
    }

    public static void main(String[] args) {
//        String[] grid = new String[] {"cba", "eda", "efg"};
        String[] grid = new String[] {"abc", "ade", "efg"};

        System.out.println(gridChallenge(Arrays.asList(grid)));
    }
}
