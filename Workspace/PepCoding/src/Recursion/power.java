package Recursion;

public class power {
	public static void main(String[] args) {
		int x = 13, n = 41;

		int start = (int) System.currentTimeMillis();
		System.out.println(smartPower(x, n));
		int end = (int) System.currentTimeMillis();
		System.out.println(end - start);

		start = (int) System.currentTimeMillis();
		System.out.println(stupidPower(x, n));
		end = (int) System.currentTimeMillis();
		System.out.println(end - start);

		// System.out.println(factorial(6));
	}

	// Faith : fact(5) = 5 * fact(4) i.e 4 * 3 * 2 * 1
	private static int factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	private static int stupidPower(int x, int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x;
		}
		return x * stupidPower(x, n - 1);
	}

	private static int smartPower(int x, int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x;
		}
		int p = smartPower(x, n / 2);
		if ((n & 1) == 1) {
			return p * p * x;
		} else {
			return p * p;
		}
	}
}
