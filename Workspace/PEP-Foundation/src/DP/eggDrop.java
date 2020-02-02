package DP;

public class eggDrop {

	public static void main(String[] args) {
		int f = 10, e = 2;
		System.out.println(eggDrop(f, e));
	}
	// 9 -> 55 for binary strings

	private static int eggDrop(int f, int e) {
		int[][] table = new int[e + 1][f + 1];

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				// in case of 0 eggs
				if (i == 0) {
					table[i][j] = 0;
				}
				// in case of 0th floor
				else if (j == 0) {
					table[i][j] = 0;
				}
				// in case of 1 egg , answer is floor
				else if (i == 1) {
					table[i][j] = j;
				}
				// Otherwise
				else {
					table[i][j] = Integer.MAX_VALUE;
					for (int k = 1; k <= j; k++) {
						int survives = table[i][j - k];
						int breaks = table[i - 1][k - 1];
						int wo = Math.max(survives, breaks);
						table[i][j] = Math.min(wo, table[i][j]);
					}

					table[i][j] += 1;
				}
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
		return table[e][f];
	}

}
