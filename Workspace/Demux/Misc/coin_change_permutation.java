package Recursion_Pep_Online;

import java.util.ArrayList;

public class coin_change_permutation {
	public static void main(String[] args) {
		int[] coins = { 2, 3, 5, 6 };
		ArrayList<String>[] qb = new ArrayList[11];
		ArrayList<String> output = getPermutations(coins, 10, qb);
		for (String str : output) {
			System.out.println(str + "END");
		}
		System.out.println(output.size());
	}

	static ArrayList<String> getPermutations(int[] coins, int target, ArrayList<String>[] qb) {
		if (target < 0) {
			return new ArrayList<>();
		}
		if (target == 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}
		if (qb[target] != null) {
			return qb[target];
		}
		ArrayList<String> mResult = new ArrayList<>();
		for (int i = 0; i < coins.length; i++) {
			ArrayList<String> recResult = getPermutations(coins, target - coins[i], qb);
			for (String str : recResult) {
				mResult.add(str + coins[i] + ",");
			}
		}
		qb[target] = mResult;
		return mResult;
	}

}
