package DP_Revisited;

import java.util.ArrayList;

public class combinationsMemoized {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 6 };
		System.out.println(ccm(arr, 19, 0, new ArrayList[20][arr.length]));
	}

	static ArrayList<String> ccm(int[] denoms, int amt, int start, ArrayList<String>[][] qb) {
		if (amt == 0) {
			ArrayList<String> bresult = new ArrayList<>();
			// 0 can be paid in one way
			bresult.add("");
			return bresult;
		}
		if (amt < 0) {
			ArrayList<String> bresult = new ArrayList<>();
			return bresult;
		}
		if (qb[amt][start] != null) {
			return qb[amt][start];
		}
		ArrayList<String> myresult = new ArrayList<>();
		for (int i = start; i < denoms.length; i++) {
			ArrayList<String> recresult = ccm(denoms, amt - denoms[i], i, qb);
			for (String s : recresult) {
				String mystr = s + denoms[i];
				myresult.add(mystr);
			}
		}
		qb[amt][start] = myresult;
		return myresult;
	}

}
