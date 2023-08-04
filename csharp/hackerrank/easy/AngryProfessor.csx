static string AngryProfessor(int studentThreshold, List<int> arrivalTime) {
	return arrivalTime
		.Where(a => a <= 0)
		.Count() >= studentThreshold ? "NO" : "YES";
}

