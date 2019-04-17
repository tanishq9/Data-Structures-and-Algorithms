package IBit;

public class rotationsINSRarr {

	public static void main(String[] args) {
		int[] arr = { 11, 12, 15, 18, 2, 5, 6, 7 };
		System.out.println(numRotations(arr, arr.length));
	}

	static int val = 5;

	private static int numRotations(int[] arr, int n) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			if (arr[low] < arr[high]) {
				return low;
			}
			int mid = (low + high) / 2;
			int next = (mid + 1) % n;
			int prev = (mid - 1 + n) % n;
			if (arr[prev] <= arr[mid] && arr[mid] <= arr[next]) {
				return mid;
			} else {
				if (arr[mid] <= arr[high]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return -1;
	}

}
