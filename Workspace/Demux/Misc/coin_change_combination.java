package Recursion_Pep_Online;

import java.util.ArrayList;

public class coin_change_combination {

	public static void main(String[] args) {
		int[] coins = { 2, 3, 5, 6 };
		ArrayList<String>[][] qb = new ArrayList[11][coins.length];
		ArrayList<String> output = getPermutations(coins, 10, 0, qb);
		for (String str : output) {
			System.out.println(str + "END");
		}
		System.out.println(output.size());
	}

	static ArrayList<String> getPermutations(int[] coins, int target, int index, ArrayList<String>[][] qb) {
		if (target < 0) {
			return new ArrayList<>();
		}
		if (target == 0) {
			ArrayList<String> baseResult = new ArrayList<>();
			baseResult.add("");
			return baseResult;
		}
		if (qb[target][index] != null) {
			return qb[target][index];
		}
		ArrayList<String> mResult = new ArrayList<>();
		for (int i = index; i < coins.length; i++) {
			ArrayList<String> recResult = getPermutations(coins, target - coins[i], i, qb);
			for (String str : recResult) {
				mResult.add(str + coins[i] + ",");
			}
		}
		qb[target][index] = mResult;
		return mResult;
	}

}
