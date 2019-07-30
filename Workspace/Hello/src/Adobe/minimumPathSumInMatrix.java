package Adobe;

import java.util.ArrayList;

public class minimumPathSumInMatrix {

	public int minPathSum(ArrayList<ArrayList<Integer>> A) {
		if (A == null || A.size() == 0) {
			return 0;
		}
		int[][] dp = new int[A.size()][A.get(0).size()];
		dp[0][0] = A.get(0).get(0);
		for (int j = 1; j < A.get(0).size(); j++) {
			dp[0][j] = dp[0][j - 1] + A.get(0).get(j);
		}
		for (int i = 1; i < A.size(); i++) {
			dp[i][0] = dp[i - 1][0] + A.get(i).get(0);
		}
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.size(); j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 1; i < A.size(); i++) {
			for (int j = 1; j < A.get(0).size(); j++) {
				dp[i][j] = A.get(i).get(j) + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		for (int i = 0; i < A.size(); i++) {
			for (int j = 0; j < A.get(0).size(); j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return dp[A.size() - 1][A.size() - 1];
	}
}
