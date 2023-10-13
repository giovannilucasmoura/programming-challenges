public static int HurdleRace(int k, List<int> height)
{
    int highestHurdle = height.Max();

    return highestHurdle - k > 0 ? highestHurdle - k : 0;
}


System.Console.WriteLine(HurdleRace(1, new List<int> {1, 2, 3, 3, 2}));
System.Console.WriteLine(HurdleRace(4, new List<int> {1, 6, 3, 5, 2}));
System.Console.WriteLine(HurdleRace(7, new List<int> {2, 5, 4, 5, 2}));
