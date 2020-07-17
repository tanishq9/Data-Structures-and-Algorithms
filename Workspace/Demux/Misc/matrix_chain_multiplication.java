package Recursion_Pep_Online;

public class matrix_chain_multiplication {
	public static void main(String[] args) {
		int[] dims = { 10, 20, 30, 40, 50, 60 };
		int[][] dp = new int[dims.length][dims.length];
		System.out.println(mcm(dims, 0, dims.length - 1, dp));
		System.out.println(mcm_bottomUp(dims));
	}

	static int counter = 0;

	static int mcm(int[] dims, int si, int ei, int[][] dp) {
		if (si + 1 == ei) {
			return 0;
		}
		if (dp[si][ei] != 0) {
			return dp[si][ei];
		}
		System.out.println(counter++);
		int min = Integer.MAX_VALUE;
		// cbp is chain break point
		for (int cbp = si + 1; cbp <= ei - 1; cbp++) {
			int lpart = mcm(dims, si, cbp, dp); // dims[si]*dims[cbp] in size
			int rpart = mcm(dims, cbp, ei, dp); // dims[cbp]*dims[ei] in size
			int total = lpart + rpart + dims[si] * dims[cbp] * dims[ei];
			min = Math.min(min, total);
		}
		return dp[si][ei] = min;
	}

	static int mcm_bottomUp(int[] dims) {
		int[][] dp = new int[dims.length][dims.length];

		for (int gap = 0; gap < dims.length; gap++) {
			for (int i = 0, j = i + gap; j < dims.length; i++, j++) {
				if (gap == 0 || gap == 1) {
					dp[i][j] = 0;
				} else {
					int min = Integer.MAX_VALUE;
					for (int cbp = i + 1; cbp <= j - 1; cbp++) {
						int lpart = dp[i][cbp];
						int rpart = dp[cbp][j];
						int total = lpart + rpart + dims[i] * dims[cbp] * dims[j];
						min = Math.min(min, total);
					}
					dp[i][j] = min;
				}
			}
		}

		return dp[0][dims.length - 1];
	}

}
