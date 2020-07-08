class Solution {
    public int change(int target, int[] coins) {
        int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j <= target; j++) {	
        		dp[j] += dp[j - coins[i]];
			}
		}
		return dp[target];
    }
}