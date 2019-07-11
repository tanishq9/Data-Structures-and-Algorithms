package DP_Revisited;

import java.util.ArrayList;

public class permutationsMemoized {

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 6 };
		System.out.println(ccpm(arr, 10, new ArrayList[11]));
	}

	public static ArrayList<String> ccpm(int[] denoms, int amt, ArrayList<String>[] qb) {
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

		if (qb[amt] != null) {
			return qb[amt];
		}

		ArrayList<String> myresult = new ArrayList<>();
		for (int i = 0; i < denoms.length; i++) {
			ArrayList<String> recresult = ccpm(denoms, amt - denoms[i], qb);
			for (String rstr : recresult) {
				String mstr = rstr + denoms[i];
				myresult.add(mstr);
			}
		}
		qb[amt] = myresult;
		return myresult;
	}
}
