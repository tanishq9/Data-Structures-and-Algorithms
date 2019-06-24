package Misc;

public class minLenSubarrHavingSumS {
	class Solution {
		public int minSubArrayLen(int s, int[] arr) {
			int start = 0;
			int end = 0;
			int sum = 0;
			int max = Integer.MAX_VALUE;
			boolean valid = false;
			while (end < arr.length) {
				sum += arr[end];
				if (sum >= s)
					valid = true;
				while (valid == true) {
					sum -= arr[start];
					if (sum < s)
						valid = false;
					max = Math.min(max, end - start + 1);
					start++;
				}
				end++;
			}
			if (max == Integer.MAX_VALUE)
				return 0;
			return max;
		}
	}
}
