public static int DiagonalDifference(List<List<int>> arr)
{
	int leftDiagonalSum = 0;
	int rightDiagonalSum = 0;
	int j = arr.Count - 1;

    for (int i = 0; i < arr.Count; i++)
    {
		leftDiagonalSum += arr[i][i];
		rightDiagonalSum += arr[i][j - i];
		// Console.WriteLine($"{i} {j - i}");
    }

    return Math.Abs(leftDiagonalSum - rightDiagonalSum) ;
}

var matrix = new List<List<int>>();
matrix.Add(new List<int> { 1, 2, 3 });
matrix.Add(new List<int> { 4, 5, 6 });
matrix.Add(new List<int> { 9, 8, 9 });

Console.WriteLine(DiagonalDifference(matrix));

matrix.Clear();
matrix.Add(new List<int> { 11, 2, 4 });
matrix.Add(new List<int> { 4, 5, 6 });
matrix.Add(new List<int> { 10, 8, -12 });

Console.WriteLine(DiagonalDifference(matrix));
