package RecursionClassics;

public class MergeSort {

	public static void merge(int[] arr, int s, int e) {
		int start1 = s;
		int mid = (s + e) / 2;
		int start2 = mid + 1;
		int k = 0; // used for copying later
		int[] temp = new int[e - s + 1];
		while (start1 <= mid && start2 <= e) {
			if (arr[start1] > arr[start2]) {
				temp[k++] = arr[start2++];
			} else if (arr[start1] <= arr[start2]) {
				temp[k++] = arr[start1++];
			}
		}
		while (start1 <= mid) {
			temp[k++] = arr[start1++];
		}
		while (start2 <= e) {
			temp[k++] = arr[start2++];
		}
		for (int i = s; i <= e; i++) {
			arr[i] = temp[i - s];
		}
	}

	public static void mergeSort(int[] arr, int s, int e) {
		if (s == e) {
			return;
		}
		int mid = (s + e) / 2;
		mergeSort(arr, s, mid);
		mergeSort(arr, mid + 1, e);
		merge(arr, s, e);
	}

	public static void main(String[] args) {
		int arr[] = { 3, 1, 5, 2, 10 };
		mergeSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
