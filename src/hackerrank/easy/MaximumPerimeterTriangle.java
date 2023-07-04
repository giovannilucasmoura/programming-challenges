package hackerrank;

import java.util.*;
import java.util.stream.Collectors;

public class MaximumPerimeterTriangle {
    public static List<Integer> maximumPerimeterTriangle(List<Integer> gravetos) {
        gravetos.sort(Comparator.naturalOrder());
        List<Integer> trianguloResposta = new ArrayList<>(Arrays.asList(-1));

        for(int i = gravetos.size() - 3; i >= 0; i--) {
            List<Integer> triangulo = gravetos.subList(i, i + 3);

            if(triangulo.get(0) + triangulo.get(1) > triangulo.get(2)){
                trianguloResposta = triangulo;
                break;
            }
        }

        return trianguloResposta;
    }

    public static void main(String[] args) {
        List<Integer> gravetos = new ArrayList<>();

        gravetos = new ArrayList<>(Arrays.asList(1, 1, 1, 3, 3));
        System.out.println(maximumPerimeterTriangle(gravetos));
        gravetos = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(maximumPerimeterTriangle(gravetos));
        gravetos = new ArrayList<>(Arrays.asList(1, 1, 1, 2, 3, 5));
        System.out.println(maximumPerimeterTriangle(gravetos));
        gravetos = new ArrayList<>(Arrays.asList(50, 2430, 134, 6373, 215, 1502, 926, 10312, 351, 74, 572, 3938));
        System.out.println(maximumPerimeterTriangle(gravetos));
        gravetos = new ArrayList<>(Arrays.asList(3, 4, 5, 3, 4, 5, 3, 4, 5));
        System.out.println(maximumPerimeterTriangle(gravetos));
    }
}
