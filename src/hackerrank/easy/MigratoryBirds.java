package hackerrank;

import java.util.*;

public class MigratoryBirds {
    public static int migratoryBirds(List<Integer> lista) {
        Map<Integer, Integer> avistamentoPorId = new HashMap<>();

        for(Integer id : lista) {
            if(avistamentoPorId.get(id) != null) {
                avistamentoPorId.put(id, avistamentoPorId.get(id) + 1);
            } else {
                avistamentoPorId.put(id, 1);
            }
        }

        int maisAvistamentos = 0;
        List<Integer> idsMaisAvistamentos = new ArrayList<>();

        for(Integer id : avistamentoPorId.keySet()) {
            if(avistamentoPorId.get(id) >= maisAvistamentos) {
                if(avistamentoPorId.get(id) > maisAvistamentos) idsMaisAvistamentos.clear();
                idsMaisAvistamentos.add(id);
                maisAvistamentos = avistamentoPorId.get(id);
            }
        }

        return Collections.min(idsMaisAvistamentos);
    }

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();

        lista = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3));
        System.out.println(migratoryBirds(lista));
        lista = new ArrayList<>(Arrays.asList(1, 4, 4, 4, 5, 3));
        System.out.println(migratoryBirds(lista));
        lista = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4));
        System.out.println(migratoryBirds(lista));
    }
}
