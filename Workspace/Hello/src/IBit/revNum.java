package IBit;

public class revNum {

	public class Solution {
		public int reverse(int A) {
			if (A > Integer.MAX_VALUE || A < Integer.MIN_VALUE) {
				return 0;
			}
			int num = Math.abs(A);
			int res = 0, prev_res = 0;
			while (num != 0) {
				int rem = num % 10;
				res = res * 10 + rem;
				if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
					return 0;
				}
				if ((res - rem) / 10 != prev_res) {
					return 0;
				}
				prev_res = res;
				num = num / 10;
			}
			if (A < 0) {
				return res * -1;
			}
			if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
				return 0;
			}
			return res;
		}
	}

}
