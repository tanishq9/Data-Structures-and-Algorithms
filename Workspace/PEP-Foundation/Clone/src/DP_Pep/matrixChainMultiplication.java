package DP_Pep;

public class matrixChainMultiplication {

	public static void main(String[] args) {
		int[] dims = { 10, 20, 30, 40, 50, 60 };
		System.out.println(minOperations(dims));
	}

	public static int minOperations(int[] dims) {
		int[][] mcm = new int[dims.length][dims.length];
		for (int gap = 1; gap < mcm.length; gap++) {
			for (int i = 0, j = i + gap; j < mcm.length; i++, j++) {
				if (gap == 1) {
					mcm[i][j] = 0;
				} else if (gap == 2) {
					mcm[i][j] = dims[i] * dims[i + 1] * dims[j];
				} else {
					int min = Integer.MAX_VALUE;
					for (int cut = 1; cut <= gap - 1; cut++) {
						int fp = mcm[i][i + cut];
						int sp = mcm[i + cut][j];
						int factor = dims[i] * dims[i + cut] * dims[j];
						min = Math.min(min, fp + sp + factor);
					}
					mcm[i][j] = min;
				}
			}
		}
		return mcm[0][mcm.length - 1];
	}

}
