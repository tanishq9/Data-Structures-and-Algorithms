package DynamicProgramming;

import java.util.ArrayList;

public class WineProfit {

	static int count = 0;
	static int memo[][] = new int[100][100];

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 1, 4 };
		System.out.println(profit(arr, 0, arr.length - 1, 1));
		System.out.println(count);
		ArrayList<Integer> list = new ArrayList<>();
	
	}

	static int profit(int[] arr, int i, int j, int yr) {
		count++;
		if (i > j) {
			return 0;
		}
		if (memo[i][j] != 0) {
			return memo[i][j];
		}
		int case1 = arr[i] * yr + profit(arr, i + 1, j, yr + 1);
		int case2 = arr[j] * yr + profit(arr, i, j - 1, yr + 1);
		return memo[i][j] = Math.max(case1, case2);
	}

}
