package BinarySearch;

public class T1_sqrt {
	public int mySqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		int l = 0;
		int h = x;
		int ans = -1;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (mid > x / mid) {
				h = mid - 1;
			} else if (mid <= x / mid) {
				l = mid + 1;
				ans = mid;
			}
		}

		// l>h
		return ans;
	}
}
