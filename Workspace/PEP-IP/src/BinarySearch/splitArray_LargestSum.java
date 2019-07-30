package BinarySearch;

public class splitArray_LargestSum {
	public int splitArray(int[] arr, int k) {
		long sum = 0;
		long max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(arr[i], max);
			sum += arr[i];
		}
		long start = max;
		long end = sum;
		// Following template 2 of Binary search (As suggested on Leetcode)
		while (start < end) {
			long mid = start + (end - start) / 2;
			if (valid(arr, mid, k)) {
				// we will try to optimize further
				// minimize the maximum sum
				// end is also our potential answer
				// cannot do end=mid-1
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		// post processing : start==end
		return (int) end;
	}

	boolean valid(int[] arr, long mid, int k) {
		int count = 1;
		long total = 0;
		for (int num : arr) {
			total += num;
			// mid is the target
			if (total > mid) {
				total = num;
				count++;
				if (count > k) {
					return false;
				}
			}
		}
		return true;
	}
}
