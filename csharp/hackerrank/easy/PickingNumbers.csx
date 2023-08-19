public static int PickingNumbers(List<int> a)
{
    List<int> uniqueNumbers = a.Distinct().ToList();
    var longestArray = new List<int>();

    foreach (var uniqueNumber in uniqueNumbers)
    {
        var currentArray = a.Where(n => n <= uniqueNumber + 1 && n >= uniqueNumber).ToList();
        if (currentArray.Count() > longestArray.Count())
        {
            longestArray = currentArray;
        }
    }

    return longestArray.Count();
}

PickingNumbers(new List<int> { 1, 1, 2, 2, 4, 4, 5, 5, 5 });
PickingNumbers(new List<int> { 1, 2, 2, 3, 1, 2 });
