static void MiniMaxSum(List<int> arr)
{	
	List<int> sortedArr = arr.OrderBy(x => x).ToList();
    Int64 minSum = 0;
    Int64 maxSum = 0;

    for (int i = 0; i < 4; i++)
    {
        minSum += sortedArr[i];
        maxSum += sortedArr[sortedArr.Count - i - 1];
    }

    Console.WriteLine($"{minSum} {maxSum}");
}

List<int> values = new List<int>() { 1, 3, 5, 7, 9 };

MiniMaxSum(values);

values = new List<int>() { 1, 2, 3, 4, 5 };

MiniMaxSum(values);
