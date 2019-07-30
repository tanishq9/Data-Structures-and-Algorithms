package Array;

public class consequetiveOnesKflips {
	public int longestOnes(int[] arr, int k) {
		int zeros = k;
		int start = 0;
		int end = 0;
		int len = 0;
		while (end < arr.length) {
			if (arr[end] == 1) {
				// Since, it is valid
				// So, update the maximum length
				len = Math.max(len, end - start + 1);
				end++; // acquire more
			} else if (arr[end] == 0) {
				if (zeros > 0) {
					// Again, it is valid.
					// So, update the maximum length
					len = Math.max(len, end - start + 1);
					end++; // acquire more
					zeros--; // we used up one zero
				} else if (zeros == 0) {
					// Move start until we spot the first zero in that window
					while (arr[start] != 0) {
						start++; // release
					}
					start++; // skip this zero
					zeros++; // we freed one zero
				}
			}
		}
		return len;
	}
}
