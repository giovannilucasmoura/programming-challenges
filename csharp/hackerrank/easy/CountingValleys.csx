public static int CountingValleys(int steps, string path)
{
    int height = 0;
    int valleys = 0;

    foreach (char c in path.ToCharArray())
    {
        if (c == 'U')
            height += 1;
        else if (c == 'D')
        {
            height -= 1;
            if (height == -1) valleys += 1;
        }
    }

    return valleys;
}

System.Console.WriteLine(CountingValleys(0, "UDDDUDUU"));
