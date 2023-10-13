static int BirthdayCakeCandles(List<int> candles)
{
    int tallestCandle = candles.Max();

    return candles.Where(i => i == tallestCandle).Count();
}

List<int> values = new List<int>() { 4, 4, 2, 3 };

Console.WriteLine(BirthdayCakeCandles(values));

