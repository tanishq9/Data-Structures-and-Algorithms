package IBIT;

public class quickSelect {

	private static void shuffleArray(int[] arr) {
		for (int i = arr.length - 1; i >= 0; i--) {
			int randomPosition = (int) (Math.random() * 50 + 1); // To get random number between 1 and 50
			randomPosition = randomPosition % (i + 1);
			swap(arr, randomPosition, i);
		}
	}

	private static int getPivot(int[] arr, int start, int end) {
		int j = -1;
		int pivot = arr[end];
		for (int i = 0; i < end; i++) {
			if (arr[i] < pivot) {
				j += 1;
				swap(arr, i, j);
			}
		}
		swap(arr, j + 1, end);
		return j + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void quickSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		} else {
			int pivot = getPivot(arr, start, end);
			quickSort(arr, start, pivot - 1);
			quickSort(arr, pivot + 1, end);
		}
	}

	private static int quickSelect(int[] arr, int l, int r, int k) {
		if (k > 0 && k <= (r - l + 1)) {
			int pos = getPivot(arr, l, r);
			if (pos - l > (k - 1)) {
				return quickSelect(arr, l, pos - 1, k);
			} else if (pos - l < (k - 1)) {
				return quickSelect(arr, pos + 1, r, k - pos + l - 1);
			}
			return arr[pos];
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 5, 4, 3, 1, 9, 2, 10 };
		// shuffleArray(arr);
		/*
		 * for (int i = 0; i < arr.length; i++) { System.out.print(arr[i] + " "); }
		 * System.out.println(); quickSort(arr, 0, arr.length - 1);
		 */

		int k = 3;
		System.out.println(quickSelect(arr, 0, arr.length - 1, k));

		/*
		 * for (int i = 0; i < arr.length; i++) { System.out.print(arr[i] + " "); }
		 */
	}

}
