package BinarySearch;

public class T1_searchInRotatedArray {
	// Template #1 is used to search for an element or condition which can be
	// determined by accessing a single index in the array.
	// Search Condition can be determined without comparing to the element's
	// neighbors (or use specific elements around it)
	class Solution {
		public int search(int[] arr, int target) {
			int start = 0, end = arr.length - 1;
			// judgement only on the basis of sorted part
			while (start <= end) {

				int mid = (start + end) / 2;
				// Found the target
				if (arr[mid] == target) {
					return mid;
				}
				// Left part is sorted
				else if (arr[start] <= arr[mid]) {
					// target also lies in left half
					if (arr[start] <= target && target <= arr[mid]) {
						end = mid - 1;
					}
					// or target lies in the right half
					else {
						start = mid + 1;
					}
				}
				// Right part is sorted
				else if (arr[mid] <= arr[end]) {
					// target also lies in right half
					if (arr[mid] <= target && target <= arr[end]) {
						start = mid + 1;
					}
					// target lies in the left half
					else {
						end = mid - 1;
					}
				}
			}
			return -1;
		}
	}
}
