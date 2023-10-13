public static String NumberLineJumps(int x1, int v1, int x2, int v2)
{
    while (true)
    {
        if (x1 == x2)
            return "YES";
        if(x1 > x2)
            break;

        x1 += v1;
        x2 += v2;
    }

    return "NO";
}

Console.WriteLine(NumberLineJumps(0, 3, 4, 2));
