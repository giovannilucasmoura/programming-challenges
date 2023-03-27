package hackerrank;

public class BalancedBrackets {
    public static void isBalancedBracket(String str) {
        if(validBracket(str)) System.out.println("YES");
        else System.out.println("NO");
    }

    public static boolean validBracket(String str) {
        System.out.println(str);

        char abertura = str.charAt(0);
        char fechamento = '-';
        int aberturaRepeticoes = 0;

        if(abertura == '(') fechamento = ')';
        else if(abertura == '[') fechamento = ']';
        else if(abertura == '{') fechamento = '}';
        else return false;

        // Se não encontrar fechamento já é inválido
        if(str.indexOf(fechamento) == -1) return false;

        // Encontrar carater que fecha o de abertura
        int fechadorIndex = 0;
        for(char c : str.substring(1).toCharArray()) {
            fechadorIndex += 1;
            if(c == abertura) {
                aberturaRepeticoes += 1;
            } else if (c == fechamento) {
                if(aberturaRepeticoes > 0) {
                    aberturaRepeticoes -= 1;
                } else {
                    break;
                }
            }
        }

        if(aberturaRepeticoes > 0) return false;

        String substr = str.substring(0, fechadorIndex + 1);

        System.out.println(substr.equals(str));

        return true;
    }

    public static void main(String[] args) {
        String[] strings = new String[]{"[](){}", "[][]{}{[]}", "{[(])}", "[]()[]", "{{[[(())]]}}", "{{[((()]]]}}", "{]"};

        for (String string : strings) {
            isBalancedBracket(string);
        }
    }
}
