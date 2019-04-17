package Recursion;

public class Staircase {

	public static void main(String[] args) {
		int n = 4;
		System.out.println(staircase(n));
	}

	private static int staircase(int n) {
		if (n < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		int totalWays = 0;
		for (int i = 1; i <= 3; i++) {
			totalWays += staircase(n - i);
		}
		return totalWays;
	}

}
