package RecursionClassics;

public class QuickSort {

	public static void shuffle(int[] arr) {
		int i, j;
		for (i = arr.length - 1; i > 0; i--) {
			int random = (int) (Math.random() * 50) + 1;
			j = random % (i + 1);
			swap(arr, i, j);
		}
	}

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

	public static void quickSort(int[] arr, int s, int e) {
		if (s >= e) {
			return;
		}
		int pivot = partition(arr, s, e);
		quickSort(arr, s, pivot - 1);
		quickSort(arr, pivot + 1, e);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 5, 6 };
		shuffle(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
