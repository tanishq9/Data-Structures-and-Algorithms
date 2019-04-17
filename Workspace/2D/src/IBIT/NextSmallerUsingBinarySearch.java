package IBIT;

class GfG {

	// Java program to find first element that
	// is strictly greater than given target.  
	private static int next(int[] arr, int start, int end, int target) {
		int mid = 0;
		int ans = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			// Move to the left side if the target is smaller
			if (arr[mid] >= target) {
				end = mid - 1;
			}
			// Move right side
			else {
				ans = mid;
				start = mid + 1;
			}
		}
		return arr[ans];
	}
	// Driver code
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 8, 12 };
		System.out.println(next(arr, 0, arr.length - 1, 5));
	}

}
