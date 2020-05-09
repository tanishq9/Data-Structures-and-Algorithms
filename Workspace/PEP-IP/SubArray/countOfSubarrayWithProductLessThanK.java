package SubArray;

public class countOfSubarrayWithProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int start = 0;
		int end = 0;
		int product = 1;
		int count = 0;
		while (end < nums.length) {
			product *= nums[end];
			while (start < end && product >= k) {
				product /= nums[start];
				start++;
			}
			if (product < k) {
				count += (1 + end - start);
			}
			end++;
		}
		return count;
	}
}
