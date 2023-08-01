import java.util.ArrayList;
import java.util.List;

public class SeparateTheNumbers {
    public static void separateNumbers(String string) {
        int numSize = 1;

        while(numSize <= (string.length() / 2)) {
            int position = 0;
            Long currentNumber = Long.parseLong(string.substring(position, position + numSize));
            Long firstNumber = currentNumber;

            while(true) {
                Long nextNumber = currentNumber + 1;
                position += String.valueOf(currentNumber).length();

                if (position == string.length() && string.length() > 1) {
                    System.out.println("YES " + firstNumber);
                    return;
                }

                try {
                    if (string.substring(position, position + String.valueOf(nextNumber).length()).equals(String.valueOf(nextNumber))) {
                        currentNumber = nextNumber;
                    } else {
                        break;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    break;
                }
            }
            numSize += 1;
        }

        System.out.println("NO");
    }

    public static void main(String[] args) {
        String[] sequences = new String[] {"1234", "91011", "99100", "333435", "0"};

        for(String str : sequences) {
            separateNumbers(str);
        }
    }
}
