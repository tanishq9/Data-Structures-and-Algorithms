package DP_Pep;

import java.util.Scanner;

public class lcs3Strings {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t != 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			String str1 = sc.next();
			String str2 = sc.next();
			String str3 = sc.next();
			int[][][] table = new int[a + 1][b + 1][c + 1];
			for (int i = 0; i <= a; i++) {
				for (int j = 0; j <= b; j++) {
					for (int k = 0; k <= c; k++) {
						if (i == 0 || j == 0 || k == 0) {
							table[i][j][k] = 0;
						} else if (str1.charAt(i - 1) == str2.charAt(j - 1) && str2.charAt(j - 1) == str3.charAt(k - 1)
								&& str1.charAt(i - 1) == str3.charAt(k - 1)) {
							table[i][j][k] = table[i - 1][j - 1][k - 1] + 1;
						} else {
							table[i][j][k] = Math.max(Math.max(table[i - 1][j][k], table[i][j - 1][k]),
									table[i][j][k - 1]);
						}
					}
				}
			}
			System.out.println(table[a][b][c]);
			t--;
		}

	}
}