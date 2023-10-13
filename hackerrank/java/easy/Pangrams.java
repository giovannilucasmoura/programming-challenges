import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pangrams {
    public static String isPangram(String s) {
        s = s.replace(" ", "");
        long totalCaracteres = s.toLowerCase().chars().distinct().count();

        if(totalCaracteres == 26) return "pangram";
        else return "not pangram";
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(Arrays.asList(
                "We promptly judged antique ivory buckles for the next prize",
                "We promptly judged antique ivory buckles for the prize",
                "The quick brown fox jumps over the lazy dog"));

        for(String str : strings) {
            System.out.println(isPangram(str));
        }
    }
}
