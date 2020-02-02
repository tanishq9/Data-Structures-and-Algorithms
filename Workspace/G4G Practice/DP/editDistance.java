/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0){
		    int m = sc.nextInt();
		    int n = sc.nextInt();
		    String str1 = sc.next();
		    String str2 = sc.next();
            System.out.println(edit(str1,str2));
		    t--;
		}
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

		return table[str1.length()][str2.length()];
	}
	
}
