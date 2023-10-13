public static string DayOfTheProgrammer(int year)
{
    int day = 13;

    if (year < 1918 && year % 4 == 0 || year > 1918 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
    {
        day -= 1;
    }
    else if (year == 1918)
    {
        day += 13;
    }

    return $"{day.ToString()}.09.{year.ToString()}";
}

Console.WriteLine(DayOfTheProgrammer(2017));
Console.WriteLine(DayOfTheProgrammer(2016));
Console.WriteLine(DayOfTheProgrammer(1800));
Console.WriteLine(DayOfTheProgrammer(1918));
