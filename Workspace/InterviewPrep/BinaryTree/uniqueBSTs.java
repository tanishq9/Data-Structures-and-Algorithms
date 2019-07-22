package BinaryTree;

public class uniqueBSTs {
	public static int numTrees(int n) {
		// write your code here.
		int[] catalan = new int[n + 1];
		catalan[0] = 1;
		catalan[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				catalan[i] += catalan[j - 1] * catalan[i - j];
			}
		}
		return catalan[n];
	}
}
