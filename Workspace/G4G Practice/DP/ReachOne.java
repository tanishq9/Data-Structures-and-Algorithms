package DynamicProgramming;

public class ReachOne {
	static int[] memo = new int[100000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reach(1000));
	}

	static int reach(int n) {
		if (n == 1) {
			return 0;
		}
		int by2 = Integer.MAX_VALUE, by3 = Integer.MAX_VALUE;
		if (memo[n] != 0) {
			return memo[n];
		}
		if (n % 2 == 0) {
			by2 = 1 + reach(n / 2);
		}
		if (n % 3 == 0) {
			by3 = 1 + reach(n / 3);
		}
		memo[n] = Math.min(Math.min(by2, by3), 1 + reach(n - 1));
		return memo[n];
	}
}
