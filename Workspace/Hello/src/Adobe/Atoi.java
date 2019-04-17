package Adobe;

public class Atoi {

	public class Solution {
		// DO NOT MODIFY THE LIST. IT IS READ ONLY
		public int atoi(String A) {
			int ans = 0;
			Boolean isNegative = false;
			if (A.charAt(0) == '-') {
				isNegative = true;
			}
			for (int i = 0; i < A.length(); i++) {
				if (i == 0 && (A.charAt(i) == '+' || A.charAt(i) == '-')) {
					continue;
				}
				if (A.charAt(i) == ' ' || A.charAt(i) < 48 || A.charAt(i) > 57) {
					break;
				} else {
					ans = ans * 10 + A.charAt(i) - '0';
				}
			}
			if (isNegative == true) {
				if (ans > Integer.MAX_VALUE)
					return -1 * Integer.MAX_VALUE;

				else if (ans < Integer.MIN_VALUE)
					return -1 * Integer.MIN_VALUE;
				else
					return -1 * ans;
			}
			if (ans > Integer.MAX_VALUE)
				return Integer.MAX_VALUE;
			else if (ans < Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			else
				return ans;
		}
	}
}
