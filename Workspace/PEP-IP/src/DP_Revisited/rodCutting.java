package DP_Revisited;

public class rodCutting {
	public static void main(String[] args) {
		int[] cost = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		System.out.println(rc(cost));
	}

	static int rc(int[] cost) {
		int[] dp = new int[cost.length];
		String[] path = new String[cost.length];
		dp[0] = 0;
		dp[1] = cost[1];
		path[0] = "";
		path[1] = 1 + "";
		for (int i = 2; i < cost.length; i++) {
			dp[i] = cost[i]; // sell as a whole
			path[i] = i + "";
			int s = 1, e = i - 1;
			while (s <= e) {
				if (dp[s] + dp[e] > dp[i]) {
					dp[i] = dp[s] + dp[e];
					path[i] = path[s] + path[e] + "";
				}
				s++;
				e--;
			}
		}
		System.out.println(cost.length - 1);
		System.out.println(path[cost.length - 1]);
		return dp[cost.length - 1];
	}

}
