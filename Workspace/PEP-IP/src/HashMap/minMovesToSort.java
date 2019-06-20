package HashMap;

import java.util.Scanner;

public class minMovesToSort {
	public static void minTransfer(int[] h) {
		int[] dp = new int[h.length + 1];
		int max = Integer.MIN_VALUE;
		for (int student : h) {
			dp[student] = dp[student - 1] + 1;
			max = Math.max(max, dp[student]);
		}
		System.out.println(h.length - max);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] heights = new int[n];
		for (int i = 0; i < n; i++) {
			heights[i] = scn.nextInt();
		}
		minTransfer(heights);
	}
}
