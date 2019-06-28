package Array;

public class isMonotonic {
	class Solution {

		public boolean isMonotonicBetter(int[] A) {
			int inc = 1;
			int dec = 1;
			for (int i = 1; i < A.length; i++) {
				if (A[i] > A[i - 1]) {
					inc++; // Increase the length of increasing sequence
				} else if (A[i] < A[i - 1]) {
					dec++; // Increase the length of decreasing sequence
				} else {
					inc++;
					dec++;
				}
			}
			return inc == A.length || dec == A.length;
		}

		public boolean isMonotonic(int[] A) {
			// One length sequence is always true
			if (A.length == 1) {
				return true;
			}
			int i = 0;
			// Skip until you find first 2 unique elements
			while (i + 1 < A.length && A[i] == A[i + 1]) {
				i++;
			}
			if (i == A.length - 1) {
				return true;
			}
			boolean inc = true;
			if (A[i] > A[i + 1]) {
				inc = false;
			} else {
				inc = true;
			}
			while (i + 1 < A.length) {
				if (inc == false) {
					if (A[i] > A[i + 1]) {
						i++;
					} else if (A[i] == A[i + 1]) {
						// Skip until equal
						while (i + 1 < A.length && A[i] == A[i + 1]) {
							i++;
						}
					} else {
						return false;
					}
				} else {
					if (A[i] < A[i + 1]) {
						i++;
					} else if (A[i] == A[i + 1]) {
						// Skip until equal
						while (i + 1 < A.length && A[i] == A[i + 1]) {
							i++;
						}
					} else {
						return false;
					}
				}
			}
			if (i == A.length - 1) {
				return true;
			}
			return false;
		}
	}
}
