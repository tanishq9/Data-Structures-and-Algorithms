package DP_Pep;

public class targetSum {

	public static void main(String[] args) {
		// Subset sum
		int[] arr = { 2, 3, 5, 6, 1 };
		int targetSum = 7;
		System.out.println(isPossible(arr, targetSum));
	}

	private static int isPossible(int[] arr, int targetSum) {
		int[][] table = new int[arr.length + 1][targetSum + 1];
		// Meaning of cell table[i][j] : Is it possible to reach target 'j' using
		// elements
		// from 'i' elements from the array
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				// Zero target with zero elements
				if (i == 0 && j == 0) {
					table[i][j] = 1;
				}
				// Zero target with 1 and all elements
				else if (j == 0) {
					table[i][j] = 1;
				}
				// Target more than zero cannot be achieved by 0 elements considered
				else if (i == 0) {
					table[i][j] = 0;
				} else {
					// We can reach that target without that element so leave the current element
					if (table[i - 1][j] == 1) {
						table[i][j] = 1;
					}
					// We can also reach the target by considering the current element and rest of
					// elements equal to Target-currentElement
					else if ((j - arr[i - 1] >= 0) && (table[i - 1][j - arr[i - 1]] == 1)) {
						table[i][j] = 1;
					}
				}
			}
		}
		// Printing the storage matrix
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				System.out.print(table[i][j] + "\t");
			}
			System.out.println();
		}
		return table[arr.length][targetSum];
	}

}
