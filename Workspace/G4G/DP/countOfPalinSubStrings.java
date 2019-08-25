/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t!=0){
		    int len = sc.nextInt();
		    String str = sc.next();
		    System.out.println(ways(str));
		    t--;
		}
	}
    private static int ways(String str) {
        int count = 0;
		boolean[][] strg = new boolean[str.length()][str.length()];
		// Meaning of strg[i][j] : whether string from i to j is palindrome or not
		for (int gap = 0; gap < str.length(); gap++) {
			for (int i = 0, j = i + gap; j < str.length(); i++, j++) {
				if (gap == 0) {
					strg[i][j] = true;
				} else if (gap == 1) {
					if (str.charAt(i) == str.charAt(j)) {
						strg[i][j] = true;
					}
				} else {
					if (str.charAt(i) == str.charAt(j) && strg[i + 1][j - 1] == true) {
						strg[i][j] = true;
					}
				}
				if (strg[i][j] == true && gap >= 1) {
					count++;
				}
			}
		}
		return count;
	}

}

