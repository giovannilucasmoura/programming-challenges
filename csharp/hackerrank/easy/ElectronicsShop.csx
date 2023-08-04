static int ElectronicsShop(int[] keyboards, int[] drives, int budget) {
	int moneySpent = -1;

	List<int> k = keyboards.OrderBy(i => i).ToList();
	List<int> d = drives.OrderBy(i => i).ToList();

	if(k[0] + d[0] > budget) return moneySpent;
	
	for(int i = k.Count() - 1; i >= 0;i--){
		for(int j = d.Count() - 1; j >= 0;j--){
			int currentSum = k[i] + d[j]; 
			if(currentSum > moneySpent && currentSum <= budget) moneySpent = currentSum;
		}
	}
	
	return moneySpent;
}

static String printArray(List<int> list) {
	return String.Join(", ", list);
}

int[] keyboards = new int[] { 3, 1 };
int[] drives = new int[] { 5, 2, 8 };
int budget = 10;

Console.WriteLine(ElectronicsShop(keyboards, drives, budget));