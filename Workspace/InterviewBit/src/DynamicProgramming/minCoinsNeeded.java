package DynamicProgramming;

public class minCoinsNeeded {

	private static int minCoins(int amount, int[] coins, int[] memo) {
		if (amount == 0) {
			return 0;
		}
		if (memo[amount] != 0) {
			return memo[amount];
		}
		int minSteps = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if ((amount - coins[i]) >= 0) {
				int stepsTaken = minCoins(amount - coins[i], coins, memo);
				minSteps = Math.min(1 + stepsTaken, minSteps);
			}
		}
		return memo[amount] = minSteps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount = 2225;
		int[] arr = new int[] { 1, 5, 7, 10 };
		int[] memo = new int[amount + 1];
		System.out.println(minCoins(amount, arr, memo));
	}

}
