public static List<int> CircularArrayRotation(List<int> a, int k, List<int> queries)
{
    int aCount = a.Count();
    if (k > aCount)
    {
        k = k % aCount;
    }

    List<int> rotatedElements = a.GetRange(aCount - k, k);
    List<int> otherElements = a.GetRange(0, aCount - k);

    var rotatedArray = rotatedElements.Concat(otherElements).ToList();
    var queriedArray = new List<int>();

    foreach (var i in queries)
    {
        queriedArray.Add(rotatedArray[i]);
    }

    return queriedArray;
}

Console.WriteLine(string.Join(", ", CircularArrayRotation(new List<int>() { 3, 4, 5 }, 2, new List<int>() { 1, 2 })));
Console.WriteLine(string.Join(", ", CircularArrayRotation(new List<int>() { 8, 7, 6, 5, 4, 3, 2, 1 }, 3,
                                                          new List<int>() { 3, 4, 5 })));
Console.WriteLine(string.Join(", ",
                              CircularArrayRotation(new List<int>() { 1, 2, 3 }, 2, new List<int>() { 0, 1, 2 })));
