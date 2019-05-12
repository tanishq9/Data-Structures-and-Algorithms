package DP;

public class stepsTaken {

	public static void main(String[] args) {
		int n = 10;
		int[] qb = new int[n + 1];
		long startTime = System.currentTimeMillis();
		System.out.println(climbStairs(n, qb));
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
		System.out.println(climbTabulation(n));
	}

	private static int climbStairs(int n, int[] qb) {
		if (n == 0) {
			return 1;
		}
		int ans = 0;
		for (int i = 1; i <= 3; i++) {
			ans += climbStairs(n - i, qb);
		}
		return qb[n] = ans;
	}

	private static int climbTabulation(int n) {
		int[] qb = new int[n + 1];
		// Initial seed
		qb[0] = 1;
		qb[1] = 1;
		qb[2] = 2;
		for (int i = 3; i <= n; i++) {
			qb[i] = qb[i - 1] + qb[i - 2] + qb[i - 3];
		}
		return qb[n];
	}

}
