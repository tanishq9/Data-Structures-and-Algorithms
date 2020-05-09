package DynamicProgramming;

public class RodCutting {

	public static void main(String[] args) {
		int[] arr = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
			// Cost of single piece, cost of 2 piece together,cost of 3 piece together,.. 4
		// pieces,...5 pieces
		int[] memo = new int[arr.length + 1];
		System.out.println(maxProfit(arr, arr.length, memo));
	}

	private static int maxProfit(int[] cost, int len, int[] memo) {
		if (len == 0) {
			return 0;
		}
		if (memo[len] != 0) {
			return memo[len];
		}
		int ans = Integer.MIN_VALUE;
		for (int i = 1; i <= cost.length; i++) {
			if ((len - i) >= 0) {
				int result = cost[i - 1] + maxProfit(cost, len - i, memo);
				ans = Math.max(ans, result);
			}
		}
		return memo[len] = ans;
	}
}
