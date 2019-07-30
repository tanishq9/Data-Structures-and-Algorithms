package DP_Pep;

public class editDistance {

	public static void main(String[] args) {
		String str1 = "Saturday";
		String str2 = "Sunday";
		System.out.println(edit(str1, str2));
	}

	private static int edit(String str1, String str2) {
		int[][] table = new int[str1.length() + 1][str2.length() + 1];
		// Meaning of cell : Minimum number of operations required to convert
		// input string[0,i] to output string[0,j]
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				if (i == 0) {
					table[i][j] = j;
				} else if (j == 0) {
					table[i][j] = i;
				} else {
					if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
						table[i][j] = table[i - 1][j - 1];
					} else {
						int insertion = 1 + table[i - 1][j];
						int remove = 1 + table[i - 1][j - 1];
						int replace = 1 + table[i][j - 1];
						table[i][j] = Math.min(Math.min(insertion, replace), remove);
					}
				}
			}
		}

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				System.out.print(table[i][j] + " ");
			}
			System.out.println();
		}

		return table[str1.length()][str2.length()];
	}

}
