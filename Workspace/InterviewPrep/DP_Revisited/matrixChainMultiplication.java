package DP_Revisited;

public class matrixChainMultiplication {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60 };
		System.out.println(mcm(arr));
	}

	public static int mcm(int[] dims) {
		int[][] mcm = new int[dims.length][dims.length];
		// gap 0 does form any matrix : not considering that gap
		// [0,4] implies [0,1] | [1,2,3,4] can be one cut
		// and A(0,1),B(1,2),C(2,3),D(3,4) are considered
		for (int gap = 1; gap < dims.length; gap++) {
			for (int i = 0, j = i + gap; j < dims.length; i++, j++) {
				if (gap == 1) {
					// single matrix cannot be considered for product
					mcm[i][j] = 0;
				} else if (gap == 2) {
					mcm[i][j] = dims[i] * dims[i + 1] * dims[j];
				} else {
					mcm[i][j] = Integer.MAX_VALUE;
					for (int cut = i + 1; cut <= j - 1; cut++) {
						int factor1 = mcm[i][cut];
						int factor2 = mcm[cut][j];
						int common = dims[i] * dims[cut] * dims[j];
						mcm[i][j] = Math.min(mcm[i][j], factor1 + factor2 + common);
					}
				}
			}
		}

		for (int i = 0; i < mcm.length; i++) {
			for (int j = 0; j < mcm[0].length; j++) {
				System.out.print(mcm[i][j] + "\t");
			}
			System.out.println();
		}

		return mcm[0][dims.length - 1];
	}
}
