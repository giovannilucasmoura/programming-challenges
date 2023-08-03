static string TimeConversion(string s)
{
    string period = s.Substring(8, 2);
    int hour = Int32.Parse(s.Substring(0, 2));

    if (hour == 12 && period == "AM")
    {
        hour -= 12;
    }
    else if (hour != 12)
    {
        hour += 12;
    }

    return $"{hour.ToString("D2")}{s.Substring(2, 6)}";
}

string time = "";
time = "12:01:00PM";
Console.WriteLine($"{time}: {TimeConversion(time)}");
time = "12:01:00AM";
Console.WriteLine($"{time}: {TimeConversion(time)}");
time = "12:00:00AM";
Console.WriteLine($"{time}: {TimeConversion(time)}");
time = "01:00:00AM";
Console.WriteLine($"{time}: {TimeConversion(time)}");
time = "12:00:00PM";
Console.WriteLine($"{time}: {TimeConversion(time)}");
time = "01:00:00PM";
Console.WriteLine($"{time}: {TimeConversion(time)}");
