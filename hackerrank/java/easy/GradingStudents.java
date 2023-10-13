import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GradingStudents {
    public static List<Integer> gradingStudents(List<Integer> notas) {
        List<Integer> notasArredondadas = new LinkedList<>();

        for(Integer nota : notas) {
            if(nota >= 38 && nota % 5 > 2) notasArredondadas.add(nota + (5 - nota % 5));
            else notasArredondadas.add(nota);
        }

        return notasArredondadas;
    }

    public static void main(String[] args) {
        List<Integer> notas = new LinkedList<>(Arrays.asList(64, 24, 68, 14, 53, 49, 45, 99,
                55, 24, 59, 67, 8, 76, 37, 24, 24, 73));

        System.out.println(gradingStudents(notas));
    }
}
