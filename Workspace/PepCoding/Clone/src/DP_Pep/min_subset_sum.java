package DP_Pep;

public class min_subset_sum {

	public static void main(String[] args) {
		int[] set = { 1, 5, 7, 12 };
		System.out.println(minDiff(set));
	}

	private static int minDiff(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		int[][] table = new int[arr.length + 1][sum + 1];
		// Meaning of table[i][j] : if sum 'j' possible using 'i' elements
		// from the set
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				// No element and 0 target
				if (i == 0 && j == 0) {
					table[i][j] = 1;
				}
				// No element considered but Non-0 target
				else if (i == 0) {
					table[i][j] = 0;
				}
				// 0 sum is considered
				else if (j == 0) {
					table[i][j] = 1;
				}
				// otherwise
				else {
					// If sum == 'j' is true without including the element
					if (table[i - 1][j] == 1) {
						table[i][j] = 1;
					}
					// If sum == 'j' is true including the current element
					else if (j - arr[i - 1] >= 0 && table[i - 1][j - arr[i - 1]] == 1) {
						table[i][j] = 1;
					}
				}
			}
		}
		int min_diff = Integer.MAX_VALUE, s1_sum = -1, s2_sum = -1;
		// Now , find the minimum possible difference
		for (int j = 0; j <= sum / 2; j++) {
			// Minimize the difference between sum/2 and total sum
			if (table[arr.length][j] == 1) {
				if (Math.abs(j - sum / 2) < min_diff) {
					min_diff = Math.abs(j - sum / 2);
					s1_sum = j;
				}
			}
		}
		s2_sum = sum - s1_sum;
		System.out.println(s1_sum);
		System.out.println(s2_sum);
		return s2_sum - s1_sum;
	}

}
