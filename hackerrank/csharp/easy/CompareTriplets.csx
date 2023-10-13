public static List<int> CompareTriplets(List<int> a, List<int> b)
{
	int aScore = 0;
	int bScore = 0;

	for(int i = 0; i < a.Count ; i++) {
		if(a[i] == b[i]) continue;
		else if(a[i] > b[i]) aScore++;
		else bScore++;	
	}
	
	return new List<int> { aScore, bScore };
}

var a = new List<int> { 1, 2, 3 };
var b = new List<int> { 3, 2, 1 };

CompareTriplets(a, b).ForEach(x => Console.WriteLine(x.ToString()));
