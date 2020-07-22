package Arr;

public class painterPartition {

	private static boolean isValidate(int[] arr, int mid, int k) {
		int currentPainters = 1, currentWork = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((currentWork + arr[i]) > mid) {
				currentPainters++;
				currentWork = arr[i];
				if (currentPainters > k) {
					return false;
				}
			} else {
				currentWork += arr[i];
			}
		}
		return true;
	}

	private static int minTime(int[] arr, int k) {
		int start = arr[0], end = 0, mid = 0, finalAns = 0;
		for (int i = 0; i < arr.length; i++) {
			end += arr[i];
		}
		while (start <= end) {
			mid = (start + end) / 2;
			if (isValidate(arr, mid, k)) {
				finalAns = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return finalAns;
	}

	public static void main(String[] args) {
		int[] arr = { 10, 20, 60, 50, 30, 40 };
		int k = 3;
		System.out.println(minTime(arr, k));
	}

}
