import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FlippingBits {
    public static long flippingBits(long n) {
        String binario = String.format("%32s", Long.toBinaryString(n)).replaceAll(" ", "0");
        String binarioInvertido = "";

        for(char c : binario.toCharArray()) {
            if(c == '0') binarioInvertido += '1';
            else binarioInvertido += '0';
        }

        long numeroConvertido = Long.parseLong(binarioInvertido, 2);

        return numeroConvertido;
    }

    public static void main(String[] args) {
        List<Long> numeros = new LinkedList<>(Arrays.asList(2147483647L, 1L, 0L));

        for(Long numero : numeros) System.out.println(flippingBits(numero));
    }
}
