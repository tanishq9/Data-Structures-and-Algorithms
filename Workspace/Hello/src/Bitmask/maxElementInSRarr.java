package Bitmask;

public class maxElementInSRarr {

	public static void main(String[] args) {
		int[] arr = { 4, 5, 6, 1, 2 };
		int n = 5;
		System.out.println(~(n)+1);
	//	System.out.println(getPivot(arr, 0, arr.length - 1));
	}

	private static int getPivot(int[] arr, int low, int high) {
		while (low <= high) {
			int mid = (low + high) / 2;
			// Property of SR array which is used to find the mid
			if (arr[mid] < arr[mid - 1]) {
				return mid - 1;
				// Property of SR array which is used to find the mid
			} else if (arr[mid] > arr[mid + 1]) {
				return mid;
			}
			// Else pivot lies in unsorted array
			// so search for pivot in the unsorted array
			else if (arr[mid] >= arr[high]) {
				low = mid + 1;
			} else if (arr[mid] <= arr[low]) {
				high = mid - 1;
			}
		}
		return 0;
	}
}
