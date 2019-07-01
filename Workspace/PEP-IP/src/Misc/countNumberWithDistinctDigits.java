package Misc;

public class countNumberWithDistinctDigits {
	public int countNumbersWithUniqueDigits(int n) {
		if (n == 0) {
			return 1;
		}
		int ans = 10, currcontri = 9, num = 9;
		while (n-- > 1) {
			currcontri = currcontri * num;
			ans += currcontri;
			num--;
		}
		return ans;
	}
}
