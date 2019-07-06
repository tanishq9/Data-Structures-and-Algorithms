package HashMap;

import java.util.HashMap;
import java.util.Scanner;

public class pairSumMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int sum = sc.nextInt();
			int[][] mat1 = new int[n][n];
			int[][] mat2 = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat1[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mat2[i][j] = sc.nextInt();
				}
			}
			System.out.println(pairs(mat1, mat2, sum));
		}
	}

	static int pairs(int[][] mat1, int[][] mat2, int sum) {
		int n = mat1.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map.put(mat1[i][j], map.getOrDefault(mat1[i][j], 0) + 1);
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int cp = sum - mat2[i][j];
				if (map.containsKey(cp)) {
					count += map.get(cp);
				}
			}
		}
		return count;
	}
}
