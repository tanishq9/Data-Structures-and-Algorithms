package RecursionClassics;

public class QuickSelect {

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int partition(int[] arr, int s, int e) {
		int pivot = arr[e];
		int i = s, j = s - 1;
		for (i = s; i <= e - 1; i++) {
			if (arr[i] <= pivot) {
				j++;
				swap(arr, i, j);
			}
		}
		swap(arr, j + 1, e);
		return j + 1;
	}

	private static int quickselect(int[] arr, int l, int e, int k) {
		if (l >= e) {
			return -1;
		}
		int index = partition(arr, l, e);
		if (index - l == k - 1) {
			return arr[index];
		} else if (index - l > k - 1) {
			return quickselect(arr, l, index - 1, k);
		} else {
			return quickselect(arr, index + 1, e, k - index + l - 1);
		}
	}

	public static void main(String[] args) {
		int[] arr = { 8, 10, 2, 6, 3, 1 };
		int k = 1;
		System.out.println(quickselect(arr, 0, arr.length - 1, k));
	}

}
