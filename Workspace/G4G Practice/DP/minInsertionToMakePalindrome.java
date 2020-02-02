package DP_Pep;

import java.util.Scanner;

public class minInsertionsToMakePalindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t != 0) {
			String str = sc.next();
			System.out.println(minimum(str));
			t--;
		}
	}

	private static int minimum(String str) {
		int[][] table = new int[str.length()][str.length()];
		for (int gap = 1; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (str.charAt(i) == str.charAt(j)) {
					table[i][j] = table[i + 1][j - 1];
				} else {
					// not equal chars
					table[i][j] = Math.min(table[i + 1][j], table[i][j - 1]) + 1;
				}
			}
		}
		return table[0][str.length() - 1];
	}
}
