package hackerrank;

public class CountingValleys {
    public static int countingValleys(String caminho) {
        int nivel = 0;
        int vales = 0;

        for(char c : caminho.toCharArray()) {
            if(c == 'U') nivel += 1;
            else if(c == 'D') {
                if(nivel == 0) vales += 1;
                nivel -= 1;
            }
        }

        return vales;
    }

    public static void main(String[] args) {
        String caminho = "UDDDUDUU";

        System.out.println(countingValleys(caminho));
    }
}
