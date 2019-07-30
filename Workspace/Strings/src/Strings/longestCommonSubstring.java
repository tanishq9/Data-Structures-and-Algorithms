package Strings;

public class longestCommonSubstring {

	public static void main(String[] args) {
		String s2 = "lclc";
		String s1 = "clcl";
		int[][] matrix = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				matrix[i][j] = 0;
			}
		}
		int max = -1;
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					if (i > 0 && j > 0 && matrix[i - 1][j - 1] >= 1) {
						matrix[i][j] = matrix[i - 1][j - 1] + 1;
					} else {
						matrix[i][j] = 1;
					}
				}
				if (matrix[i][j] > max) {
					max = matrix[i][j];
				}
			}
		}
		/*
		 * for (int i = 0; i < s1.length(); i++) { for (int j = 0; j < s2.length(); j++)
		 * { System.out.print(matrix[i][j] + " "); } System.out.println(); }
		 */
		System.out.println(max);
		int s = 0, e = 0;
		Boolean flag = true;
		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (matrix[i][j] == max) {
					s = i;
					e = j;
					flag = false;
				}
			}
			if (flag = false) {
				break;
			}
		}
		while (s >= 0 && e >= 0) {
			System.out.print(s1.charAt(e));
			s--;
			e--;
		}
	}
}
