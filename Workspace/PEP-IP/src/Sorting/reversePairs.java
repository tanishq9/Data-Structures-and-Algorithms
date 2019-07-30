package Sorting;

import java.util.Arrays;

public class reversePairs {
	static int merge(int[] arr, int lo, int mid, int hi) {
		// https://leetcode.com/problems/count-of-range-sum/discuss/111753/Java-MergeSort-O(n-long-n)-Solution-for-Reverse-Pairs-Count-of-Smaller-after-self-and-Count-of-Range-Sum.-Template-Coding!
		int i = lo, j = mid + 1, k = 0, count = 0;
		int[] temp = new int[hi - lo + 1];
		// count here
		while (i <= mid && j <= hi) {
			if (arr[i] <= (long) 2 * arr[j]) {
				i++;
			} else {
				count += (mid - i + 1);
				j++;
			}
		}
		// reset
		i = lo;
		j = mid + 1;
		// actual merge step
		while (i <= mid && j <= hi) {
			if (arr[i] > arr[j]) {
				temp[k++] = arr[j++];
			} else {
				temp[k++] = arr[i++];
			}
		}
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
		while (j <= hi) {
			temp[k++] = arr[j++];
		}

		for (int id = lo; id <= hi; id++) {
			arr[id] = temp[id - lo];
		}
		return count;
	}

	static int sort(int[] nums, int lo, int hi) {
		if (lo >= hi) {
			return 0;
		}
		int mid = (lo + hi) / 2;
		int lhalf = sort(nums, lo, mid);
		int rhalf = sort(nums, mid + 1, hi);
		return lhalf + rhalf + merge(nums, lo, mid, hi);
	}

	public static int reversePairs(int[] nums) {
		int ans = sort(nums, 0, nums.length - 1);
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 3, 1 };
		reversePairs(arr);
		System.out.println(Arrays.toString(arr));
	}
}
