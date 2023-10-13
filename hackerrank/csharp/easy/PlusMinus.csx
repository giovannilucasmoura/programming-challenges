using System.Globalization;

public static void PlusMinus(List<int> arr)
{
    double positiveRatio = (double) arr.Where(val => val > 0).Count() / arr.Count;
    double negativeRatio = (double) arr.Where(val => val < 0).Count() / arr.Count;
    double zeroRatio = (double) arr.Where(val => val == 0).Count() / arr.Count;

    Console.WriteLine(positiveRatio.ToString("F6", CultureInfo.InvariantCulture));
    Console.WriteLine(negativeRatio.ToString("F6", CultureInfo.InvariantCulture));
    Console.WriteLine(zeroRatio.ToString("F6", CultureInfo.InvariantCulture));
}

List<int> arr = new List<int>() { 1, 1, 0, -1, -1 };

PlusMinus(arr);

arr = new List<int>() { -4, 3, -9, 0, 4, 1 };

PlusMinus(arr);
