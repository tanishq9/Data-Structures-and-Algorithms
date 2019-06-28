package Misc;

public class findConsequetiveOnesOneFlipAllowed {
	public static int findMaxConsecutiveOnes(int[] arr) {
		// write your code here.
		int start = 0;
		int end = 0;
		int len = 0;
		int zeros = 0;
		while (end < arr.length) {
			if (arr[end] == 1) {
				// Update length till it is valid
				len = Math.max(len, end - start + 1);
				end++;
				continue;
			} else if (arr[end] == 0) {
				if (zeros == 0) {
					// Update length since it is valid to have one zero
					zeros++;
					len = Math.max(len, end - start + 1);
					end++;
					continue;
				} else if (zeros == 1) {
					// Now, it is invalid so increment start till we reach first 0
					while (arr[start] != 0) {
						start++;
					}
					start++; // skip that zero
					zeros--;
				}
			}
		}
		return len;
	}
}
