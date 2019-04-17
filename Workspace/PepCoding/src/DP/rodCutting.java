package DP;

public class rodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] price = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
		// System.out.println(numWays(0, price.length));
		System.out.println(rodCutting(price));
	}

	private static int rodCutting(int[] price) {
		int[] profit = new int[price.length];
		profit[0] = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < price.length; i++) {
			int amount = Integer.MIN_VALUE;
			int start = 1;
			int end = i - 1;
			while (start <= end) {
				amount = Math.max(amount, profit[start] + profit[end]);
				start++;
				end--;
			}
			profit[i] = Math.max(price[i], amount);
			max = Math.max(max, profit[i]);
		}
		return max;
	}

	private static int numWays(int currentLength, int totalLength) {
		if (currentLength == totalLength) {
			return 1;
		}
		if (currentLength > totalLength) {
			return 0;
		}
		int ways = 0;
		for (int i = 1; i < totalLength; i++) {
			ways += numWays(currentLength + i, totalLength);
		}
		return ways;
	}

	/*
	 * private static int rodCutting(int[] price, int currentLength, int
	 * totalLength) { if (currentLength >= totalLength) { return 0; } int profit =
	 * Integer.MIN_VALUE; for (int i = 1; i < totalLength; i++) { int amount =
	 * price[i] + numWays(currentLength + i, totalLength); profit = Math.max(amount,
	 * profit); } return profit; }
	 */

}
