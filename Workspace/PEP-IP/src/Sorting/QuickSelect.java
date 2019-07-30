package Sorting;

public class QuickSelect {

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static int getPivot(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low, j = low;
		while (j <= high) {
			if (arr[j] <= pivot) {
				swap(arr, i, j);
				i++;
			}
			j++;
		}
		return i - 1;
	}

	static int quickSelect(int[] arr, int low, int high, int k) {
		if (low > high) {
			return -1;
		}
		int pivotIndex = getPivot(arr, low, high);
		if (pivotIndex - low + 1 == k) {
			return arr[pivotIndex];
		} else if (pivotIndex - low + 1 < k) {
			return quickSelect(arr, pivotIndex + 1, high, k - pivotIndex + low - 1);
		} else {
			return quickSelect(arr, low, pivotIndex - 1, k);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 9, 8, 3, 1, 7, 9, 2, 6 };
		int k = 2;
		System.out.println(quickSelect(arr, 0, arr.length - 1, k));
	}
}
