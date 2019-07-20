package Array;

public class corporateFlightBookings {
	public int[] corpFlightBookings(int[][] bookings, int n) {
		int[] rs = new int[n];
		for (int[] booking : bookings) {
			int l = booking[0] - 1;
			int r = booking[1] - 1;
			int val = booking[2];
			rs[l] += val;
			if (r + 1 < n) {
				rs[r + 1] += -1 * val;
			}
		}
		for (int i = 1; i < n; i++) {
			rs[i] += rs[i - 1];
		}
		return rs;
	}
}
