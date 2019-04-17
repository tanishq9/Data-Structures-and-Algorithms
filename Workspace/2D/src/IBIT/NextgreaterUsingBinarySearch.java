package IBIT;

public class NextgreaterUsingBinarySearch {

	private static int next(int[] arr, int start, int end, int target) {
		int mid = 0;
		int ans = -1;
		while (start <= end) {
			mid = (start + end) / 2;
			if (arr[mid] <= target) {
				start = mid + 1;
			} else {
				ans = mid;
				end = mid - 1;
			}
		}
		return arr[ans];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 5, 8, 12 };
		System.out.println(next(arr, 0, arr.length - 1, 6));
	}

}
