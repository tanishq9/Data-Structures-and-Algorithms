package DynamicProgramming;

public class OptimalGameStrategy {

	public static void main(String[] args) {
		int[] arr = { 7, 2, 3, 10, 1, 9, 8, 12 };
		int[][] memo = new int[arr.length][arr.length];
		// Since we are working on array range so we have to build a 2D array
		System.out.println(maxGain(arr, 0, arr.length - 1, memo));
	}

	private static int maxGain(int[] arr, int i, int j, int[][] memo) {
		if (i >= j) {
			return 0;
		}
		if (memo[i][j] != 0) {
			return memo[i][j];
		}
		int firstMove = arr[i] + Math.min(maxGain(arr, i + 2, j, memo), maxGain(arr, i + 1, j - 1, memo));
		int secondMove = arr[j] + Math.min(maxGain(arr, i + 1, j - 1, memo), maxGain(arr, i, j - 2, memo));
		return memo[i][j] = Math.max(firstMove, secondMove);
	}

}
