import java.io.*;

public class TimeConversion {
    public static String timeConversion(String s) {
        if(s.substring(8, 10).equals("PM") && Integer.valueOf(s.substring(0, 2)) < 12)
            return String.format("%02d", Integer.valueOf(s.substring(0, 2)) + 12) + s.substring(2, 8);
        else if (s.substring(8, 10).equals("AM") && Integer.valueOf(s.substring(0, 2)) > 11)
            return String.format("%02d", Integer.valueOf(s.substring(0, 2)) - 12) + s.substring(2, 8);
        else
            return s.substring(0, 8);
    }

    public static void main(String[] args) throws IOException {
        String s = "00:05:45AM";

        System.out.println(timeConversion(s));
    }
}
