public class NumberLineJumps {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        while(true) {
            if(x1 == x2)
                return "YES";
            if(x1 > x2)
                break;

            x1 += v1;
            x2 += v2;
        }

        return "NO";
    }

    public static void main(String[] args) {
        System.out.println(kangaroo(2, 1, 1, 2));
        System.out.println(kangaroo(1113, 612, 1331, 610));
    }
}
