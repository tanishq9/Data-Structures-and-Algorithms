package BinarySearch;

public class powerXN {
	public double myPow(double x, int n) {
		if (n == 0) {
			return 1;
		} else if (n == 1) {
			return x;
		} else if (n == -1) {
			return 1 / x;
		}
		double rr = myPow(x, n / 2);
		if (n > 0) {
			if (n % 2 == 0) {
				return rr * rr;
			} else {
				return rr * rr * x;
			}
		} else {
			if (n % 2 == 0) {
				return rr * rr;
			} else {
				return rr * rr * 1 / x;
			}
		}
	}
}
