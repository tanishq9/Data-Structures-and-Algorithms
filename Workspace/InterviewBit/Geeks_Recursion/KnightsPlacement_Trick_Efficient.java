package Geeks_Recursion;

import java.util.Scanner;

public class KnightsPlacement_Trick_Efficient {

	private static int count(int i, int j, int m, int n) {
		int c = m * n - 1;
		if (i + 1 < n && j + 2 < m)
			c--;
		if (i - 1 >= 0 && j + 2 < m)
			c--;
		if (i + 1 < n && j - 2 >= 0)
			c--;
		if (i - 1 >= 0 && j - 2 >= 0)
			c--;
		if (i + 2 < n && j + 1 < m)
			c--;
		if (i - 2 >= 0 && j + 1 < m)
			c--;
		if (i + 2 < n && j - 1 >= 0)
			c--;
		if (i - 2 >= 0 && j - 1 >= 0)
			c--;

		return c;
	}

	public static int numberOfSafePositions(int m, int n) {
		int c = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				c += count(i, j, m, n);
			}
		}
		return c;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t-- > 0) {
			int m = s.nextInt();
			int n = s.nextInt();
			System.out.println(numberOfSafePositions(m, n));
		}
	}
}
