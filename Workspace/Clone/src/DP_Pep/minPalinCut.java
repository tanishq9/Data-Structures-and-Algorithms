package DP_Pep;

public class minPalinCut {

	public static void main(String[] args) {
		String str = "ababbbabbababa";
		System.out.println(mpc(str));
	}

	public static int mpc(String str) {
		boolean[][] isPalin = new boolean[str.length()][str.length()];
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); j++, i++) {
				if (gap == 0) {
					isPalin[i][j] = true;
				} else if (gap == 1) {
					isPalin[i][j] = str.charAt(i) == str.charAt(j);
				} else {
					isPalin[i][j] = str.charAt(i) == str.charAt(j) && isPalin[i + 1][j - 1] == true;
				}
			}
		}
		for (int i = 0; i < isPalin.length; i++) {
			for (int j = 0; j < isPalin[0].length; j++) {
				if (isPalin[i][j] == true) {
					System.out.print("T ");
				} else {
					System.out.print("F ");
				}
			}
			System.out.println();
		}
		System.out.println();
		int[][] minPalinCut = new int[str.length()][str.length()];
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					minPalinCut[i][j] = 0;
				} else if (gap == 1) {
					minPalinCut[i][j] = isPalin[i][j] == true ? 0 : 1;
				} else {
					// If it is already a palindrome , then no cut
					if (isPalin[i][j] == true) {
						minPalinCut[i][j] = 0;
					}
					// If it not a palindrome then find minimum palindromic cut
					else {
						int minValue = Integer.MAX_VALUE;
						// cut tells number of cuts which can be made on a given string
						for (int cut = 1; cut <= gap; cut++) {
							int firstPart = minPalinCut[i][i + cut - 1];
							int secondPart = minPalinCut[i + cut][j];
							minValue = Math.min(minValue, firstPart + secondPart + 1);
						}
						minPalinCut[i][j] = minValue;
					}
				}
			}
		}
		for (int i = 0; i < minPalinCut.length; i++) {
			for (int j = 0; j < minPalinCut[0].length; j++) {
				System.out.print(minPalinCut[i][j] + " ");
			}
			System.out.println();
		}
		return minPalinCut[0][str.length() - 1];
	}
}
