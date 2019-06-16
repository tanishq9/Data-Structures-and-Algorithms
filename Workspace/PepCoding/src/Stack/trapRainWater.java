package Stack;

import java.util.Scanner;

public class trapRainWater {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			long[] arr = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			// Left most maximum including the current building
			long[] lb = new long[n];
			lb[0] = arr[0];
			for (int i = 1; i < n; i++) {
				lb[i] = Math.max(lb[i - 1], arr[i]);
			}
			// Right most maximum including the current building
			long[] rb = new long[n];
			rb[n - 1] = arr[n - 1];
			for (int i = n - 2; i >= 0; i--) {
				rb[i] = Math.max(rb[i + 1], arr[i]);
			}
			// Fill with water
			int total = 0;
			for (int i = 0; i < n; i++) {
				total += Math.min(rb[i], lb[i]) - arr[i];
			}
			System.out.println(total);
		}
	}

}
