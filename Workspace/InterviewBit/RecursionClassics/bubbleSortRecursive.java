package RecursionClassics;

public class bubbleSortRecursive {

	public static void main(String[] args) {
		int[] arr = { 2, 9, 1, 4, 5, 3 };
		// bubbleSort(arr, arr.length);
		bubbleSort2(arr, 0, arr.length);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	private static void bubbleSort(int[] arr, int n) {
		if (n == 1) {
			return;
		}
		for (int i = 0; i <= n - 2; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
			}
		}
		bubbleSort(arr, n - 1);
	}

	private static void bubbleSort2(int[] arr, int j, int n) {
		if (n == 1) {
			return;
		}
		if (j == n - 1) {
			bubbleSort2(arr, 0, n - 1);
			return;
		}
		if (arr[j] > arr[j + 1]) {
			int temp = arr[j];
			arr[j] = arr[j + 1];
			arr[j + 1] = temp;
		}
		bubbleSort2(arr, j + 1, n);
		return;
	}
}
