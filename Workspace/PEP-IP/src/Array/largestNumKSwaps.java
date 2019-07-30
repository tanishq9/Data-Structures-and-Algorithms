package Array;

import java.util.Scanner;

public class largestNumKSwaps {

	static String m = "0";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int k = sc.nextInt();
			String str = sc.next();
			m = "0";
			max(str, str.length(), k);
			if (m.equals("0")) {
				sb.append(str + "\n");
			} else {
				sb.append(m + "\n");
			}
		}
		System.out.println(sb.toString());
	}

	static void max(String str, int n, int k) {
		if (k == 0) {
			return;
		}
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (str.charAt(i) < str.charAt(j)) {
					// swap
					char[] strarr = str.toCharArray();
					char temp = strarr[i];
					strarr[i] = strarr[j];
					strarr[j] = temp;
					str = String.valueOf(strarr);
					// compare
					if (str.compareTo(m) > 0) {
						m = str;
					}
					max(str, n, k - 1);
					// reswap : backtracking step
					temp = strarr[i];
					strarr[i] = strarr[j];
					strarr[j] = temp;
					str = String.valueOf(strarr);
				}
			}
		}
	}
}
