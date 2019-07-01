package BinarySearch;

public class T2_peak {
	public int findPeakElement(int[] arr) {
		// 1 2 3 5 6 8 7
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] > arr[mid + 1]) {
				// since mid is a potential answer , we won't do hi = mid-1
				right = mid; // 1 3 2
			} else if (arr[mid] <= arr[mid + 1]) {
				// since mid cannot be the potential answer therefore we do start = mid+1
				left = mid + 1;
			}
		}
		// post processing
		// left == right
		return left;
	}
	// Post-processing:
	// End Condition: left == right
}
