public class CaesarCipher {
    public static String caesarCipher(String str, int factor) {
        String originalAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String rotatedAlphabet = rotateAlphabetAntiClockwise(factor);
        String encryptedString = "";

        for(char character : str.toCharArray()) {
            if(originalAlphabet.indexOf(Character.toLowerCase(character)) > -1) {
                char rotatedCharacter = rotatedAlphabet.charAt(
                        originalAlphabet.indexOf(Character.toLowerCase(character)));

                if(Character.isUpperCase(character))
                    rotatedCharacter = Character.toUpperCase(rotatedCharacter);

                encryptedString += rotatedCharacter;
            } else {
                encryptedString += character;
            }
        }

        return encryptedString;
    }

    public static String rotateAlphabetAntiClockwise(int factor) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        char[] rotatedAlphabet = new char[26];

        for(int i = 0; i < alphabet.length(); i++) {
            int index = i - (factor % 26);
            if(index < 0) {
                rotatedAlphabet[index + alphabet.length()] = alphabet.charAt(i);
            } else {
                rotatedAlphabet[index] = alphabet.charAt(i);
            }
        }

        return String.valueOf(rotatedAlphabet);
    }

    public static void main(String[] args) throws Exception {
        String s = "There's-a-starman-waiting-in-the-sky";
//        String s = "middle-Outz";

        System.out.println(caesarCipher(s, 3));
    }
}
