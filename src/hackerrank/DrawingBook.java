package hackerrank;

import java.util.Arrays;

public class DrawingBook {
    public static int pageCount(int tamanhoLivro, int pagina) {
        int[] inicioLivro = new int[]{0, 1};
        int[] fimLivro;
        if(tamanhoLivro % 2 == 0)
            fimLivro = new int[]{tamanhoLivro, tamanhoLivro + 1};
        else
            fimLivro = new int[]{tamanhoLivro - 1, tamanhoLivro};
        int viradas = 0;

        while(true) {
            if(Arrays.stream(inicioLivro).anyMatch(i -> i == pagina)
                    || Arrays.stream(fimLivro).anyMatch(i -> i == pagina)){
                return viradas;
            } else {
                viradas += 1;
                inicioLivro[0] += 2;
                inicioLivro[1] += 2;
                fimLivro[0] -= 2;
                fimLivro[1] -= 2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(pageCount(5, 3));
        System.out.println(pageCount(6, 2));
        System.out.println(pageCount(5, 4));
        System.out.println(pageCount(6, 5));
    }
}
