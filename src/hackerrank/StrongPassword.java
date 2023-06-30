package hackerrank;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class StrongPassword {
    public static int minimumNumber(String password) {
        String[] characters = new String[] {"0123456789", "abcdefghijklmnopqrstuvwxyz",
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "!@#$%^&*()-+"};
        Boolean[] containsCharacters = new Boolean[4];
        Arrays.fill(containsCharacters, false);

        for(char character : password.toCharArray()) {
            for(int i = 0; i < containsCharacters.length; i++) {
                if(!containsCharacters[i] && characters[i].indexOf(character) >= 0) {
                    containsCharacters[i] = true;
                }
            }
        }

        int minimumAddedCharacters = (int) Arrays.stream(containsCharacters).filter(v -> !v).count();

        if(password.length() + minimumAddedCharacters < 6) {
            minimumAddedCharacters += 6 - (password.length() + minimumAddedCharacters);
        }

        return minimumAddedCharacters;
    }

    public static int minimumNumber_old(String password) {
        String numbers = "0123456789";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialCharacters = "!@#$%^&*()-+";

        boolean hasDigit = false;
        boolean hasLowerCase = false;
        boolean hasUpperCase = false;
        boolean hasSpecialCharacter = false;

        for(char character : password.toCharArray()) {
            if(numbers.indexOf(character) >= 0) {
                hasDigit = true;
            } else if(lowerCase.indexOf(character) >= 0) {
                hasLowerCase = true;
            } else if(upperCase.indexOf(character) >= 0) {
                hasUpperCase = true;
            } else if(specialCharacters.indexOf(character) >= 0) {
                hasSpecialCharacter = true;
            }
        }

        int minimumAddedCharacters = 0;

        if(!hasDigit) minimumAddedCharacters += 1;
        if(!hasLowerCase) minimumAddedCharacters += 1;
        if(!hasUpperCase) minimumAddedCharacters += 1;
        if(!hasSpecialCharacter) minimumAddedCharacters += 1;

        if(password.length() + minimumAddedCharacters < 6) {
            minimumAddedCharacters += 6 - (password.length() + minimumAddedCharacters);
        }

        return minimumAddedCharacters;
    }

    public static void main(String[] args) {
        String[] passwords = new String[] {"2bbbbb", "2bb#A", "Ab1", "zC9!Xx56"};

        for(String password : passwords) {
            System.out.println(password);
            System.out.println(minimumNumber(password));
        }
    }
}
