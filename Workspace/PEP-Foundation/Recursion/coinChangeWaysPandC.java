package Recursion;

public class coinChangeWaysPandC {

	public static void main(String[] args) {
		int[] coins = { 2, 3, 5, 6 };
		int amount = 313;
		// numPermutations(amount, coins, "");
		// li is the last index
		numCombinations(amount, coins, 0, "");
	}

	static int counter = 0;

	private static void numPermutations(int amount, int[] coins, String sf) {
		if (amount == 0) {
			counter++;
			System.out.println(counter + ".  " + sf + "END");
			return;
		}

		for (int i = 0; i < coins.length; i++) {
			if ((amount - coins[i]) >= 0) {
				numPermutations(amount - coins[i], coins, sf + coins[i] + " , ");
			}
		}
	}

	private static void numCombinations(int amount, int[] coins, int li, String sf) {
		if (amount == 0) {
			counter++;
			System.out.println(counter + ".  " + sf + "END");
			return;
		}

		for (int i = li; i < coins.length; i++) {
			if ((amount - coins[i]) >= 0) {
				numCombinations(amount - coins[i], coins, i, sf + coins[i] + " , ");
			}
		}
	}

}
