public static List<int> PermutationEquation(List<int> p)
{
    List<int> permutatedList = new List<int>();

    for (int i = 1; i <= p.Count(); i++)
    {
        permutatedList.Add(p.IndexOf(p.IndexOf(i) + 1) + 1);
    }

    return permutatedList;
}

System.Console.WriteLine(String.Join(", ", PermutationEquation(new List<int> {5, 2, 1, 3, 4})));
