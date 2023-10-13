public static void Staircase(int height) {
	StringBuilder staircase = new StringBuilder();

	for(int i = 1; i <= height; i++) {
		for(int j = 0; j < height - i; j++) staircase.Append(" ");
		for(int j = height - i; j < height; j++) staircase.Append("#");
		if(i < height) staircase.Append("\n");
	}

	Console.WriteLine(staircase);
}

Staircase(10);
