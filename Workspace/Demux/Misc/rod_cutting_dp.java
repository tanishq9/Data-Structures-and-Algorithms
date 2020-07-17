package Recursion_Pep_Online;

public class rod_cutting_dp {
	public static void main(String[] args) {
		int[] cost = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		int[] dp = new int[cost.length];
		System.out.println(topDown(cost, cost.length - 1, dp));
		// not coded bottom up approach as it is very obvious
	}

	static int topDown(int[] cost, int len, int[] cache) {
		if (cache[len] != 0) {
			return cache[len];
		}
		int cut = 1, max = cost[len];
		for (; cut < len; cut++) {
			int part1 = topDown(cost, cut, cache);
			int part2 = topDown(cost, len - cut, cache);
			max = Math.max(max, part1 + part2);
		}
		return cache[len] = max;
	}

}
