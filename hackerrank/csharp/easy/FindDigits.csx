public static int FindDigits(int n)
{
    int divisibleDigits = 0;

    foreach (char charDigit in n.ToString())
    {
        int digit = (int) char.GetNumericValue(charDigit);
        if (digit != 0 && n % digit == 0)
        {
            divisibleDigits++;
        }
    }

    return divisibleDigits;
}

System.Console.WriteLine(FindDigits(124));
System.Console.WriteLine(FindDigits(111));
System.Console.WriteLine(FindDigits(10));
