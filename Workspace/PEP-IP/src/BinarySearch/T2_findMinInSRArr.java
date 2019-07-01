package BinarySearch;

public class T2_findMinInSRArr {
	public int findMin(int[] arr) {
		int lo = 0, hi = arr.length - 1;
		while (lo + 1 < hi) {
			int mid = lo + (hi - lo) / 2;
			if (arr[mid] > arr[hi]) {
				// minimum lies in the 2nd part
				lo = mid;
			} else if (arr[mid] < arr[hi]) {
				// minimum lies in 1st part
				hi = mid;
			}
		}
		return Math.min(arr[lo], arr[hi]);
	}
	
}
