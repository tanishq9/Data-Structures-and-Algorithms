package DP;

public class buildingSpaceBuilding {
	static void possible(int n) {
		// result(n) = fib(n+2)
		int countSpace = 1;
		int countBuilding = 1;
		for (int i = 2; i <= n; i++) {
			int prevCountSpace = countSpace;
			int prevCountBuilding = countBuilding;
			// append space at end of both previous configurations
			countSpace = prevCountBuilding + prevCountSpace;
			// building can come only after space ; consecutive building not allowed
			countBuilding = prevCountSpace;
		}
		System.out.println(countBuilding + countSpace);
	}

	public static void main(String[] args) {
		possible(3);
	}
}
