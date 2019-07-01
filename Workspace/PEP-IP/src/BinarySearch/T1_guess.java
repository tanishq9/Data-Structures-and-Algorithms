package BinarySearch;

public class T1_guess {
	public int guessNumber(int n) {
		int l = 1, h = n;
		while (l <= h) {
			int mid = l + (h - l) / 2;
			if (guess(mid) == 1) {
				l = mid + 1;
			} else if (guess(mid) == -1) {
				h = mid - 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
	/*
	 * The guess API is defined in the parent class GuessGame.
	 * 
	 * @param num, your guess
	 * 
	 * @return -1 if my number is lower, 1 if my number is higher, otherwise return
	 * 0 int guess(int num);
	 */

	int guess(int num) {
		return 1;
	}
}
